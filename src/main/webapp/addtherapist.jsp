<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Therapist</title>
</head>
<body>
    <h2>Add a New Therapist</h2>
    <form action="addtherapist" method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><input type="text" name="surname" required></td>
            </tr>
            <tr>
                <td>Speciality:</td>
                <td><input type="text" name="speciality" required></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add Therapist">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>