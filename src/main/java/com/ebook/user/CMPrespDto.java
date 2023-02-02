package com.ebook.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CMPrespDto<T> {
    private int code; // 1(성공), -1(실패)
    private String message;
    private T data;
}
