package sicnu.cjj.myspringboot.mapper;

import org.springframework.stereotype.Repository;
import sicnu.cjj.myspringboot.entity.Authority;

import java.util.List;

@Repository
public interface AuthorityMapper {
    // TODO: 2020/11/18
    List<Integer> selectauthidbyrole(int role_id);
    Authority selectauthbyid(int authority_id);
}
