package sicnu.cjj.myspringboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sicnu.cjj.myspringboot.entity.TeacherClass;
import sicnu.cjj.myspringboot.entity.TeacherFile;
import sicnu.cjj.myspringboot.entity.User;
import sicnu.cjj.myspringboot.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    //查询教师档案信息，返回教师档案信息类
     @RequestMapping("getfile")
     private TeacherFile getteacherfile(){
         //拿到当前用户
         Subject subject=SecurityUtils.getSubject();
         User user=(User)subject.getPrincipal();
         //得到当前用户id或者用户名，并通过其得到教师档案信息
         return teacherService.getteacherfile(user.getUser_id());
     }

    //修改教师档案信息，返回修改失败或成功
    @RequestMapping("updatefile")
    private boolean updateteacherfile(TeacherFile teacherFile){
        // TODO: 2020/11/17
        return true;
    }

    //查看教学成绩，参数：教师，课程，班级  返回教师授课列表
    @RequestMapping("getteacherclasslist")
    private List<TeacherClass> getteacherclasslist( ){
        // TODO: 2020/11/17
        return null;
    }

    //查看班级有关学生详细评价以及各平均分
    @RequestMapping("getteacherclass")
    private String getteacherclass(){
        // TODO: 2020/11/17
         return null;
    }

    //查看评价同行列表
    @RequestMapping("getteacherlist")
    private String getteacherlist(){
        // TODO: 2020/11/17
        return null;
    }

    //评价同行，填写表格
    @RequestMapping("addteachertable")
    private String addteachertable(){
        // TODO: 2020/11/17
        return null;
    }

}
