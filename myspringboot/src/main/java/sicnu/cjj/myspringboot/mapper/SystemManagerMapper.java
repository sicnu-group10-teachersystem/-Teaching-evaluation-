package sicnu.cjj.myspringboot.mapper;

import org.springframework.stereotype.Repository;
import sicnu.cjj.myspringboot.entity.Role;

import java.util.List;

@Repository
public interface SystemManagerMapper {
    List<Role> getallrole();
}
