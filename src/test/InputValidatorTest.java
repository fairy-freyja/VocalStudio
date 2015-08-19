package test;

import com.Fairy.VocalsStudio.services.InputValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by Fairy on 6/8/2015.
 */
public class InputValidatorTest {
    @Test
    public void normLoginTest(){
        String login = "normlogin123";
        assert InputValidator.validateLogin(login);
    }

    @Test
    public void normPasswordTest(){
        String password = "normpass123";
        assert InputValidator.validatePassword(password);
    }

    @Test
    public void normEmilTest(){
        String email = "norm123@email.com";
        assert InputValidator.validateEmail(email);
    }

    @Test
    public void injectionInLogin(){
        String login = "'; DROP TABLE";
        assertFalse(InputValidator.validateLogin(login));
    }

    @Test
    public void someStringEmilTest(){
        String email = "someString";
        assertFalse(InputValidator.validateEmail(email));
    }

    @Test
    public void normDate(){
        String date = "2015-12-31";
        assert InputValidator.validateDate(date);
    }

    @Test
    public void normTime(){
        String time = "12:59:59";
        String time1 = "00:15:32";
        assert InputValidator.validateTime(time);
        assert InputValidator.validateTime(time1);
    }
}
