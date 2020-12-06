package sicnu.cjj.myspringboot.entity;

import lombok.Data;

@Data
public class TableMsg {
    private Integer ques_id;
    private String  ques_project;
    private String ques_desc;
    private String mytable_id;
    private float weight;

}
