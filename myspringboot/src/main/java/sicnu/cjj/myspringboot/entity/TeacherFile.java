package sicnu.cjj.myspringboot.entity;

import lombok.Data;

@Data
public class TeacherFile {
    private Integer teacher_id;
    private String name;
    private String sex;
    private String education;
    private String title;
    private String birthdate;
    private String worktime;
    private String school;
    private String politicalface;
    private String granttime;
    private String teachinghours;
    private String teacher_score;

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPoliticalface() {
        return politicalface;
    }

    public void setPoliticalface(String politicalface) {
        this.politicalface = politicalface;
    }

    public String getGranttime() {
        return granttime;
    }

    public void setGranttime(String granttime) {
        this.granttime = granttime;
    }

    public String getTeachinghours() {
        return teachinghours;
    }

    public void setTeachinghours(String teachinghours) {
        this.teachinghours = teachinghours;
    }

    public String getTeacher_score() {
        return teacher_score;
    }

    public void setTeacher_score(String teacher_score) {
        this.teacher_score = teacher_score;
    }
}
