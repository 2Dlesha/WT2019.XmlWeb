package stud.oiv.migration.controller;

import stud.oiv.migration.beans.*;

import stud.oiv.migration.service.XmlService.XmlBookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 13L;
    public BookServlet()
    {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {

            List<Book> books = null;
            XmlBookService service = new XmlBookService();
            books = service.getAll();
            System.out.println(books);

            writer.println("<h2>Books</h2>");
            writer.println("<table>");
            for (Book book: books)
            {
                System.out.println(book);
                writer.println("<tr>");

                writer.println("<td>" + book.getId() + "</td>");
                writer.println("<td>" + book.getName() + "</td>");
                writer.println("<td>" + book.getPageCount() + "</td>");
                writer.println("<td>" + book.getAuthor() + "</td>");

                if(book instanceof Comics){
                    writer.println("<td>" + ((Comics) book).getGenre() + "</td>");
                    writer.println("<td>" + ((Comics) book).getType() + "</td>");
                }
                else if(book instanceof ArtBook){
                    writer.println("<td>" + ((ArtBook) book).getGenre() + "</td>");
                }
                else if(book instanceof StudyBook){
                    writer.println("<td>" + ((StudyBook) book).getSubject() + "</td>");
                }
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.println("<a href=\"index.jsp\">return</a>");

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            writer.println(e.getMessage());
        }
        finally {
            writer.close();
        }
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