package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.metiers.ModelAdmin;

import java.io.IOException;
import java.sql.SQLException;

import dao.DaoAdmin;

/**
 * Servlet implementation class ServletAth
 */
@WebServlet("/login.php")
public class ServletAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private ModelAdmin modeladmin = new ModelAdmin();
	private DaoAdmin dao = new DaoAdmin();
    public ServletAuth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		modeladmin.setAdmin(new model.entities.Administrateur(login, password));
		
		try {
			if (dao.findAdmin(modeladmin.getAdmin())) {
				request.setAttribute("nom", login);
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
