package org.astro.aboard.service;

import java.util.List;

import org.astro.aboard.dto.BoardDTO;
import org.astro.aboard.dto.PageRequestDTO;
import org.astro.aboard.dto.PageResponseDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BoardService {

    // 리스트목록.
    //List<BoardDTO> getList();
    PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO);
    // 한개 불러오기.
    BoardDTO getOne(int bno);
    // 등록.
    int insertOne(BoardDTO boardDTO);
    // 삭제.
    int deleteOne(int bno);
    // 수정.
    int modifyOne(BoardDTO boardDTO);
    
}
