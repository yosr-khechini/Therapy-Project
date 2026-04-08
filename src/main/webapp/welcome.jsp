<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
</head>
<body>
   <div class="container mt-5">
    <h2 class="mb-4">Welcome Page</h2>

    <% 
        // Retrieve the user stored in session
        String user = (String) request.getAttribute("name");
    %>
        <p class="mb-4">Hello, <b><%= user %></b>! You have successfully logged in.</p>
        <div class="btn-group-vertical w-100 gap-2" role="group">
            <a href="therapists?action=list" class="btn btn-success">view all therapists</a>
            <a href="therapists?action=add" class="btn btn-info">add therapist</a>
            <a href="patients?action=list" class="btn btn-success">view all patients</a>
            <a href="patients?action=add" class="btn btn-info">add patient</a>
        </div>
   </div>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>