package vn.tambui.core.service;

import vn.tambui.core.dto.UserDTO;


public interface UserService {
    UserDTO isUserExist(UserDTO dto);
    UserDTO findRoleByUser(UserDTO dto);
}
