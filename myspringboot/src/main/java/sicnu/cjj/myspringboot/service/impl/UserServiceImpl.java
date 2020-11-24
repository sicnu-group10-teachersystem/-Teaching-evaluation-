package sicnu.cjj.myspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sicnu.cjj.myspringboot.entity.User;
import sicnu.cjj.myspringboot.mapper.UserMapper;
import sicnu.cjj.myspringboot.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(String account) {
        return userMapper.findUser(account);
    }
}
