package com.Fairy.VocalsStudio.jdbc;

import com.Fairy.VocalsStudio.dao.LessonRequestDao;
import com.Fairy.VocalsStudio.logic.DBConnectionFactory;
import com.Fairy.VocalsStudio.models.LessonRequest;
import com.Fairy.VocalsStudio.models.LessonRequestBuilder;
import com.Fairy.VocalsStudio.models.User;
import com.Fairy.VocalsStudio.services.UserHomeService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wyvern on 17.05.2015.
 */
public class JdbcLessonRequestDao implements LessonRequestDao {
    private Logger log = Logger.getLogger(JdbcLessonRequestDao.class);

    private static String CREATE = "INSERT INTO lesson_request SET date=?, lr_id_user = ?, time =  ? ;";
    private static String SELECT_ALL = "SELECT * FROM lesson_request;";
    private static String SELECT_ALL_FOR_USER = "SELECT * FROM lesson_request WHERE lr_id_user = ?;";
    private static String SELECT_BY_STATUS_FOR_ADMIN = "SELECT * FROM lesson_request WHERE status = ? AND date > ? ";
    private static String SELECT_BY_STATUS_FOR_USER = "SELECT * FROM lesson_request WHERE status = ? AND lr_id_user = ?";
    private static String CHANGE_STATUS = "UPDATE lesson_request SET status= ? WHERE id_lr = ?";
    private static String CHANGE_STATUS_TO_OLD_MULTIPLE = "UPDATE lesson_request SET status='old' WHERE status='confirmed' AND date < ?";
    private static String FIND_ALL_FOR_USER = "SELECT * FROM lesson_request WHERE lr_id_user = ?";

    @Override
    public LessonRequest find(int id) {
        LessonRequest lr = null;
        try (Connection con = DBConnectionFactory.getDBConnection();) {

            ResultSet result = con.createStatement().executeQuery("SELECT * FROM lesson_request WHERE id_lr = " + id + ";");
            if (result.next()) {
                int idLr = result.getInt("id_lr");
                String date = result.getDate("date").toString();
                String time = result.getTime("time").toString();
                String status = result.getString("status");
                String type = result.getString("type");
                int usersIdUser = result.getInt("lr_id_user");
                lr = new LessonRequestBuilder().setIdLessonRequest(idLr).setDate(date).setTime(time).setStatus(status)
                        .setType(type).setLrIdUser(usersIdUser).build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lr;
    }

    @Override
    public int update(LessonRequest value) {
        return 0;
    }

    @Override
    public int create(LessonRequest value) {
        int countUpdate = 0;
        try (Connection con = DBConnectionFactory.getDBConnection()) {
            try (PreparedStatement ps = con.prepareStatement(CREATE)) {
                Date date = Date.valueOf(value.getDate());
                ps.setDate(1, date);
                ps.setInt(2, value.getLrIdUser());
                Time time = Time.valueOf(value.getTime());
                ps.setTime(3, time);
                countUpdate = ps.executeUpdate();
                if(countUpdate == 1){
                    log.log(Level.INFO, "Lesson request create successfully" );
                }
            }catch (SQLException e){
                e.printStackTrace();
                log.log(Level.ERROR, "Trouble happened when try create lesson request", e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.log(Level.ERROR, "Trouble with connection to DB when try create Lesson request",e);
        }
        return countUpdate;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public ArrayList<LessonRequest> findAllByUserID(int idUser) throws SQLException {
        ArrayList<LessonRequest> lrList = null;
        try (Connection con = DBConnectionFactory.getDBConnection();) {
            try (PreparedStatement ps = con.prepareStatement(FIND_ALL_FOR_USER)) {
                ps.setInt(1, idUser);
                ResultSet result = ps.executeQuery();
                while (result.next()) {
                    if (lrList == null) {
                        lrList = new ArrayList<>();
                    }
                    int usersIdUser = result.getInt("lr_id_user");
                    int idLr = result.getInt("id_lr");
                    User user = new User();
                    user.setIdUser(usersIdUser);
                    String date = result.getDate("date").toString();
                    String time = result.getTime("time").toString();
                    String status = result.getString("status");
                    String type = result.getString("type");

                    lrList.add(new LessonRequestBuilder().setIdLessonRequest(idLr).setDate(date).setTime(time).setStatus(status)
                            .setType(type).setLrIdUser(user).build());
            }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lrList;
    }

//    private static String SELECT_BY_STATUS_FOR_USER = "SELECT * FROM lesson_request WHERE status = ? AND lr_id_user = ?";
    public ArrayList<LessonRequest> findByStatusForUser (int id, String status) throws SQLException {
    ArrayList<LessonRequest> lrList = null;
    try (Connection con = DBConnectionFactory.getDBConnection()) {
        try (PreparedStatement ps = con.prepareStatement(SELECT_BY_STATUS_FOR_USER)) {
            ps.setString(1, status);
            ps.setInt(2, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                if (lrList == null) {
                    lrList = new ArrayList<>();
                }
                int usersIdUser = result.getInt("lr_id_user");
                int idLr = result.getInt("id_lr");
                User user = new User();
                user.setIdUser(usersIdUser);
                String date = result.getDate("date").toString();
                String time = result.getTime("time").toString();
                String stat = result.getString("status");
                String type = result.getString("type");

                lrList.add(new LessonRequestBuilder().setIdLessonRequest(idLr).setDate(date).setTime(time).setStatus(stat)
                        .setType(type).setLrIdUser(user).build());
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lrList;
}

//    private static String CHANGE_STATUS = "UPDATE lesson_request SET status= ? WHERE id_lr = ?";
    public int changeStatus (int id, String newStatus) throws SQLException {
        int updateCounter = 0;
        try (Connection con = DBConnectionFactory.getDBConnection()) {
            try (PreparedStatement ps = con.prepareStatement(CHANGE_STATUS)) {
                ps.setString(1, newStatus);
                ps.setInt(2, id);
                updateCounter = ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateCounter;
    }

//    private static String CHANGE_STATUS_TO_OLD_MULTIPLE = "UPDATE lesson_request SET status='old' WHERE status='confirmed' AND date < ?";
    public int changeStatusToOldMultiple () throws SQLException {
        int updateCounter = 0;
            try (Connection con = DBConnectionFactory.getDBConnection()) {
                try (PreparedStatement ps = con.prepareStatement(CHANGE_STATUS)) {
                    ps.setDate(1, new Date(new java.util.Date().getTime()));
                    updateCounter = ps.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return updateCounter;
    }

    // private static String SELECT_BY_STATUS_FOR_ADMIN = "SELECT * FROM lesson_request WHERE status = ? AND date < ?";
    public List<LessonRequest> selectByStatusForAdmin (String status, Date todayDate){
        ArrayList<LessonRequest> lrList = null;
        try (Connection con = DBConnectionFactory.getDBConnection()) {
            try (PreparedStatement ps = con.prepareStatement(SELECT_BY_STATUS_FOR_ADMIN)) {
                ps.setString(1, status);
                ps.setDate(2, todayDate);
                ResultSet result = ps.executeQuery();
                while (result.next()) {
                    if (lrList == null) {
                        lrList = new ArrayList<>();
                    }
                    int usersIdUser = result.getInt("lr_id_user");
                    int idLr = result.getInt("id_lr");
                    User user = new User();
                    user.setIdUser(usersIdUser);
                    String date = result.getDate("date").toString();
                    String time = result.getTime("time").toString();
                    String stat = result.getString("status");
                    String type = result.getString("type");
                    lrList.add(new LessonRequestBuilder().setIdLessonRequest(idLr).setDate(date).setTime(time).setStatus(stat)
                            .setType(type).setLrIdUser(user).build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lrList;
    }
}
