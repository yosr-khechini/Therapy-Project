package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entities.Therapist;
import model.metiers.ModelTherapist;

import java.io.IOException;

/**
 * Servlet implementation class ServletTherapist
 */
@WebServlet({ "/ServletTherapist", "/therapists" })
public class ServletTherapist extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ModelTherapist modelTherapist = new ModelTherapist();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listTherapists(request, response);
                break;
            case "add":
                request.getRequestDispatcher("addtherapist.jsp").forward(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteTherapist(request, response);
                break;
            default:
                listTherapists(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("update".equals(action)) {
            updateTherapist(request, response);
        } else {
            addTherapist(request, response);
        }
    }

    private void listTherapists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("therapists", modelTherapist.getAllTherapists());
        request.getRequestDispatcher("viewtherapist.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Therapist t = modelTherapist.getTherapistById(id);
        request.setAttribute("therapist", t);
        request.getRequestDispatcher("addtherapist.jsp").forward(request, response);
    }

    private void addTherapist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String speciality = request.getParameter("speciality");
        String email = request.getParameter("email");
        modelTherapist.setTherapist(new Therapist(name, surname, speciality, email));
        modelTherapist.addTherapist();
        response.sendRedirect("therapists?action=list");
    }

    private void updateTherapist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String speciality = request.getParameter("speciality");
        String email = request.getParameter("email");
        modelTherapist.setTherapist(new Therapist(id, name, surname, speciality, email));
        modelTherapist.updateTherapist();
        response.sendRedirect("therapists?action=list");
    }

    private void deleteTherapist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        modelTherapist.deleteTherapist(id);
        response.sendRedirect("therapists?action=list");
    }
}
