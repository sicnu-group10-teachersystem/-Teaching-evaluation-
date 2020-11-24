package sicnu.cjj.myspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sicnu.cjj.myspringboot.entity.Authority;
import sicnu.cjj.myspringboot.mapper.AuthorityMapper;
import sicnu.cjj.myspringboot.service.AuthorityService;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityMapper authorityMapper;
    @Override
    public List<Integer> selectauthidbyrole(int role_id) {
        return authorityMapper.selectauthidbyrole(role_id);
    }

    @Override
    public Authority selectauthbyid(int authority_id) {
        return authorityMapper.selectauthbyid(authority_id);
    }
}
