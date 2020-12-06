package sicnu.cjj.myspringboot.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sicnu.cjj.myspringboot.entity.TeacherClass;
import sicnu.cjj.myspringboot.entity.TeacherFile;
import sicnu.cjj.myspringboot.mapper.TeacherMapper;
import sicnu.cjj.myspringboot.service.TeacherService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public TeacherFile getteacherfile(Integer teacher_id) {

        return teacherMapper.getteacherfile(teacher_id);
    }

    @Override
    public Boolean sendteacherfile(LinkedHashMap params) {
        return teacherMapper.sendteacherfile(params);
    }

    @Override
    public List<TeacherClass> getteacherclasslist(Integer teacher_id) {
        return teacherMapper.getteacherclasslist(teacher_id);
    }

    @Override
    public List<TeacherClass> getotherteacherlist(Integer teacher_id) {
        return teacherMapper.getotherteacherlist(teacher_id);
    }

    @Override
    public List<TeacherClass> getotherteacherlistname(List<TeacherClass> otherteacherlistname) {
        return teacherMapper.getotherteacherlistname(otherteacherlistname);
    }

    @Override
    public List<String> getstudentsuggges(LinkedHashMap params) {

        return teacherMapper.getstudentsuggges(params);
    }

    @Override
    public Map<String,String> getclasscoursemsg(Integer class_id, Integer course_id) {
        return teacherMapper.getclasscoursemsg(class_id,course_id);
    }

    @Override
    public Boolean addteachertable(LinkedHashMap params) {
        return teacherMapper.addteachertable(params);
    }

    @Override
    public String getteachername(Integer teacher_id) {
        return teacherMapper.getteachername(teacher_id);
    }
}
