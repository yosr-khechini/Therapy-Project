<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <link href="style.css" rel="stylesheet">
</head>
<body>
    <h2>Welcome Page</h2>

    <% 
        // Retrieve the user stored in session
        String user = (String) session.getAttribute("nom");
    %>
        <p>Hello, <b><%= user %></b>! You have successfully logged in.</p>
        <a href="addtherapist.html">add therapist</a>
</body>
</html>