package vn.tambui.controller.admin;

import org.apache.log4j.Logger;
import vn.tambui.command.UserCommand;
import vn.tambui.core.dto.UserDTO;
import vn.tambui.core.web.utils.FormUtil;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.html")
public class LoginController  extends HttpServlet{

        private final Logger log = Logger.getLogger(this.getClass());

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher rd = request.getRequestDispatcher("views/web/login.jsp");
            rd.forward(request, response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
//            String name = request.getParameter("name");
//            String password = request.getParameter("password");

//            UserCommand command = FormUtil.populate(UserCommand.class, request);
//            UserDTO pojo = command.getPojo();

            RequestDispatcher rd = request.getRequestDispatcher("view/admin/home.jsp");
        rd.forward(request,response);
        }
    }

