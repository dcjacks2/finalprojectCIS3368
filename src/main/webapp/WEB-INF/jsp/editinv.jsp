<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="post" action="/saveinv">
    <input type="hidden" name="id" value="${selectedItem.getId()}" >
    <br>Item Name: <br>
    <input type="text" name="invdescription" value="${selectedItem.getInvDescription()}">
    <br>Item Price:<br>
    <input type="text" name="invprice" value="${selectedItem.getInvPrice()}" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>