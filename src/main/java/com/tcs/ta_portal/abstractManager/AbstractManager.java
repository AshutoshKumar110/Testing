/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ta_portal.abstractManager;

import com.tcs.ignite.ta_portal.utils.PropertyFile;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ignite054
 * @param <T>
 */
/*
    managers having genric functions

 */
public class AbstractManager<T> {

    @Autowired
    SessionFactory sessionFactory;
    String SQL_PROPERTY_FILE = "query.properties";

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /*
    Genric save method
    @param obj
     */
    public T save(T obj) {
        if (obj != null) {
            getCurrentSession().save(obj);
        }
        return obj;
    }
/*
    
    */
    public List<T> findAll(Class T) {
        try {
            Criteria criteria = getCurrentSession().createCriteria(T);
            return criteria.list();
        } catch (Exception e) {
            return null;
        }
    }

    /*
    Genric method to find Trainee according to Batch
     */
    public List<T> findTraineeByBatch(String batch) {
        try {
//           Criteria cr = getCurrentSession().createCriteria(T);
//           cr.add(Restrictions.eq("batch",batch));
            return null;//cr.list();
        } catch (Exception ex) {
            return null;
        }
    }
   public T fetchTraineeByBatch(String str, Object value)
   {
       return fetchTraineeByBatch(str,new Object[]{value});
   }
   
     public T fetchTraineeByBatch(final String queryString, final Object[] values) {
        String hqlQuery = PropertyFile.fetchPropertyDirectly(SQL_PROPERTY_FILE, queryString);

        Query query = getCurrentSession().createQuery(hqlQuery);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return (T) query.uniqueResult();
    }
}
