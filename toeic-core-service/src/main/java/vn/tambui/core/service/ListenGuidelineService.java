package vn.tambui.core.service;

import vn.tambui.core.dto.ListenGuidelineDTO;

import java.util.List;

public interface ListenGuidelineService {
   Object[] findListenGuidelineByProperties(String property, Object value,
                                                             String sortExpression, String sortDirection ,
                                                             Integer offset, Integer limit);
}
