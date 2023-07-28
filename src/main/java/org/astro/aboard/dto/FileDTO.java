package org.astro.aboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileDTO {
    
    // pk.
    private String uuid;
    // 파일명.
    private String fileName;
    // 이미지 유무.
    private boolean img;
//////////////////////////////////////////////////
    // 파일 경로 가져오기.
    public String getLink() {
        if (img) {
            return "s_" + uuid + "_" + fileName;
        } else {
            return "default.jpg";
        }
    }
}
