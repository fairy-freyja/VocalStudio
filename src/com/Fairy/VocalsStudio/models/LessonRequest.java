package com.Fairy.VocalsStudio.models;

import java.util.Date;

/**
 * Created by Wyvern on 17.05.2015.
 */
public class LessonRequest {
    private int idApplication;
    private Date date;
    private String status;
    private String type;
    private int  usersIdUser;


    public LessonRequest(int idApplication, Date date, String status, String type, int usersIdUser) {
        this.idApplication = idApplication;
        this.date = date;
        this.status = status;
        this.type = type;
        this.usersIdUser = usersIdUser;
    }
}


//        mysql> describe applications;
//        +----------------+-------------+------+-----+----------------+----------------+
//        | Field          | Type        | Null | Key | Default        | Extra          |
//        +----------------+-------------+------+-----+----------------+----------------+
//        | id_application | int(11)     | NO   | PRI | NULL           | auto_increment |
//        | date           | date        | NO   |     | NULL           |                |
//        | status         | varchar(16) | YES  |     |  not confirmed |                |
//        | type           | varchar(30) | YES  |     | vocals         |                |
//        | users_id_user  | int(11)     | NO   | MUL | NULL           |                |
//        +----------------+-------------+------+-----+----------------+----------------+

