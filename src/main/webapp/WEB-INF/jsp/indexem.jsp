<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Table</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
            width: 150px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<br>
<h2> Employee Database </h2>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Job Position</th>
        <th>Action</th>
    </tr>
    <c:forEach var = "listitem" items = "${employeeList}">
        <tr>
            <td>${listitem.getFirstName()}</td>
            <td>${listitem.getLastName()}</td>
            <td>${listitem.getJobPosition()}</td>
            <td>
                <a href="/editem/${listitem.getId()}">Edit</a>
                <a href="/deleteem/${listitem.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br></br>
<h3>Add a New Employee:</h3>
<form method="post" action="/saveem">
    <input type="hidden" name="id" >
    <br>First Name: <br>
    <input type="text" name="firstname" >
    <br>Last name:<br>
    <input type="text" name="lastname" >
    <br>Job Position: <br>
    <input type="text" name="jobposition" >
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>