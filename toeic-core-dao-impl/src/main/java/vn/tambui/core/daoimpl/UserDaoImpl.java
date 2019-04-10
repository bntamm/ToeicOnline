package vn.tambui.core.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.tambui.core.common.utils.HibernateUtil;
import vn.tambui.core.dao.UserDao;
import vn.tambui.core.data.daoimpl.AbstractDao;
import vn.tambui.core.persistence.entity.UserEntity;

public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {

//    public UserEntity isUserExist(String name, String password) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        UserEntity entity = new UserEntity();
//
//        try {
//            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");
//
//            Query query = session.createQuery(sql.toString());
//            query.setParameter("name", name);
//            query.setParameter("password", password);
//            entity = (UserEntity) query.uniqueResult();
//            transaction.commit();
//        }catch (HibernateException e){
//            transaction.rollback();
//            throw e;
//        }finally {
//            session.close();
//        }
//
//
//        return entity;
//    }
//
//    public UserEntity findRoleByUser(String name, String password) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        UserEntity entity = new UserEntity();
//
//        try {
//            StringBuilder sql = new StringBuilder(" FROM UserEntity WHERE name= :name AND password= :password");
//
//            Query query = session.createQuery(sql.toString());
//            query.setParameter("name", name);
//            query.setParameter("password", password);
//            entity = (UserEntity) query.uniqueResult();
//            transaction.commit();
//        }catch (HibernateException e){
//            transaction.rollback();
//            throw e;
//        }finally {
//            session.close();
//        }
//
//
//        return entity;
//    }

    public UserEntity findUserByUsernameAndPassword(String name, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity entity = new UserEntity();

        try {
            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");

            Query query = session.createQuery(sql.toString());
            query.setParameter("name", name);
            query.setParameter("password", password);
            entity = (UserEntity) query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }


        return entity;
    }
}
