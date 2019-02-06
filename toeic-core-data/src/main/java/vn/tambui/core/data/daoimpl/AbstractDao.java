package vn.tambui.core.data.daoimpl;

import org.hibernate.*;
import vn.tambui.core.common.constant.CoreConstant;
import vn.tambui.core.common.utils.HibernateUtil;
import vn.tambui.core.data.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;



public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID,T> {
    //B1: OpenSession
//    protected Session getSession(){
//        return HibernateUtil.getSessionFactory().openSession();
//    }

    //B2: tạo 1 metyhod để get tên Class Entity để truyền vào <T>
    private Class<T> persistenceClass;
    //tao constructor cho AbstractDao
    public AbstractDao(){
        this.persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    //B3: tạo method để chuyển đổi dạng class thành dạng string để input vào câu sql
    // -> select * from "persistenceClass"....
    public String getPersistenceClassName(){
        return persistenceClass.getSimpleName();
    }

    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        //Open Session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            //HQL
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            Query query = session.createQuery(sql.toString());
            list = query.list();
            transaction.commit();
        }catch(HibernateException err){
            transaction.rollback();
            throw err;
        }finally {
            session.close();
        }
        return list;
    }


    public T update(T entity) {
        //sử dụng phương thức merge của session để update
        T result = null;
        //Open Session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Object object = session.merge(entity);
            result = (T) object;
            transaction.commit();

        }catch(HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return result;
    }

    public void save(T entity) {
        //sử dụng phương thức persist của session để save
        //Open Session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(entity);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }



    }

    public T findById(ID id) {
        T result = null;
        //sử dụng phương thức get của session để findById
        //Open Session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Object object = session.get(persistenceClass, id);
            result = (T) object;
            if(result == null){
                throw new ObjectNotFoundException("NOT FOUND " +id, null);
            }
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

        return result;
    }

    public Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection) {

        List<T> list = new ArrayList<T>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Object totalItem = 0;
        try {
            //HQL
            //from getPersistenceClassName() where property= :value order by sortExpression sortDirection
            StringBuilder sql1 = new StringBuilder("from ");
            sql1.append(getPersistenceClassName());

            if(property != null && value != null){
                sql1.append(" where ").append(property).append("= :value");
            }
            if(sortExpression != null && sortDirection != null){
                sql1.append(" order by ").append(sortExpression);
                sql1.append(" "+(sortDirection.equals(CoreConstant.SORT_ASC) ? "asc" : "desc"));
            }
            Query query1 = session.createQuery(sql1.toString());

            if (value != null){
                query1.setParameter("value" , value);
            }
            list = query1.list();


            //count list size
            //select count(*) from getPersistenceClassName() where property = :value
            StringBuilder sql2 = new StringBuilder("select count(*) from ");
            sql2.append(getPersistenceClassName());
            if(property != null && value != null){
                sql2.append(" where ").append(property).append("= :value");
            }
            Query query2 = session.createQuery(sql2.toString());
            if (value != null){
                query2.setParameter("value" , value);
            }
            totalItem = query2.list().get(0);

            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

        return new Object[]{totalItem,list};
    }

    public Integer delete(List<ID> ids) {
        Integer count = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            for(ID item : ids){
               T t = (T) session.get(persistenceClass,item);
               session.delete(t);
               count++;
            }

            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

        return count;
    }


}
