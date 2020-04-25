<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="post" action="/saveem">
    <input type="hidden" name="id" value="${selectedItem.getId()}">
    <br>First Name: <br>
    <input type="text" name="firstname" value="${selectedItem.getFirstName()}">
    <br>Last name:<br>
    <input type="text" name="lastname" value="${selectedItem.getLastName()}">
    <br>Job Position: <br>
    <input type="text" name="jobposition" value="${selectedItem.getJobPosition()}" >
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>