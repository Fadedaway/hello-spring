package me.jovi.hellospring.service;

import me.jovi.hellospring.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by joyce on 2017/3/18.
 */
public interface UserService {

    User getUserByName();

    boolean checkPassword(User user);

    void addUser(User user);

    List<User> getUserList();

    void deleteUserById(String id);

    User getUserById(String id);
}
