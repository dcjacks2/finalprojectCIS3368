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
<body>
<h2> Customer Database </h2>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Action</th>
    </tr>
    <c:forEach var = "listitem" items = "${customerList}">
        <tr>
            <td>${listitem.getFirstName()}</td>
            <td>${listitem.getLastName()}</td>
            <td>
                <a href="/editcu/${listitem.getId()}">Edit</a>
                <a href="/deletecu/${listitem.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>Add a New Customer:</h3>
<form method="post" action="/savecu">
    <input type="hidden" name="id" >
    <br>First Name: <br>
    <input type="text" name="firstname" >
    <br>Last name:<br>
    <input type="text" name="lastname" >
    <br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>