package me.jovi.hellospring.entity.service.impl;

import me.jovi.hellospring.entity.User;
import me.jovi.hellospring.entity.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by joyce on 2017/3/18.
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Override
    public User getUserByName() {
        return null;
    }
}
