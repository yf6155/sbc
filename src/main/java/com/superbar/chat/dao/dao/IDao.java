package com.superbar.chat.dao.dao;

import java.io.Serializable;

public abstract interface IDao<T> extends Serializable {

    public abstract Integer insert(T t);

    public abstract T selectByKey(T t);

    public abstract Integer updateByKey(T t);

}
