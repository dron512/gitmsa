package com.pmh.ex08.freeboard;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("freeboard")
@RequiredArgsConstructor
public class FreeBoardController {

    private final FreeBoardRepository freeBoardRepository;

    @GetMapping
    public ResponseEntity<List<FreeBoard>> findALl(){
        List<FreeBoard> list = freeBoardRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<FreeBoard> save(@RequestBody FreeBoardReqDto freeBoardReqDto){

        FreeBoard freeBoard = new ModelMapper().map(freeBoardReqDto,FreeBoard.class);
        System.out.println(freeBoard);

        return ResponseEntity.status(200).body(freeBoard);
    }


}
