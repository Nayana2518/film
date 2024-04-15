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


@WebServlet("/fetch-film")
public class FetchFilm extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		FilmDao dao = new FilmDao();
		List<Film> list = dao.fetchFilm();
		if (list.isEmpty()) {
			resp.getWriter().print("<h1 style='color:red' align='center'> No Movies Found</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		} else {
			req.setAttribute("list", list);
			req.getRequestDispatcher("fetchFilm.jsp").forward(req, resp);
		}
	}
	
}
