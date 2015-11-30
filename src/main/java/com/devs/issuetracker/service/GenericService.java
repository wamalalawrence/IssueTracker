package com.devs.issuetracker.service;

import java.util.List;

import org.bson.types.ObjectId;

/**
 * Created by wamalalawrence
 */
public interface GenericService <T>
{
    public ObjectId add(T entity);
    public T get(ObjectId id);
    public List<T> getAll();
}
