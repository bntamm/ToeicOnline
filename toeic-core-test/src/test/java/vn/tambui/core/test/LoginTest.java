package vn.tambui.core.test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import vn.tambui.core.dao.UserDao;
import vn.tambui.core.daoimpl.UserDaoImpl;
import vn.tambui.core.persistence.entity.UserEntity;

public class LoginTest {

    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void checkIsUserExist(){
        String name = "tambui";
        String password = "301194";

        UserDao userDao = new UserDaoImpl();
        UserEntity entity =  userDao.isUserExist(name,password);
        if(entity != null){
            log.error("login success");
        }else{
            log.error("login failed");
        }
    }

    @Test
    public void checkFindRoleByUser(){
        String name = "tambui";
        String password = "301194";

        UserDao userDao = new UserDaoImpl();
        UserEntity entity =  userDao.findRoleByUser(name,password);
        log.error(entity.getRoleEntity().getRoleId() +" - "+entity.getRoleEntity().getName());
    }
}
