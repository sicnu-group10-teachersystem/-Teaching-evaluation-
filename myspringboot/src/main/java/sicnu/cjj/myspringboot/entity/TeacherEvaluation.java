package sicnu.cjj.myspringboot.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TeacherEvaluation {
    Integer user_id;
    Integer teacher_id;
    String name;
    String evaluation_time;
    String teacher_name;
    String college;
    String course_name;
    String major;
    String grade;
    String place;
    String course_type;
    String course_time;
    String evaluation_identity;
    String teacher_ages;
    String teacher_ontime;
    String student_people;
    String teaching_model;
    String teaching_platform;
    String teaching_resources;
    String teaching_method;
    String teaching_order;
    String is_roll_call;
    String is_discuss;
    String teaching_content;
    Double score;
    String suggestion;
    String iswrite;


}
