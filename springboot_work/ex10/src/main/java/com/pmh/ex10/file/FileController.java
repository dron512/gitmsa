package com.pmh.ex10.file;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

@RestController
@RequestMapping("file")
@CrossOrigin
public class FileController {

    private final Path imagePath;
    private final ModelMapper modelMapper;
    private final FileRepository fileRepository;

    public FileController(ModelMapper modelMapper, FileRepository fileRepository) {
        this.modelMapper = modelMapper;
        this.fileRepository = fileRepository;
        this.imagePath = Paths.get("ex10/images/file/").toAbsolutePath();

        try {
            Files.createDirectories(this.imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @PostMapping(value = "upload",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(
            @RequestPart(name = "file") MultipartFile file,
            @RequestPart(name = "fileDto") FileReqDto fileReqDto) {
        try {
            String myFilePath = imagePath.toAbsolutePath() + "\\" + file.getOriginalFilename();

            File saveFile = new File(myFilePath);
            file.transferTo(saveFile);

            FileEntity fileEntity = modelMapper.map(fileReqDto, FileEntity.class);
            fileRepository.save(fileEntity);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "upload";
    }

}

