package ua.litovka.controllers;

import ua.litovka.dto.MovieDTO;
import ua.litovka.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by SergLion on 23.02.2017.
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.print("<html><body><h2>Movies</h2>");
        out.print("<table border=\"1\" cellspacing=10 cellpadding=5>");
        out.print("<th>Movie title</th>");
        out.print("<th>Duration</th>");
        out.print("<th>Description</th>");

        for (MovieDTO movieDTO : MovieServiceImpl.getInstance().getAll()) {
            out.print("<tr>");
            out.print("<td>" + movieDTO.getTitle() + "</td>");
            out.print("<td>" + movieDTO.getDuration() + "</td>");
            out.print("<td>" + movieDTO.getDescription() + "</td>");
            out.print("</tr>");
        }

        out.print("</table></body><br/>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
