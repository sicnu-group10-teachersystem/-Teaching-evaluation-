package sicnu.cjj.myspringboot.mapper;

import org.springframework.stereotype.Repository;
import sicnu.cjj.myspringboot.entity.TableMsg;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface TableMapper {
    List<TableMsg> getteachertablemsg();
}
