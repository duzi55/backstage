package com.gzq.service.serviceImpl;

import com.gzq.dao.UserMapper;
import com.gzq.entity.User;
import com.gzq.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServicrImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public boolean login(User user) {
        boolean flag=false;
        if(userMapper.login(user)!=null){
            flag=true;
        }
        return flag;
    }
}
