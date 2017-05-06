package com.dlgr.yoksis.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class BaseDao<T> {
    private Class<T> persistentClass;

    public BaseDao(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    //    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {

        Configuration config = new Configuration();
        config.configure();

        ServiceRegistry serviceRegistry = (ServiceRegistry) new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        sessionFactory = config.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    public Session getSession() throws HibernateException {
        Session sess;
        try {
            sess = getSessionFactory().getCurrentSession();
            if (sess == null) {
                sess = getSessionFactory().openSession();
            }
        }catch (HibernateException e){
            sess = getSessionFactory().openSession();
        }

        return sess;
    }

    public T get(Long id) {
        Session sess = getSession();
        return (T) getSession().get(persistentClass, id);
//        IdentifierLoadAccess byId = sess.getIdentifier(persistentClass);
//        T entity = (T) byId.load(id);
//
//        if (entity == null) {
////            //log.warn("Uh oh, '" + this.persistentClass + "' object with id '" + id + "' not found...");
//            throw new ObjectRetrievalFailureException(persistentClass, id);
//        }
//        return entity;
    }

    public List<T> getAll() {
        return getSession().createCriteria(persistentClass).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).addOrder(Order.asc("id")).list();
    }

    public List<T> getAllWithSortBy(String col) {
        return getSession().createCriteria(persistentClass).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).addOrder(Order.asc(col)).list();
    }

    public T saveEntity(T entity) {
        getSession().saveOrUpdate(entity);

        getSession().flush();
        return entity;
    }

    public T save(T entity) {
        return this.saveEntity(entity);
    }

    public T merge(T entity) {
        getSession().merge(entity);

        return entity;
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

}
