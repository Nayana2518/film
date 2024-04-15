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

@WebServlet("/fetch-film-name")
public class FetchFilmByName extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("enter-name.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		
		FilmDao dao = new FilmDao();
		List<Film> List = dao.fetchFilmByName(name);
		if(List.isEmpty()) {
			resp.getWriter().print("<h1 style='color:red' align='center'>No Film Found</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		}else {
			req.setAttribute("list", List);
			req.getRequestDispatcher("fetchFilm.jsp").forward(req, resp);
		}
	}
	
}
