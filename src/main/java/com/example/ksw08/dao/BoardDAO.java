package com.example.ksw08.dao;

import com.example.ksw08.vo.BoardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "boardDAO")
public interface BoardDAO {

    List<BoardVO> selectBoardList();

    BoardVO selectBoard(BoardVO param);
}
