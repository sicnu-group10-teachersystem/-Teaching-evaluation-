package sicnu.cjj.myspringboot.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sicnu.cjj.myspringboot.entity.TeacherClass;
import sicnu.cjj.myspringboot.entity.TeacherFile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface TeacherMapper {
    TeacherFile getteacherfile(Integer teacher_id);
    Boolean sendteacherfile(@Param("params") LinkedHashMap params);
    List<TeacherClass> getteacherclasslist(Integer teacher_id);
    List<TeacherClass> getotherteacherlist(Integer teacher_id);
    String getteachername(Integer teacher_id);
    List<TeacherClass> getotherteacherlistname(List<TeacherClass> otherteacherlistname);
    List<String> getstudentsuggges( @Param("params") LinkedHashMap params);
    Map<String,String> getclasscoursemsg(Integer class_id, Integer course_id);
    Boolean addteachertable(@Param("params") LinkedHashMap params);
}
