package com.devs.issuetracker.dao;

import java.util.List;

import org.bson.types.ObjectId;

/**
 * Created by wamalalawrence
 *
 */


public interface GenericDao<T> {

    T selectById(ObjectId id);
    ObjectId insert(T entity);
    List<T> selectAll();
}
