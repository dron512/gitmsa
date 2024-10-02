package com.pmh.ex10.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity,Long> {

    // select * from free_board_file where free_board_idx=?
    List<FileEntity> findByFreeBoardIdx(long freeBoardIdx);

//    @Query("delete * from free_board_file")
//    void deleteAll();
}
