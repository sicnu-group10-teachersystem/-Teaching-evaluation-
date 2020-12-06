package sicnu.cjj.myspringboot.mapper;

import org.springframework.stereotype.Repository;
import sicnu.cjj.myspringboot.entity.Authority;

import java.util.List;

@Repository
public interface BusManagerMapper {

   List<Authority> getallauthoritylist();
}
