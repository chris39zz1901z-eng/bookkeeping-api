package com.bookkeeping.bookkeepingapi.web.api;

import com.bookkeeping.bookkeepingapi.repository.UserRepository;
import com.bookkeeping.bookkeepingapi.service.UserDTO;
import com.bookkeeping.bookkeepingapi.service.UserService;
import com.bookkeeping.bookkeepingapi.web.vm.UserVM;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/api/studenttable")
    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/api/user")
    public String addUser(@RequestBody UserVM userVM) {
        String errorMessage = checkUserVM(userVM);
        if (errorMessage != null) {
            return errorMessage;
        }

        UserService.save(userVM, userRepository);
        return "注册成功";
    }

    @PutMapping("/api/user/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody UserVM userVM) {
        if (id == null) {
            return "用户id不能为空";
        }

        String errorMessage = checkUserVM(userVM);
        if (errorMessage != null) {
            return errorMessage;
        }

        boolean success = UserService.update(id, userVM, userRepository);
        if (!success) {
            return "用户不存在";
        }

        return "编辑成功";
    }

    @DeleteMapping("/api/user/{id}")
    public String deleteUser(@PathVariable Integer id) {
        if (id == null) {
            return "用户id不能为空";
        }

        boolean success = UserService.delete(id, userRepository);
        if (!success) {
            return "用户不存在";
        }

        return "删除成功";
    }

    private String checkUserVM(UserVM userVM) {
        if (userVM == null) {
            return "用户信息不能为空";
        }

        if (StringUtils.isBlank(userVM.getUsername())) {
            return "用户名不能为空";
        }

        if (StringUtils.isBlank(userVM.getPassword()) || StringUtils.isBlank(userVM.getPassword2())) {
            return "密码不能为空";
        }

        if (userVM.getAge() == null) {
            return "年龄不能为空";
        }

        if (!userVM.getPassword().equals(userVM.getPassword2())) {
            return "两次密码输入不一致";
        }

        return null;
    }
}
