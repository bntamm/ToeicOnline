package vn.tambui.core.web.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class FormUtil {

    //method populate này có nhiệm vụ lấy data khi ta khai báo name="..." (như bài 28 cách đầu tiên)
    // trong các component của file jsp giống với các thuộc tính trong DTO
    public static <T> T populate(Class<T> clazz, HttpServletRequest request)  {
        T object = null;
        try {
            object = (T) clazz.newInstance();
            BeanUtils.populate(object, request.getParameterMap());
        } catch (InstantiationException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }
}
