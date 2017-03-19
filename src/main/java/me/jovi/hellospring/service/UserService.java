package me.jovi.hellospring.service;

import me.jovi.hellospring.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by joyce on 2017/3/18.
 */
public interface UserService {

    public User getUserByName();
}
