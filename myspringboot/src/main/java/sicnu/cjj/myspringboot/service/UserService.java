package sicnu.cjj.myspringboot.service;

import sicnu.cjj.myspringboot.entity.User;

import java.util.List;

public interface UserService {
    User getUser(String account);
    String getusername(Integer user_id);
}
