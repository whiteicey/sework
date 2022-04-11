package pers.se.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.se.mapper.UserMapper;
import pers.se.entity.User;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public boolean saveUser(User user) {
        return saveOrUpdate(user);
            // if(user.getId() == null){
            //     return save(user);
            // } else{
            //     return updateById(user);
            // }
    }
    // @Autowired
    // private UserMapper userMapper;
    // public int save(User user) {
    //     if(user.getId() == null){
    //         return userMapper.insert(user);
    //     }
    //     else{
    //         return userMapper.update(user);
    //     }
    // }
}
