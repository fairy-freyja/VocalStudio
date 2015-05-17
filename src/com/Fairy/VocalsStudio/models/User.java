package com.Fairy.VocalsStudio.models;

/**
 * Created by Wyvern on 08.05.2015.
 */

public class User {
    private int idUser;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String sex;
    private String role;

    public User(int idUser, String login, String password, String name, String surname, String phoneNumber, String email, String sex, String role) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.sex = sex;
        this.role = role;
    }

    public User(String name, String pass, String email) {
        this.name = name;
        this.password = pass;
        this.email = email;
    }

    public int getIdUser() {
        return idUser;
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

    public String getPhoneNumber() {
        return phoneNumber;
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
//        | idUser | login | password | name     | surname | phoneNumber | email           | sex  | role  |
//        +---------+-------+----------+----------+---------+--------------+-----------------+------+-------+
//        |       1 | Admin | admin    | Antonina | NULL    |    123456789 | admin@email.com | w    | admin |
//        +---------+-------+----------+----------+---------+--------------+-----------------+------+-------+


//        mysql> describe users;
//        +--------------+-------------+------+-----+---------+----------------+
//        | Field        | Type        | Null | Key | Default | Extra          |
//        +--------------+-------------+------+-----+---------+----------------+
//        | idUser      | int(11)     | NO   | PRI | NULL    | auto_increment |
//        | login        | varchar(30) | NO   |     | NULL    |                |
//        | password     | varchar(20) | NO   |     | NULL    |                |
//        | name         | varchar(20) | NO   |     | NULL    |                |
//        | surname      | varchar(25) | YES  |     | NULL    |                |
//        | phoneNumber | int(12)     | NO   |     | NULL    |                |
//        | email        | varchar(30) | NO   |     | NULL    |                |
//        | sex          | varchar(1)  | YES  |     | NULL    |                |
//        | role         | varchar(10) | YES  |     | NULL    |                |
//        +--------------+-------------+------+-----+---------+----------------+
