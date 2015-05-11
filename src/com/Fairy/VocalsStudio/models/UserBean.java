package com.Fairy.VocalsStudio.models;

/**
 * Created by Wyvern on 08.05.2015.
 */

public class UserBean {
    private int id_user;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int phone_number;
    private String email;
    private String sex;
    private String role;

    public UserBean(int id_user, String login, String password, String name, String surname, int phone_number, String email, String sex, String role) {
        this.id_user = id_user;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.email = email;
        this.sex = sex;
        this.role = role;
    }

    public UserBean(String name, String pass, String email) {
        this.name = name;
        this.password = pass;
        this.email = email;
    }

    public int getId_user() {
        return id_user;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String getSex() {
        return sex;
    }

    public String getRole() {
        return role;
    }
}


//        mysql> select * from users;
//        +---------+-------+----------+----------+---------+--------------+-----------------+------+-------+
//        | id_user | login | password | name     | surname | phone_number | email           | sex  | role  |
//        +---------+-------+----------+----------+---------+--------------+-----------------+------+-------+
//        |       1 | Admin | admin    | Antonina | NULL    |    123456789 | admin@email.com | w    | admin |
//        +---------+-------+----------+----------+---------+--------------+-----------------+------+-------+


//        mysql> describe users;
//        +--------------+-------------+------+-----+---------+----------------+
//        | Field        | Type        | Null | Key | Default | Extra          |
//        +--------------+-------------+------+-----+---------+----------------+
//        | id_user      | int(11)     | NO   | PRI | NULL    | auto_increment |
//        | login        | varchar(30) | NO   |     | NULL    |                |
//        | password     | varchar(20) | NO   |     | NULL    |                |
//        | name         | varchar(20) | NO   |     | NULL    |                |
//        | surname      | varchar(25) | YES  |     | NULL    |                |
//        | phone_number | int(12)     | NO   |     | NULL    |                |
//        | email        | varchar(30) | NO   |     | NULL    |                |
//        | sex          | varchar(1)  | YES  |     | NULL    |                |
//        | role         | varchar(10) | YES  |     | NULL    |                |
//        +--------------+-------------+------+-----+---------+----------------+
