package com.Fairy.VocalsStudio.dao;

/**
 * Created by Wyvern on 12.05.2015.
 */
public interface InterfaceDao<T> {
    public T find (int id);
    public T update (T value);
    public T create (T value);
    public void delete(int id);
}
