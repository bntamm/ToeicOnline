package vn.tambui.core.service.impl;

import vn.tambui.core.dao.UserDao;
import vn.tambui.core.daoimpl.UserDaoImpl;
import vn.tambui.core.dto.UserDTO;

import vn.tambui.core.persistence.entity.UserEntity;
import vn.tambui.core.service.UserService;
import vn.tambui.core.utils.UserBeanUtil;

public class UserServiceImpl implements UserService {


    public UserDTO isUserExist(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity entity = userDao.isUserExist(dto.getName(), dto.getPassword());
        return UserBeanUtil.entityToDto(entity);
        //UserBeanUtil : convert Entity -> DTO và ngược lại
    }

    public UserDTO findRoleByUser(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity entity = userDao.findRoleByUser(dto.getName(), dto.getPassword());
        return UserBeanUtil.entityToDto(entity);
        //UserBeanUtil : convert Entity -> DTO và ngược lại
    }
}
