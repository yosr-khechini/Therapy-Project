<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.entities.Patient" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%= request.getAttribute("patient")%> Patient</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="container mt-5">
        <%
            Patient p = (Patient) request.getAttribute("patient");
        %>
        <h2 class="mb-4">Edit Patient</h2>
        <form action="patients?action=edit" method="post" class="col-md-6">
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="<%= p.getName() %>" required>
            </div>
            <div class="mb-3">
                <label for="surname" class="form-label">Surname:</label>
                <input type="text" class="form-control" id="surname" name="surname" value="<%= p.getSurname() %>" required>
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">Phone:</label>
                <input type="text" class="form-control" id="phone" name="phone" value="<%= p.getPhone()%>" required>
            </div>
            <div class="d-flex gap-2">
                <button type="submit" class="btn btn-primary">Update Patient</button>
                <a href="patients?action=list" class="btn btn-secondary">Back to List</a>
            </div>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>