package me.jovi.hellospring.service;

import me.jovi.hellospring.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    User getUserByLoginName(String loginName);

    Set<String> findRoles(String loginName);
}
