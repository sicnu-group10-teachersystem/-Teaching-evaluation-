/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/11/10 16:21:45                          */
/*==============================================================*/


drop table if exists authority;

drop table if exists class;

drop table if exists class_course;

drop table if exists course;

drop table if exists mytable;

drop table if exists option_ques;

drop table if exists ques_ques;

drop table if exists ques_table;

drop table if exists role;

drop table if exists student;

drop table if exists supervision;

drop table if exists table1_data;

drop table if exists table2_data;

drop table if exists teacher_data;

drop table if exists user_authority;

drop table if exists user_role;

drop table if exists users;

/*==============================================================*/
/* Table: authority                                             */
/*==============================================================*/
create table authority
(
   authority_id         bigint(20) not null auto_increment,
   authority_name       varchar(50) not null,
   authority_url        varchar(200),
   parent               bigint(20) default 0,
   primary key (authority_id)
);

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
create table class
(
   class_id             bigint(20) not null auto_increment,
   class_num            varchar(10),
   grade                varchar(10),
   college              varchar(40),
   major                varchar(20),
   class_number         int,
   primary key (class_id)
);

/*==============================================================*/
/* Table: class_course                                          */
/*==============================================================*/
create table class_course
(
   class_id             bigint(20) not null,
   course_id            bigint(20) not null,
   course_time          varchar(40),
   course_place         varchar(20),
   course_type          varchar(20),
   teacher_id           bigint(20),
   course_score         float,
   primary key (class_id, course_id)
);

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course
(
   course_id            bigint(20) not null auto_increment,
   course_name          varchar(40),
   primary key (course_id)
);

/*==============================================================*/
/* Table: mytable                                               */
/*==============================================================*/
create table mytable
(
   mytable_id           int not null auto_increment,
   mytable_name         varchar(40) not null,
   primary key (mytable_id)
);

/*==============================================================*/
/* Table: option_ques                                           */
/*==============================================================*/
create table option_ques
(
   option_id            int not null auto_increment,
   ques_id              int not null,
   option_desc          varchar(100) not null,
   optiion_value        int,
   primary key (option_id, ques_id)
);

/*==============================================================*/
/* Table: ques_ques                                             */
/*==============================================================*/
create table ques_ques
(
   ques_id1             int not null,
   ques_id2             int not null,
   primary key (ques_id1, ques_id2)
);

/*==============================================================*/
/* Table: ques_table                                            */
/*==============================================================*/
create table ques_table
(
   ques_id              int not null auto_increment,
   ques_desc            varchar(100),
   ques_type            int default 0,
   mytable_id           int,
   parent               int default 0,
   ques_row             int,
   ques_column          int default 1,
   form                 varchar(20),
   field                varchar(20),
   weight               float,
   primary key (ques_id)
);

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   role_id              bigint(20) not null auto_increment,
   role_name            varchar(20) not null,
   primary key (role_id)
);

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   student_id           bigint(20) not null auto_increment,
   student_name         varchar(40),
   class_id             bigint(20),
   primary key (student_id)
);

/*==============================================================*/
/* Table: supervision                                           */
/*==============================================================*/
create table supervision
(
   supervision_id       bigint(20) not null,
   supervision_name     varchar(40) not null,
   primary key (supervision_id)
);

/*==============================================================*/
/* Table: table1_data                                           */
/*==============================================================*/
create table table1_data
(
   user_id              bigint(20) not null,
   teacher_id           bigint(20) not null,
   ques_id              int not null,
   answer               varchar(200),
   primary key (user_id, teacher_id, ques_id)
);

/*==============================================================*/
/* Table: table2_data                                           */
/*==============================================================*/
create table table2_data
(
   user_id              bigint(20) not null,
   teacher_id           bigint(20) not null,
   ques_id              int not null,
   answer               varchar(200),
   primary key (user_id, teacher_id, ques_id)
);

/*==============================================================*/
/* Table: teacher_data                                          */
/*==============================================================*/
create table teacher_data
(
   teacher_id           bigint(20) not null,
   ques_id              int not null,
   answer               varchar(100),
   teacher_name         varchar(20),
   primary key (teacher_id, ques_id)
);

/*==============================================================*/
/* Table: user_authority                                        */
/*==============================================================*/
create table user_authority
(
   role_id              bigint(20) not null,
   authority_id         bigint(20) not null,
   primary key (authority_id)
);

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table user_role
(
   user_id              bigint(20) not null,
   role_id              bigint(20) not null,
   primary key (user_id, role_id)
);

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users
(
   user_id              bigint(20) not null auto_increment,
   user                 varchar(40) not null,
   password             varchar(40) not null,
   identity             varchar(30),
   primary key (user_id)
);

alter table class_course add constraint FK_class_course foreign key (course_id)
      references course (course_id) on delete restrict on update restrict;

alter table class_course add constraint FK_course_class foreign key (class_id)
      references class (class_id) on delete restrict on update restrict;

alter table option_ques add constraint FK_Reference_9 foreign key (ques_id)
      references ques_table (ques_id) on delete restrict on update restrict;

alter table ques_table add constraint FK_Reference_8 foreign key (mytable_id)
      references mytable (mytable_id) on delete restrict on update restrict;

alter table student add constraint FK_student_class foreign key (class_id)
      references class (class_id) on delete restrict on update restrict;

alter table user_authority add constraint FK_authority foreign key (authority_id)
      references authority (authority_id) on delete restrict on update restrict;

alter table user_authority add constraint FK_role2 foreign key (role_id)
      references role (role_id) on delete restrict on update restrict;

alter table user_role add constraint FK_role1 foreign key (role_id)
      references role (role_id) on delete restrict on update restrict;

alter table user_role add constraint FK_user foreign key (user_id)
      references users (user_id) on delete restrict on update restrict;

