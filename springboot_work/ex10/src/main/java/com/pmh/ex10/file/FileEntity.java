package com.pmh.ex10.file;

import com.pmh.ex10.freeboard.FreeBoard;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "freeBoardFile")
public class FileEntity {

    // 기본키 생성...
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;
    private String path;

    private String fileDesc;

    @ManyToOne
    private FreeBoard freeBoard;

}
