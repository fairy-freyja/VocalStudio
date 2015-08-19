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


    public User(){ }

    public User (String login, String password, String name, String surname, String email, String phoneNumber, String sex){
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

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

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}


//        mysql> select * from users;
//        +---------+-------+----------+----------+---------+--------------+-----------------+------+-------+
//        | idUser | login | password | name     | surname | phoneNumber | email           | sex  | role  |
//        +---------+-------+----------+----------+---------+--------------+-----------------+------+-------+
//        |       1 | Admin | admin    | Antonina | NULL    |    123456789 | admin@email.com | w    | admin |
//        +---------+-------+----------+----------+---------+--------------+-----------------+------+-------+
//
//        mysql> insert into users (login, password, name, phone_number, email, sex, role) values ('test', 'test', 'TestUserName', '123456789', 'test@email.com', 'w', 'user');
//        mysql> insert into users (login, password, name, phone_number, email, sex, role) values ('Admin', 'admin', 'Antonina', '123456789', 'admin@email.com', 'w', 'admin');
//
//  mysql> describe users;
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

//        mysql> describe users
//        -> ;
//        +--------------+-------------+------+-----+---------+----------------+
//        | Field        | Type        | Null | Key | Default | Extra          |
//        +--------------+-------------+------+-----+---------+----------------+
//        | id_user      | int(11)     | NO   | PRI | NULL    | auto_increment |
//        | login        | varchar(30) | NO   |     | NULL    |                |
//        | password     | varchar(20) | NO   |     | NULL    |                |
//        | name         | varchar(20) | NO   |     | NULL    |                |
//        | surname      | varchar(25) | YES  |     | NULL    |                |
//        | phone_number | varchar(12) | NO   |     | NULL    |                |
//        | email        | varchar(40) | NO   |     | NULL    |                |
//        | sex          | varchar(1)  | YES  |     | NULL    |                |
//        | role         | varchar(10) | YES  |     | user    |                |
//        +--------------+-------------+------+-----+---------+----------------+
//