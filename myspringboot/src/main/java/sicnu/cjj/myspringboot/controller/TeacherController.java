package sicnu.cjj.myspringboot.controller;

import org.apache.ibatis.session.SqlSessionException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sicnu.cjj.myspringboot.entity.TableMsg;
import sicnu.cjj.myspringboot.entity.TeacherClass;
import sicnu.cjj.myspringboot.entity.TeacherFile;
import sicnu.cjj.myspringboot.entity.User;
import sicnu.cjj.myspringboot.mapper.ClassMapper;
import sicnu.cjj.myspringboot.mapper.TableMapper;
import sicnu.cjj.myspringboot.result.Result;
import sicnu.cjj.myspringboot.result.ResultGenerator;
import sicnu.cjj.myspringboot.service.TeacherService;
import sicnu.cjj.myspringboot.service.UserService;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    ClassMapper classMapper;

    @Autowired
    UserService userService;

    @Autowired
    TableMapper tableMapper;

    //查询教师档案信息，返回教师档案信息类
     @RequestMapping("getfile")
     private TeacherFile getteacherfile(){
         //拿到当前用户id
         Subject subject=SecurityUtils.getSubject();
         User user=(User)subject.getPrincipal();
         //得到当前用户id或者用户名，并通过其得到教师档案信息
         TeacherFile teacherFile=teacherService.getteacherfile(user.getUser_id());
  //     TeacherFile teacherFile=teacherService.getteacherfile(4);
         return teacherFile;
     }

    //提交修改教师档案申请，待由业务管理员审核
    @RequestMapping("updatefile")
    private boolean updateteacherfile(@RequestBody LinkedHashMap<String,Object> params){

         System.out.println(params);

         //List<String> teacherfile= new ArrayList<String>(params.values());

         boolean flag=teacherService.sendteacherfile(params);

         return flag;
    }


    //查看教学成绩，参数：教师，课程，班级  返回教师授课列表,
    //查找参数 教师id
    @RequestMapping("getteacherclasslist")
    private List<TeacherClass> getteacherclasslist( ){
        //拿到当前用户id
        Subject subject=SecurityUtils.getSubject();
        User user=(User)subject.getPrincipal();
        //得到教师授课列表
        try {
            List<TeacherClass> teacherClassList=teacherService.getteacherclasslist(user.getUser_id());
            for(int j=0;j<teacherClassList.size();j++){
                teacherClassList.get(j).setTeacher_id(user.getUser_id());
                teacherClassList.get(j).setTeacher_name(user.getName());
            }
            System.out.println(teacherClassList);
            return teacherClassList;
        }catch (SqlSessionException e){
            return null;
        }


    }

    //查看班级有关学生详细评价以及各平均分
    //输入参数：班级id,教师id,课程id
    @RequestMapping("getteacherclass")
    private Result getteacherclass(@RequestBody LinkedHashMap<String ,Integer> params){
        //拿到当前用户id(筛选当前用户id)
        Subject subject=SecurityUtils.getSubject();
        User user=(User)subject.getPrincipal();
        //找到班级所有评价
//        params.get("class_id");
//        params.get("course_id");
//        params.get("teacher_id");
//        params.get("pagesize");
//        params.get("pagenum");
        try {
            List<String> suggestions = teacherService.getstudentsuggges(params);
            System.out.println(suggestions);
            return ResultGenerator.genSuccessResult(suggestions);
        }catch (Exception e){
            return ResultGenerator.genFailResult("查询失败");
        }

    }

    //查看可评价同行列表，除教师自己外的教师,返回的是教师名，班级号，课程名
    //参数：教师id
    @RequestMapping("getotherteacherlist")
    private List<TeacherClass> getteacherlist(){
        // TODO: 2020/11/17
        Subject subject=SecurityUtils.getSubject();
        User user=(User)subject.getPrincipal();
        try {
            List<TeacherClass> otherteacherList=teacherService.getotherteacherlist(user.getUser_id());
            //通过id得到名字
            for(int j=0;j<otherteacherList.size();j++){
                //查到班级号，教师姓名
                otherteacherList.get(j).setClass_num(classMapper.getclassnum(otherteacherList.get(j).getClass_id()));
                otherteacherList.get(j).setTeacher_name(teacherService.getteachername(otherteacherList.get(j).getTeacher_id()));

            }
            //List<TeacherClass> otherteacherListname =teacherService.getotherteacherlistname(otherteacherList);
            System.out.println(otherteacherList);
            return otherteacherList;
        }catch (SqlSessionException e){
            return null;
        }

    }

    //评价同行，填写表格
    @RequestMapping("addteachertable")
    private Result addteachertable(@RequestBody LinkedHashMap<String,Object> params){
        // TODO: 2020/11/17
//        try{
//            boolean flag =teacherService.addteachertable(params);
//            return ResultGenerator.genSuccessResult();
//        }catch (Exception e){
//            return ResultGenerator.genFailResult("填写失败");
//        }
      //  List<Object> teacherfile= new ArrayList<String>(params.values());
        System.out.println(params);
        try{
            boolean flag =teacherService.addteachertable(params);
            return ResultGenerator.genSuccessResult();
        }catch (Exception e){
            return ResultGenerator.genFailResult("失败");
        }

    }

    //进入填写页面之后申请数据在表格中显示
    //通过教师id，课程id，班级id返回表格所需信息
    //所需信息:被评价人姓名，教学单位，课程名称，授课专业，授课年级，授课地点，课程类型，上课节次，实到学生人数
    @RequestMapping("getteachertablemsg")
    private Result getteachertablemsg(@RequestBody LinkedHashMap<String,Integer> params){
        // TODO: 2020/11/17
        //1.获取被评价人姓名从user表中
        //2.获取教学单位，授课专业，授课年级，学生人数(class)
        //3.获取授课地点，课程类型，上课节次，课程名（class_course)
        params.get("teacher_id");
        params.get("course_id");
        params.get("class_id");

       try {
           Map<String,String> map=new HashMap<>();
           //1.获取被评价人姓名从user表中
           String username= userService.getusername(params.get("teacher_id"));
           //2.通过班级id,课程id获取教学单位，授课专业，授课年级，学生人数(class)
           map=classMapper.getclassmsg(params.get("class_id"));
           //3.获取授课地点，课程类型，上课节次，课程名（class_course)
           map.put("username",username);
           map.putAll(teacherService.getclasscoursemsg(params.get("class_id"),params.get("course_id")));
           System.out.println(map);

           return ResultGenerator.genSuccessResult(map);
       }catch (Exception e){
           return ResultGenerator.genFailResult("信息错误");
       }

    }


    //得到动态项目数据
    @RequestMapping("getteachertableminfo")
    public Result getteachertableinfo(){
//        Map<String,List<String>> map=new HashMap<>();
//        map=tableMapper.getteachertablemsg();

        List<TableMsg> tableMsgs=tableMapper.getteachertablemsg();

        return ResultGenerator.genSuccessResult(tableMsgs);
    }

}
