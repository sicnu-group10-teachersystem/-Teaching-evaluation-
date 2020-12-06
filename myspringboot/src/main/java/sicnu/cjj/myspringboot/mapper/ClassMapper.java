package sicnu.cjj.myspringboot.mapper;

import org.springframework.stereotype.Repository;
import sicnu.cjj.myspringboot.entity.TeacherEvaluation;

import java.util.List;
import java.util.Map;

@Repository
public interface ClassMapper {
    String getclassnum(Integer class_id);
    //List<String> getclassmsg(Integer class_id);
    Map<String,String> getclassmsg(Integer class_id);
}
