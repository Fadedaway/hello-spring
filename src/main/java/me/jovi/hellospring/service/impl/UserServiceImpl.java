package me.jovi.hellospring.service.impl;

import me.jovi.hellospring.entity.User;
import me.jovi.hellospring.repositoryies.UserRepo;
import me.jovi.hellospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by joyce on 2017/3/18.
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

    @PersistenceContext(name = "entityManagerFactory")
    private EntityManager  entityManager;

    @Autowired
    private UserRepo userRepo;

    @Override
    public User getUserByName() {

        return userRepo.getOne(1);
    }

    @Override
    public boolean checkPassword(User user) {
        try{
            StringBuffer sql = new StringBuffer("select * from t_user where ");
            sql.append("login_name = :loginName ");
            Query query = entityManager.createNativeQuery(sql.toString(),User.class).setParameter("loginName", user.getLoginName());
            User dbUser = (User) query.getSingleResult();

            if (dbUser != null && dbUser.getPassword().equalsIgnoreCase(user.getPassword())){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
