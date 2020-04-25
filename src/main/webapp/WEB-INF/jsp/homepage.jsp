<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Store Homepage</title>
</head>
<h2>Welcome to Apocalypse Goods!</h2>
<br>
<text>Where you can find all your goods at a whole price, Don't kill over toilet paper!</text>
<br>
<br>
<body>
<a href="/indexcu/${listitem.getId()}">Customers</a>
<a href="/indexem/${listitem.getId()}">Employees</a>
<a href="/indexinv/${listitem.getId()}">Inventory</a>
<a href="/indextr/${listitem.getId()}">Transactions</a>

</body>
</html>