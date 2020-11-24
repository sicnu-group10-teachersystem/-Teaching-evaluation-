package sicnu.cjj.myspringboot.mapper;

import org.springframework.stereotype.Repository;
import sicnu.cjj.myspringboot.entity.TeacherFile;

@Repository
public interface TeacherMapper {
    TeacherFile getteacherfile(Integer teacher_id);
}
