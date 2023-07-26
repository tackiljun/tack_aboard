package org.astro.aboard.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.astro.aboard.dto.PageRequestDTO;
import org.astro.aboard.dto.ReplyDTO;

public interface ReplyMapper {

    // 게시글에서 댓글가져오기.
    List<ReplyDTO> replyList(@Param("page") PageRequestDTO pageRequestDTO, @Param("bno") long bno);
    // 댓글등록.
    int insertReply(ReplyDTO replyDTO);
    // 댓글읽기.
    ReplyDTO readReply(long rno);
    // 댓글삭제.
    int deleteReply(long rno);
    // 댓글수정.
    int modifyReply(ReplyDTO replyDTO);
    // total.
    int total(long bno);
    // gno값 일치유무?
    int updateGno(Long gno);
    // 대댓글인데 -----.
    int insertReplyChild(ReplyDTO replyDTO);


    
}
