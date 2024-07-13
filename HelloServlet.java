package p1;
import dao.Dao;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("Register servlet");
        String mail=request.getParameter("email");
        String pwd=request.getParameter("password");
        String pno=request.getParameter("phone");
        String adr=request.getParameter("address");
        Dao dao1=new Dao();
        boolean flag=dao1.doRegister(mail, pwd, pno, adr);
        if(flag)
        {
        	response.sendRedirect("index.html");
        }else {
        	response.sendRedirect("index.html?msg=registration failed...");
        }
    }
}


