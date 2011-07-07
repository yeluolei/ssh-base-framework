package org.chinasb.framework.core.base.dao;

import java.io.Serializable;

import org.chinasb.framework.core.base.dao.hibernate.GenericDAOImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDAO<T, ID extends Serializable> extends GenericDAOImpl<T, ID> {
    
    @Autowired
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
	super.setSessionFactory(sessionFactory);
    }
}
