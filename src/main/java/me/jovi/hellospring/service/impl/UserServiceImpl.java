package me.jovi.hellospring.service.impl;

import me.jovi.hellospring.entity.User;
import me.jovi.hellospring.repositoryies.UserRepo;
import me.jovi.hellospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by joyce on 2017/3/18.
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User getUserByName() {

        return userRepo.getOne(1);
    }
}
