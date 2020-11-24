package sicnu.cjj.myspringboot.service;

import sicnu.cjj.myspringboot.entity.Authority;

import java.util.List;

public interface AuthorityService {
    List<Integer> selectauthidbyrole(int role_id);
    Authority selectauthbyid(int authority_id);
}
