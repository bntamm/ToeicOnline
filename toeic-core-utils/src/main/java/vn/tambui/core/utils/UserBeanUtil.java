package vn.tambui.core.utils;

import vn.tambui.core.dto.UserDTO;
import vn.tambui.core.persistence.entity.UserEntity;

public class UserBeanUtil {

    //entity -> DTO
    public static UserDTO entityToDto(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setUserId(entity.getUserId());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setFullName(entity.getFullName());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setRoleDTO(RoleBeanUtil.entityToDto(entity.getRoleEntity()));
        return dto;
    }

    // DTO -> entity
    public static UserEntity dtoToEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setUserId(dto.getUserId());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setFullName(dto.getFullName());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setRoleEntity(RoleBeanUtil.dtoToEntity(dto.getRoleDTO()));

        return entity;
    }
}
