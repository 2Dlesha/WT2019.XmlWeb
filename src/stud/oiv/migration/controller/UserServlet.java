package stud.oiv.migration.controller;

import stud.oiv.migration.beans.Librarian;
import stud.oiv.migration.beans.User;
import stud.oiv.migration.service.XmlService.XmlLibrarianService;
import stud.oiv.migration.service.XmlService.XmlUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 12L;
    public UserServlet()
    {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        XmlUserService librarianService = new XmlUserService();
        List<User> users = librarianService.getAll();
        request.setAttribute("users", users);
        System.out.println(users);
        RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/users");
        Dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>Welcome to servlets</h2>");
        } finally {
            writer.close();
        }
    }

    private void processRequest()
    {
        System.out.println("proccess");
    }
}