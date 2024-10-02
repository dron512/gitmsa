package com.pmh.ex10.freeboard;

import com.pmh.ex10.file.FileEntity;
import com.pmh.ex10.user.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FreeBoardResponseDto {

    private Long idx;
    private String title;
    private String content;

//    private User user;

    private Long userIdx;

    private String creAuthor;
    private String modAuthor;
    private String regDate;
    private String modDate;

    private int viewCount;
    private List<FileEntity> list = new ArrayList<>();

}
