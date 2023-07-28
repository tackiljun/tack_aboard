package org.astro.aboard.mappers;

import java.util.List;
import java.util.Map;

public interface FileMapper {

    // 이미지등록.
    int createImg(List<Map<String, String>> imgList);
    // 이지미삭제.
    int deleteImg(int bno);
    // 이미지수정.
    int modifyImg(List<Map<String, String>> imgList);

    
}
