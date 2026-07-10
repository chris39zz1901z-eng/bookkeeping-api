package com.bookkeeping.bookkeepingapi.service;

import com.bookkeeping.bookkeepingapi.model.User;
import com.bookkeeping.bookkeepingapi.repository.UserRepository;
import com.bookkeeping.bookkeepingapi.web.vm.UserVM;

public class UserService {

    private UserService() {
    }

    public static User save(UserVM userVM, UserRepository userRepository) {
        User user = new User();
        user.setUsername(userVM.getUsername());
        user.setPassword(userVM.getPassword());
        user.setName(userVM.getUsername());
        user.setAge(userVM.getAge());
        return userRepository.save(user);
    }

    public static boolean update(Integer id, UserVM userVM, UserRepository userRepository) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return false;
        }

        user.setUsername(userVM.getUsername());
        user.setPassword(userVM.getPassword());
        user.setName(userVM.getUsername());
        user.setAge(userVM.getAge());
        userRepository.save(user);
        return true;
    }

    public static boolean delete(Integer id, UserRepository userRepository) {
        if (!userRepository.existsById(id)) {
            return false;
        }

        userRepository.deleteById(id);
        return true;
    }
}
