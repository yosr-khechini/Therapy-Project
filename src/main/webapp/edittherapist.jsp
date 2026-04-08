<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.entities.Therapist" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= request.getAttribute("therapist")%> Therapist</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <%
            Therapist t = (Therapist) request.getAttribute("therapist");
        %>
        <h2 class="mb-4">Edit Therapist</h2>
        <form action="therapists?action=edit" method="post" class="col-md-6">
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="<%= t.getName() %>" required>
            </div>
            <div class="mb-3">
                <label for="surname" class="form-label">Surname:</label>
                <input type="text" class="form-control" id="surname" name="surname" value="<%= t.getSurname() %>" required>
            </div>
            <div class="mb-3">
                <label for="speciality" class="form-label">Speciality:</label>
                <input type="text" class="form-control" id="speciality" name="speciality" value="<%= t.getSpeciality()%>" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= t.getEmail()%>" required>
            </div>
            <div class="d-flex gap-2">
                <button type="submit" class="btn btn-primary">Update Therapist</button>
                <a href="therapists?action=list" class="btn btn-secondary">Back to List</a>
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>