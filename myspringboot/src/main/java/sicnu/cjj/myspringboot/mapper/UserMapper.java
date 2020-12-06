package sicnu.cjj.myspringboot.mapper;

import org.springframework.stereotype.Repository;
import sicnu.cjj.myspringboot.entity.User;


import java.util.List;

@Repository
public interface UserMapper {
    User findUser(String account);
    String getusername(Integer user_id);
}
