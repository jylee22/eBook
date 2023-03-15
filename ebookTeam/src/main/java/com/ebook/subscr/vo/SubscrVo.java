package com.ebook.subscr.vo;

import com.ebook.user.vo.UsersVO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubscrVo {
  private int subscribeKey;
  private String subDate;
  private String exDate;
  private String payMent;
  private String cardNum;
  private String cardPw;

  private String userId;
  private String userName;
  private String joinDate;

  private UsersVO usersVO;


  
}
