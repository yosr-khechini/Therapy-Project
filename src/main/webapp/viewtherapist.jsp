<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entities.Therapist" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Therapists List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <div class="container mt-5">
        <h2 class="mb-4">Therapists</h2>
        <button type="button" class="btn btn-info mb-3"><a href="therapists?action=add" class="text-white text-decoration-none">Add New Therapist</a></button>
        <table class="table table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Speciality</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Therapist> therapists = (List<Therapist>) request.getAttribute("therapists");
                    if (therapists != null) {
                        for (Therapist t : therapists) {
                %>
                <tr>
                    <td><%= t.getId() %></td>
                    <td><%= t.getName() %></td>
                    <td><%= t.getSurname() %></td>
                    <td><%= t.getSpeciality() %></td>
                    <td><%= t.getEmail() %></td>
                    <td>
                        <button type="button" class="btn btn-warning btn-sm"><a href="therapists?action=edit&id=<%= t.getId() %>" class="text-dark text-decoration-none">Edit</a></button>
                        <button type="button" class="btn btn-danger btn-sm"><a href="therapists?action=delete&id=<%= t.getId() %>" class="text-white text-decoration-none" onclick="return confirm('Are you sure?')">Delete</a></button>
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