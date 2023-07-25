package org.astro.aboard.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.astro.aboard.dto.BoardDTO;
import org.astro.aboard.dto.PageRequestDTO;

@Mapper
public interface BoardMapper {
    
    // 리스트목록.
    List<BoardDTO> getList(PageRequestDTO pageRequestDTO);
    // 한개 불러오기.
    BoardDTO getOne(int bno);
    // 등록.
    int insertOne(BoardDTO boardDTO);
    // 삭제.
    int deleteOne(int bno);
    // 수정.
    int modifyOne(BoardDTO boardDTO);

    long listCount(PageRequestDTO pageRequestDTO);
}
