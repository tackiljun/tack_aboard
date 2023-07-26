package org.astro.aboard.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReplyDTO {

    // PK값 - rno.
    private long rno;
    // 게시글번호 - bno.
    @NotNull
    private long bno;
    // 댓글내용.
    @NotEmpty
    private String reply;
    // 댓글작성자.
    @NotEmpty
    private String replyer;
    // 댓글 작성일.
    private LocalDate replydate;
    // 대댓글?
    private long gno = 0L;
    // 대댓글있는지 확인.
    private int step;
}
