package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FilmDao;

@WebServlet("/delete-film")
public class DeleteFilm extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		FilmDao dao = new FilmDao();
		dao.deleteFilm(id);
		resp.getWriter().print("<h1 align='center' style='color:green'>Movie Removed Success</h1>");
		req.getRequestDispatcher("home.html").include(req, resp);
	}
	
}
