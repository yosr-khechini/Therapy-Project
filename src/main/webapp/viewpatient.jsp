<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entities.Patient" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patients List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <div class="container mt-5">
        <h2 class="mb-4">Patients</h2>
        <button type="button" class="btn btn-info mb-3"><a href="patients?action=add" class="text-white text-decoration-none">Add New Patient</a></button>
        <table class="table table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Phone</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Patient> patients = (List<Patient>) request.getAttribute("patients");
                    if (patients != null) {
                        for (Patient p : patients) {
                %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getName() %></td>
                    <td><%= p.getSurname() %></td>
                    <td><%= p.getPhone() %></td>
                    <td>
                        <button type="button" class="btn btn-warning btn-sm"><a href="patients?action=edit&id=<%= p.getId() %>" class="text-dark text-decoration-none">Edit</a></button>
                        <button type="button" class="btn btn-danger btn-sm"><a href="patients?action=delete&id=<%= p.getId() %>" class="text-white text-decoration-none" onclick="return confirm('Are you sure?')">Delete</a></button>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
