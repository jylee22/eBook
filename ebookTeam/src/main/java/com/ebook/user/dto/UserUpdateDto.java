package com.ebook.user.dto;

import com.ebook.user.vo.UsersVO;
import lombok.Data;

@Data
public class UserUpdateDto {
    private String userId;
    private String userPass;
    private String userName;
    private String userEmail;

    public UsersVO toEntity() {
        return UsersVO.builder()
                .userId(userId)
                .userPass(userPass)
                .userName(userName)
                .userEmail(userEmail)
                .build();
    }
}
