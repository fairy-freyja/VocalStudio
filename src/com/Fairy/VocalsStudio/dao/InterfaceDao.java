package com.Fairy.VocalsStudio.dao;

import java.sql.SQLException;

/**
 * Created by Wyvern on 12.05.2015.
 */
public interface InterfaceDao<T> {
    public T find (int id) throws SQLException;
    public int update (T value) throws SQLException;
    public int create (T value) throws SQLException;
    public void delete(int id)throws SQLException;
}
