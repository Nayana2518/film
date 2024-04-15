package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FilmDao;
import dto.Film;


@WebServlet("/fetch-film-rating")
public class FetchFilmByRating extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("enter-rating.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double rating = Double.parseDouble(req.getParameter("rating"));
		
		FilmDao dao = new FilmDao();
		List<Film> List = dao.fetchFilmByRating(rating);
		if(List.isEmpty()) {
			resp.getWriter().print("<h1 style='color:red' align='center'>No Movies Found</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		}else {
			req.setAttribute("list",List);
			req.getRequestDispatcher("fetchFilm.jsp").forward(req, resp);
		}
	}
	
}
