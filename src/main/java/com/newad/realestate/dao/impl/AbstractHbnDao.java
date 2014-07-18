package com.newad.realestate.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.newad.realestate.dao.Dao;

public abstract class AbstractHbnDao<T extends Object> implements Dao<T> {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private Class<T> domainClass;
    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    protected Criteria createCriteria() {
        return getSession().createCriteria(getDomainClass());
    }
    
    @SuppressWarnings("unchecked")
    private Class<T> getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }
    
    private String getDomainClassName() {
        return getDomainClass().getName();
    }

    @Override
    public Long create(T t) {
        return (Long) getSession().save(t);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(Serializable id) {
        return (T) getSession().get(getDomainClass(), id);
    }

    @Override
    public T load(Serializable id) {
        return get(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        return getSession()
                .createQuery("from " + getDomainClassName() + " t order by t.id")
                .list();
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public void delete(T t) {
        getSession().delete(t);
    }

    @Override
    public void deleteById(Serializable id) {
        delete(load(id));
    }

    @Override
    public void deleteAll() {
        getSession()
            .createQuery("delete " + getDomainClassName())
            .executeUpdate();
    }

    @Override
    public long count() {
        return (Long) getSession()
                .createQuery("select count(*) from " + getDomainClassName())
                .uniqueResult();
    }

    @Override
    public boolean exists(Serializable id) {
        return (get(id) != null);
    }

}
