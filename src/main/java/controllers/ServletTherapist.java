package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entities.Therapist;
import model.metiers.ModelTherapist;

import java.io.IOException;
import java.sql.SQLException;

import dao.DaoTherapist;

/**
 * Servlet implementation class ServletTherapist
 */
@WebServlet({ "/ServletTherapist", "/addtherapist" })
public class ServletTherapist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTherapist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addtherapist.jsp").forward(request, response);
	} 
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String speciality = request.getParameter("speciality");
		String email = request.getParameter("email");
		DaoTherapist daotherapist = new DaoTherapist();
		ModelTherapist modeltherapist = new ModelTherapist();
		modeltherapist.setTherapist(new Therapist(name, surname, speciality, email));
		
		daotherapist.addTherapist(modeltherapist.Therapist());
		request.setAttribute("nom", name);
		response.sendRedirect("viewtherapist.jsp");
	}

}
