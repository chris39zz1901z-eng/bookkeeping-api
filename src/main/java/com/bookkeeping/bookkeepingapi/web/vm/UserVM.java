package com.bookkeeping.bookkeepingapi.web.vm;

import lombok.Data;

@Data
public class UserVM {
    String username;//用户名

    String password;//密码

    String password2;//再次输入密码

    Integer age;

}
