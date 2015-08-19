package com.Fairy.VocalsStudio.models;

/**
 * Created by Wyvern on 17.05.2015.
 */

public class LessonRequest {
    private int idLessonRequest;
    private User lrUser;
    private String date;
    private String time;
    private String status;
    private String type;


    public LessonRequest(){}

    public LessonRequest(String date, String time, String status, String type, User lrUser) {
        this.date = date;
        this.time = time;
        this.status = status;
        this.type = type;
        this.lrUser = lrUser;
    }

    public LessonRequest(User lrUser, String date, String time) {
        this.lrUser = lrUser;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return idLessonRequest;
    }

    public void setId(int idLessonRequest) {
        this.idLessonRequest = idLessonRequest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getLrUser() {
        return lrUser;
    }

    public int getLrIdUser() {
        return lrUser.getIdUser();
    }

    public void setLrUser(User lrUser) {
        this.lrUser = lrUser;
    }

    @Override
    public String toString() {
        return "LessonRequest{" +
                "idLessonRequest=" + idLessonRequest +
                ", lesson request creator =" + lrUser +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}


//        create table lesson_request (id_lr int auto_increment primary key, lr_id_
//        user int(11), date date not null,time time not null, status varchar(16) default
//        'not confirmed', type varchar(30) default 'vocal lesson');
//
//mysql> describe lesson_request;
//        +------------+-------------+------+-----+---------------+----------------+
//        | Field      | Type        | Null | Key | Default       | Extra          |
//        +------------+-------------+------+-----+---------------+----------------+
//        | id_lr      | int(11)     | NO   | PRI | NULL          | auto_increment |
//        | lr_id_user | int(11)     | YES  |     | NULL          |                |
//        | date       | date        | NO   |     | NULL          |                |
//        | time       | time        | NO   |     | NULL          |                |
//        | status     | varchar(16) | YES  |     | not confirmed |                |
//        | type       | varchar(30) | YES  |     | vocal lesson  |                |
//        +------------+-------------+------+-----+---------------+----------------+


//        OLD VERSION
//        mysql> describe applications;
//        +----------------+-------------+------+-----+----------------+----------------+
//        | Field          | Type        | Null | Key | Default        | Extra          |
//        +----------------+-------------+------+-----+----------------+----------------+
//        | id_application | int(11)     | NO   | PRI | NULL           | auto_increment |
//        | date           | date        | NO   |     | NULL           |                |
//        | status         | varchar(16) | YES  |     | not confirmed  |                |
//        | type           | varchar(30) | YES  |     | vocals         |                |
//        | users_id_user  | int(11)     | NO   | MUL | NULL           |                |
//        +----------------+-------------+------+-----+----------------+----------------+

