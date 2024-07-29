<!DOCTYPE html>
<html>
<head>
    <title>ID Card Generator Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="login" method="post">
        Username: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
    <h1>Register</h1>
    <form action="register" method="post">
        Name: <input type="text" name="name" required><br>
        Age: <input type="text" name="age" required><br>
        Blood Group: <input type="text" name="blood_group" required><br>
        Register Number: <input type="text" name="register_number" required><br>
        Department: <input type="text" name="department" required><br>
        Username: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Register">
    </form>
    <c:if test="${param.error != null}">
        <p style="color:red;">Invalid username or password</p>
    </c:if>
    <c:if test="${param.registered != null}">
        <p style="color:green;">Registration successful. Please log in.</p>
    </c:if>
</body>
</html>
