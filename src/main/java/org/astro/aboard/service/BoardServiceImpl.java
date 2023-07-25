package org.astro.aboard.service;

import java.util.List;

import org.astro.aboard.dto.BoardDTO;
import org.astro.aboard.dto.PageRequestDTO;
import org.astro.aboard.dto.PageResponseDTO;
import org.astro.aboard.mappers.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    
    
    // @Override
    // public List<BoardDTO> getList() {
        
    //     return boardMapper.getList();
    // }

    @Override
    public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO) {
        
        List<BoardDTO> list = boardMapper.getList(pageRequestDTO);
        long total = boardMapper.listCount(pageRequestDTO);

        return PageResponseDTO.<BoardDTO>withAll().list(list).total(total).build();
    }


    @Override
    public BoardDTO getOne(int bno) {
        
        return boardMapper.getOne(bno);
    }


    @Override
    public int insertOne(BoardDTO boardDTO) {
        
        return boardMapper.insertOne(boardDTO);
    }


    @Override
    public int deleteOne(int bno) {
        
        return boardMapper.deleteOne(bno);
    }


    @Override
    public int modifyOne(BoardDTO boardDTO) {
        
        return boardMapper.modifyOne(boardDTO);
    }


    

    

    

    
    
}
