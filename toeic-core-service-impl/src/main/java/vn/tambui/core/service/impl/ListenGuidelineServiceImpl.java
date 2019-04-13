package vn.tambui.core.service.impl;

import vn.tambui.core.dao.ListenGuidelineDao;
import vn.tambui.core.daoimpl.ListenGuidelineDaoImpl;
import vn.tambui.core.dto.ListenGuidelineDTO;
import vn.tambui.core.persistence.entity.ListenGuidelineEntity;
import vn.tambui.core.service.ListenGuidelineService;
import vn.tambui.core.utils.ListenGuidelineBeanUtil;

import java.util.ArrayList;
import java.util.List;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {

    private ListenGuidelineDao listenGuidelineDao = new ListenGuidelineDaoImpl();
    public  Object[] findListenGuidelineByProperties(String property, Object value,
                                                                    String sortExpression, String sortDirection,
                                                                    Integer offset, Integer limit) {
        List<ListenGuidelineDTO> result = new ArrayList<ListenGuidelineDTO>();
        Object[] objects = listenGuidelineDao.findByProperty(property, value, sortExpression,
                sortDirection, offset,limit);


        for(ListenGuidelineEntity item: (List<ListenGuidelineEntity>) objects[1]){
            ListenGuidelineDTO dto = ListenGuidelineBeanUtil.entityToDto(item);
            result.add(dto);
        }

        objects[1] = result;
        return objects;
    }
}
