
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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

<h2> Inventory Database </h2>
<table>
    <tr>
        <th>Item Name</th>
        <th>Item Price</th>
        <th>Action</th>
    </tr>
    <c:forEach var = "listitem" items = "${inventoryList}">
        <tr>
            <td>${listitem.getInvDescription()}</td>
            <td>${listitem.getInvPrice()}</td>

            <td>
                <a href="/editinv/${listitem.getId()}">Edit</a>
                <a href="/deleteinv/${listitem.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<h3>Add a New Item:</h3>
<form method="post" action="/saveinv">
    <input type="hidden" name="id" >
    <br>Item Name: <br>
    <input type="text" name="invdescription" >
    <br>Item Price:<br>
    <input type="text" name="invprice" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>