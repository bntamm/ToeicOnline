package vn.tambui.core.test;

import org.testng.annotations.Test;
import vn.tambui.core.dao.ListenGuidelineDao;

import vn.tambui.core.daoimpl.ListenGuidelineDaoImpl;

public class ListenGuidelineTest {

    @Test
    public void testFindByProperties(){
        ListenGuidelineDao listenGuidelineDao = new ListenGuidelineDaoImpl();

        Object[] result = listenGuidelineDao.findByProperty(null,
                null, null , null , 4 , 2 );


    }

}
