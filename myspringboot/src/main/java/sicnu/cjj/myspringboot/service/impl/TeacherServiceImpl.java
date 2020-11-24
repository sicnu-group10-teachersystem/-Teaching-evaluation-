package sicnu.cjj.myspringboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sicnu.cjj.myspringboot.entity.TeacherFile;
import sicnu.cjj.myspringboot.mapper.TeacherMapper;
import sicnu.cjj.myspringboot.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public TeacherFile getteacherfile(Integer teacher_id) {

        return teacherMapper.getteacherfile(teacher_id);
    }
}
