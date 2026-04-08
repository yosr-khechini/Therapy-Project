package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entities.Patient;
import model.metiers.ModelPatient;

import java.io.IOException;

/**
 * Servlet implementation class ServletPatient
 */
@WebServlet({ "/ServletPatient", "/Patient.php", "/patients", "/Patients"})
public class ServletPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPatient() {
        super();
        // TODO Auto-generated constructor stub
    }
    private ModelPatient modelpatient= new ModelPatient();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listPatients(request, response);
                break;
            case "add":
                request.getRequestDispatcher("addpatient.jsp").forward(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deletePatient(request, response);
                break;
            default:
                listPatients(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("update".equals(action)) {
            updatePatient(request, response);
        } else {
            addPatient(request, response);
        }
    }

    private void listPatients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("patients", modelpatient.getAllPatients());
        request.getRequestDispatcher("viewpatient.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Patient p = modelpatient.getPatientById(id);
        request.setAttribute("patient", p);
        request.getRequestDispatcher("addpatient.jsp").forward(request, response);
    }

    private void addPatient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        modelpatient.setPatient(new Patient(name, surname, phone));
        modelpatient.addPatient();
        response.sendRedirect("Patients?action=list");
    }

    private void updatePatient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        modelpatient.setPatient(new Patient(id, name, surname, phone));
        modelpatient.updatePatient();
        response.sendRedirect("Patients?action=list");
    }

    private void deletePatient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        modelpatient.deletePatient(id);
        response.sendRedirect("Patients?action=list");
    }
}
