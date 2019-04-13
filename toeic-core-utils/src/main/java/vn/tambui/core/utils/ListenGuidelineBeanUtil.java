package vn.tambui.core.utils;


import vn.tambui.core.dto.ListenGuidelineDTO;
import vn.tambui.core.persistence.entity.ListenGuidelineEntity;

public class ListenGuidelineBeanUtil {

    public static ListenGuidelineDTO entityToDto(ListenGuidelineEntity entity){
        ListenGuidelineDTO dto = new ListenGuidelineDTO();
        dto.setListenguidelineId(entity.getListenguidelineId());
        dto.setTitle(entity.getTitle());
        dto.setImage(entity.getImage());
        dto.setContent(entity.getContent());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }

    public static ListenGuidelineEntity dtoToEntity(ListenGuidelineDTO dto){
        ListenGuidelineEntity entity = new ListenGuidelineEntity();
        entity.setListenguidelineId(dto.getListenguidelineId());
        entity.setTitle(dto.getTitle());
        entity.setImage(dto.getImage());
        entity.setContent(dto.getContent());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setModifiedDate(dto.getModifiedDate());
        return entity;
    }
}
