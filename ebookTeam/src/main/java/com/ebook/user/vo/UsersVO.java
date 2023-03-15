package com.ebook.user.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UsersVO {

    @Id
    private String userId;
    private String userIdx;
    @NotEmpty
    private String userPass;
    @NotEmpty
    private String userName;
    private String userEmail;
    private String userPhone;
    private LocalDateTime joinDate;
    private LocalDateTime subDate;
    private LocalDateTime exDate;

    public String getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(String userIdx) {
        this.userIdx = userIdx;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public LocalDateTime getSubDate() {
        return subDate;
    }

    public void setSubDate(LocalDateTime subDate) {
        this.subDate = subDate;
    }

    public LocalDateTime getExDate() {
        return exDate;
    }

    public void setExDate(LocalDateTime exDate) {
        this.exDate = exDate;
    }

    @Override
    public String toString() {
        return "UsersVO{" +
                "userId='" + userId + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", joinDate=" + joinDate +
                ", subDate=" + subDate +
                ", exDate=" + exDate +
                '}';
    }
}
