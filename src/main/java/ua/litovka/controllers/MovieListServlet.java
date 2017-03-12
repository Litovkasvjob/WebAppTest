package ua.litovka.controllers;

import ua.litovka.dto.MovieDTO;
import ua.litovka.model.Movie;
import ua.litovka.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by SergLion on 23.02.2017.
 */
@WebServlet(name = "MovieListServlet", urlPatterns = {"/"})
public class MovieListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MovieDTO> movieDTOList = MovieServiceImpl.getInstance().getAll();
        request.setAttribute("movieDTOList", movieDTOList);
        request.getRequestDispatcher("pages/common/movies.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
