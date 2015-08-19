package com.Fairy.VocalsStudio.services;

import com.Fairy.VocalsStudio.dao.DaoFactory;
import com.Fairy.VocalsStudio.dao.UserDao;
import com.Fairy.VocalsStudio.models.User;
import com.Fairy.VocalsStudio.models.UserBuilder;

import java.sql.SQLException;


/**
 * Created by Fairy on 5/23/2015.
 */
public class RegisterService {
    private UserDao ud = DaoFactory.getInstance().createUserDao();

    public boolean checkRegisterInputs(String login, String password, String email){
        return login != null && password != null && email != null
                && InputValidator.validateLogin(login)
                && InputValidator.validatePassword(password)
                && InputValidator.validateEmail(email);
    }


    public boolean createUser(String login, String password, String name, String surname, String phone_number,
                           String email, String sex) {
        try{
//          id_user | login | password | name | surname | phone_number | email | sex  | role
            UserBuilder userBuilder = new UserBuilder();
            userBuilder.setLogin(login).setPassword(password).setName(name).setSurname(surname)
                    .setPhoneNumber(phone_number).setEmail(email).setSex(sex);
            User user = userBuilder.build();
            ud.create(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User findUserByLogin(String login) {
        try {
            return ud.findByLogin(login);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
