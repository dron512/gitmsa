package com.pmh.ex08.freeboard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreeBoardResponsePageDto {

    private List<FreeBoard> content;
    private int totalElements;
    private int totalPages;
    private int size;

}
