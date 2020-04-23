package com.evack.els.service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evack.els.mapper.UserMapper;
import com.evack.els.model.User;
import com.evack.els.service.Interface.InterLoginService;

@Service
public class ImpleLoginService implements InterLoginService {

    @Autowired
    UserMapper userMapper;
    public User loginResult(String name,String passwd){
        return userMapper.findByUsernameAndPassword(name,passwd);
    }
}
