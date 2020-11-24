package sicnu.cjj.myspringboot.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    // TODO: 2020/11/18
    int selectrolebyuser(int user_id);
    String selectnamebyroleid(int role_id);
}
