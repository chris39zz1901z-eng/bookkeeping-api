package com.bookkeeping.bookkeepingapi.web.api;

import com.bookkeeping.bookkeepingapi.model.User;
import com.bookkeeping.bookkeepingapi.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //restful格式接口 ：获取 get  提交 post 编辑 put 删除delete
    @GetMapping("/api/studenttable")
    //获取所有用户信息
    public String getUsers(){
        List<User> users= userRepository.findAll();
        return users.toString();
    }
}
