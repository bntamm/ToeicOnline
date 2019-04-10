package vn.tambui.core.dao;

import vn.tambui.core.data.dao.GenericDao;
import vn.tambui.core.persistence.entity.UserEntity;

public interface UserDao extends GenericDao<Integer, UserEntity> {

//     UserEntity isUserExist(String name, String password);
//     UserEntity findRoleByUser(String name, String password);
    //do 2 hàm trên có code giống nhau nên ta clean code cho nó thành 1 hàm findUserByUsernameAndPassword

    UserEntity findUserByUsernameAndPassword(String name, String password);
}
