package com.ebook.mylib.dto;

import com.ebook.api.vo.ApiDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyLibDTO {
    private String id;

    private String userId;

    //검색 필터
    private String isbn;

    private ApiDTO apiDTO;

}
