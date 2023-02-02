package com.ebook.api.vo;

import lombok.*;
import org.json.JSONObject;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiDTO {
    private String title;   // 도서 제목
    private String description; // 도서 소개
    private String link;         // 도서 상세 URL
    private String isbn;        // 국제 표준 도서번호
    private String publisher;       // 도서 출판사
    private String author;// 저자 이름
    private String image;       // 도서 표지 미리보기 URL

    //검색필터
    private String type;
    private String Keyword;

    public ApiDTO(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.description = itemJson.getString("description");
        this.link = itemJson.getString("link");
        this.isbn = itemJson.getString("isbn");
        this.image = itemJson.getString("image");
        this.publisher = itemJson.getString("publisher");
        this.author = itemJson.getString("author");


    }
}
