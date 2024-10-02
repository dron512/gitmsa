package com.pmh.ex10.freeboard;

import com.pmh.ex10.error.BizException;
import com.pmh.ex10.error.ErrorCode;
import com.pmh.ex10.file.FileEntity;
import com.pmh.ex10.file.FileRepository;
import com.pmh.ex10.user.User;
import com.pmh.ex10.user.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("freeboard")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class FreeBoardController {

    private final FreeBoardRepository freeBoardRepository;
    private final FileRepository fileRepository;
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Value("${my.value}")
    private String welcome;

    @GetMapping("test")
    public String test() {
        return welcome;
    }

    @GetMapping
    public ResponseEntity<FreeBoardResponsePageDto> findALl(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum
            , @RequestParam(name = "size", defaultValue = "5") int size) {

        Sort sort = Sort.by(Sort.Direction.DESC, "idx");
        Pageable pageable = PageRequest.of(pageNum, size, sort);

        Page<FreeBoard> page = freeBoardRepository.findAll(pageable);
        FreeBoardResponsePageDto freeBoardResponsePageDto = modelMapper.map(page, FreeBoardResponsePageDto.class);

        List<FreeBoardResponseDto> list = freeBoardResponsePageDto
                .getContent()
                .stream()
                .map(freeBoard -> {
                    FreeBoardResponseDto freeBoardResponseDto = modelMapper.map(freeBoard, FreeBoardResponseDto.class);

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm");
                    freeBoardResponseDto.setRegDate(dateTimeFormatter.format(freeBoard.getRegDate()));
                    freeBoardResponseDto.setModDate(dateTimeFormatter.format(freeBoard.getModDate()));

                    freeBoardResponseDto.setCreAuthor(freeBoard.getUser().getName());
                    freeBoardResponseDto.setModAuthor(freeBoard.getUser().getName());
                    freeBoardResponseDto.setUserIdx(freeBoard.getUser().getIdx());

                    return freeBoardResponseDto;
                }).toList();

        freeBoardResponsePageDto.setList(list);
        return ResponseEntity.ok(freeBoardResponsePageDto);
    }

    @GetMapping("view/{idx}")
    public ResponseEntity<FreeBoardResponseDto> findOne(@PathVariable(name = "idx") long idx) {
        // 해당되는 행 찾고...
        FreeBoard freeBoard = freeBoardRepository.findById(idx).orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));
        // 수정 하고...
        freeBoard.setViewCount(freeBoard.getViewCount()+1);
        freeBoardRepository.save(freeBoard);

        FreeBoardResponseDto freeBoardResponseDto = modelMapper.map(freeBoard, FreeBoardResponseDto.class);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm");
        freeBoardResponseDto.setRegDate(dateTimeFormatter.format(freeBoard.getRegDate()));
        freeBoardResponseDto.setModDate(dateTimeFormatter.format(freeBoard.getModDate()));

        freeBoardResponseDto.setCreAuthor(freeBoard.getUser().getName());
        freeBoardResponseDto.setModAuthor(freeBoard.getUser().getName());
        freeBoardResponseDto.setUserIdx(freeBoard.getUser().getIdx());

        return ResponseEntity.ok(freeBoardResponseDto);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
//    @Transactional
    public ResponseEntity<FreeBoard> save(
            @Valid @RequestPart(name = "data") FreeBoardReqDto freeBoardReqDto,
            @RequestPart(name = "file", required = false) MultipartFile file) {

        FreeBoard freeBoard = modelMapper.map(freeBoardReqDto, FreeBoard.class);
        freeBoardRepository.save(freeBoard);
        /*
            1.@Transactional
                메서드에 @Transactional 애노테이션을 추가하여 트랜잭션을 관리하도록 합니다.
                이러면 세션이 열려 있는 동안 모든 작업이 수행되어, detached 상태 문제를 피할 수 있습니다.
                Freeboard에 ToString함수를 직접 만들어야함..

            2. freeboard객체를 영속성으로 하고
                user연결을 나중에 하는 방법
         */
        // Todo...
        // 1번 사용자가 무조건 작성 한걸로..
        // jwt 로그인 하면 ... 로그인한 사용자를 넣을꺼예요
        User user = userRepository.findById(1l).orElse(new User());
        freeBoard.setUser(user);
        freeBoardRepository.save(freeBoard);

        if (file != null) {
            String myFilePath = Paths.get("images/file/").toAbsolutePath() + File.separator + file.getOriginalFilename();
            try {
                File destFile = new File(myFilePath);
                file.transferTo(destFile);
            } catch (Exception e) {
                e.printStackTrace();
            }

            FileEntity fileEntity = new FileEntity();
            fileEntity.setName(file.getOriginalFilename());
            fileEntity.setPath(Paths.get("images/file/").toAbsolutePath().toString());
            fileEntity.setFreeBoard(freeBoard);
            fileRepository.save(fileEntity);
        }else{
//            System.out.println("일로오나");
            freeBoard.setList(null);
            freeBoardRepository.save(freeBoard);

//           database 에서 삭제....
//            List<FileEntity> list = fileRepository.findByFreeBoardIdx(freeBoard.getIdx());
//
//            System.out.println(list);
//            list.forEach(fileEntity -> {
//                // delete * from free_board_file where idx = ?
//                System.out.println("delete 실행전");
//                fileRepository.deleteById(fileEntity.getIdx());
//                System.out.println("delete 실행후");
//            });
        }
        return ResponseEntity.status(200).body(freeBoard);
    }


    @DeleteMapping("delete/{idx}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "idx") long idx) {
        freeBoardRepository.findById(idx).orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));
        freeBoardRepository.deleteById(idx);
        return ResponseEntity.ok("삭제되었습니다.");
    }


}
