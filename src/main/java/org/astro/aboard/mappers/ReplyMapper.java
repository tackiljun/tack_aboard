package org.astro.aboard.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.astro.aboard.dto.PageRequestDTO;
import org.astro.aboard.dto.ReplyDTO;

public interface ReplyMapper {

    List<ReplyDTO> replyList(@Param("page") PageRequestDTO pageRequestDTO, @Param("bno") long bno);
    
}
