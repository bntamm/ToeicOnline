package vn.tambui.controller.admin;

import vn.tambui.command.ListenGuidelineCommand;
import vn.tambui.core.dto.ListenGuidelineDTO;
import vn.tambui.core.web.common.WebConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin-guideline-listen-list.html")
public class ListenGuidelineController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        List<ListenGuidelineDTO> listenGuidelineDTOS = new ArrayList<ListenGuidelineDTO>();
        ListenGuidelineCommand command = new ListenGuidelineCommand();

        ListenGuidelineDTO dto1 = new ListenGuidelineDTO();
        dto1.setTitle("Bai HD Nghe 1");
        dto1.setContent("Noi dung bai hd nghe 1");
        listenGuidelineDTOS.add(dto1);

        ListenGuidelineDTO dto2 = new ListenGuidelineDTO();
        dto2.setTitle("Bai HD Nghe 2");
        dto2.setContent("Noi dung bai hd nghe 2");
        listenGuidelineDTOS.add(dto2);

        //gán list items result từ DTO vào Command
        //mà Command đã extend Abstract + tạo đối tượng pojo nên data hardcode sẽ đc đưa vào pojo
        command.setListResult(listenGuidelineDTOS);
        // Dựa vào maxPageItems và TotalItems để phân trang
        command.setMaxPageItems(1);
        command.setTotalItems(listenGuidelineDTOS.size());

        request.setAttribute(WebConstant.LIST_ITEMS, command); //để ngoài jsp nhận đc giá trị
        //ta sử dụng  request.setAttribute , gán command vào 1 list items

        RequestDispatcher rd = request.getRequestDispatcher("views/admin/listenguideline/list.jsp");
        rd.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        RequestDispatcher rd = request.getRequestDispatcher("views/admin/listenguideline/list.jsp");
//        rd.forward(request,response);
    }

}
