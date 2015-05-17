package com.Fairy.VocalsStudio.jdbc;

import com.Fairy.VocalsStudio.dao.LessonRequestDao;
import com.Fairy.VocalsStudio.logic.DBConnectionFactory;
import com.Fairy.VocalsStudio.models.LessonRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Wyvern on 17.05.2015.
 */
public class JdbcLessonRequestDao implements LessonRequestDao {
    @Override
    public LessonRequest find(int id) {
        LessonRequest application = null;
        try (Connection con = DBConnectionFactory.getDBConnection();) {

            ResultSet result = con.createStatement().executeQuery("SELECT * FROM applications WHERE id_application = " + id + ";");

            if (result.next()) {
                int idApplication = result.getInt("id_application");
                Date date = result.getDate("date");
                String status = result.getString("status");
                String type = result.getString("type");
                int usersIdUser = result.getInt("users_id_user");
                application = new LessonRequest( idApplication,  date,  status,  type,  usersIdUser);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return application;
    }

    @Override
    public LessonRequest update(LessonRequest value) {
        return null;
    }

    @Override
    public LessonRequest create(LessonRequest value) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
