package org.mycompany.myname;

/**
 * Created by anon on 1/10/2017.
 */

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet(urlPatterns = "/servlet")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {

        httpServletResponse.setContentType("text/html");
        httpServletResponse.setCharacterEncoding("UTF-8");
        //httpServletRequest.setCharacterEncoding("UTF-8"); //для пост работает

        String name = httpServletRequest.getParameter("name");
        String surname = httpServletRequest.getParameter("surname");
        String[] jobs = httpServletRequest.getParameterValues("job");


        PrintWriter writer = httpServletResponse.getWriter();

        writer.println("Hello from servlet " + name + " " + surname + "<br>");
        if (jobs != null) {
            for (String s : jobs) {
                writer.println(s + " ");
            }
            writer.println("<br>");
        }

        HttpSession session = httpServletRequest.getSession();
        ServletContext context = httpServletRequest.getServletContext();
        if (name != null && !name.equals("")) {
            session.setAttribute("user", name);
            context.setAttribute("context", surname);
        }
        writer.println("Session : " + session.getAttribute("user") + "<br>" + "Context " + context.getAttribute("context"));
    }


}