package sicnu.cjj.myspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sicnu.cjj.myspringboot.mapper.RoleMapper;
import sicnu.cjj.myspringboot.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public int selectrolebyuser(int user_id) {
        return roleMapper.selectrolebyuser(user_id);
    }

    @Override
    public String selectnamebyroleid(int role_id) {
        return roleMapper.selectnamebyroleid(role_id);
    }
}
