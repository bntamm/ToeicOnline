package vn.tambui.core.dao;

import vn.tambui.core.data.dao.GenericDao;
import vn.tambui.core.persistence.entity.UserEntity;

public interface UserDao extends GenericDao<Integer, UserEntity> {

     UserEntity isUserExist(String name, String password);
     UserEntity findRoleByUser(String name, String password);
}
