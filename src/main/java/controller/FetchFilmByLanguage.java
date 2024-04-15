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

@WebServlet("/fetch-film-language")
public class FetchFilmByLanguage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("enter-language.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String language = req.getParameter("language");
		
		FilmDao dao = new FilmDao();
		List<Film> List = dao.fetchFilmByLanguage(language);
		if(List.isEmpty()) {
			resp.getWriter().print("<h1 style='color:red' align='center'>No Film Found</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		}else {
			req.setAttribute("list", List);
			req.getRequestDispatcher("fetchFilm.jsp").forward(req, resp);
		}
	}
}
