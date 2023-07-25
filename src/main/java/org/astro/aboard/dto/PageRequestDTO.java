package org.astro.aboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class PageRequestDTO {

    // page번호.
    @Builder.Default
    private int page = 1;
    // size.
    @Builder.Default
    private int size = 10;

/////////////////////////////////////////////////////////////////////////    

    //page번호 음수제외.
    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }
    
    //size 음수값, 과도한 값 제외.
    public void setSize(int size) {
        if(size > 100 || size < 0) {
            this.size = 10;
        } else {
            this.size = size;
        }
    }

    //limit에 들어갈 skip계산.
    public int getSkip() {
        return (this.page -1) * this.size;
    }
    // 끝계산.
    public int getEnd() {
        return this.page * this.size;
    }

    //다음페이지를 위한 count.
    public int getCountEnd() {
        int temp = (int) (Math.ceil(this.page/10.0)) * (10 * size);
        return temp + 1;
    }
    
}
