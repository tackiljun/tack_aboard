package org.astro.aboard.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    // 번호.
    private Integer bno;
    // 제목.
    private String title;
    // 내용.
    private String content;
    // 작성자.
    private String writer;
    // 등록일.
    private String duedate;
    // 수정일.
    private LocalDate modifyDate;
    
}
