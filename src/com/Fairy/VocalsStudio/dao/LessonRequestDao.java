package com.Fairy.VocalsStudio.dao;

import com.Fairy.VocalsStudio.models.LessonRequest;

import java.sql.*;
import java.util.List;

/**
 * Created by Wyvern on 17.05.2015.
 */
public interface LessonRequestDao extends InterfaceDao<LessonRequest> {

    List<LessonRequest> findAllByUserID(int idUser) throws SQLException;

    List<LessonRequest> selectByStatusForAdmin (String status, Date todayDate)throws SQLException;

    List<LessonRequest> findByStatusForUser (int id, String status)throws SQLException;

    int changeStatus (int id, String newStatus)throws SQLException;

    int changeStatusToOldMultiple() throws SQLException;
}
