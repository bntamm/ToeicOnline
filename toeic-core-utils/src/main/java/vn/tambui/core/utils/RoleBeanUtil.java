package vn.tambui.core.utils;

import vn.tambui.core.dto.RoleDTO;
import vn.tambui.core.persistence.entity.RoleEntity;

public class RoleBeanUtil {

    public static RoleDTO entityToDto(RoleEntity entity){
        RoleDTO dto = new RoleDTO();
        dto.setRoleId(entity.getRoleId());
        dto.setName(entity.getName());
        return dto;
    }

    public static RoleEntity dtoToEntity(RoleDTO dto){
        RoleEntity entity = new RoleEntity();
        entity.setRoleId(dto.getRoleId());
        entity.setName(dto.getName());
        return entity;
    }
}
