<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login</title>
</head>
<body>

<h2>User Login</h2>

<button onclick="location.href='register_form'">註冊</button>

<!-- 登入表單 -->
<form action="user_login_process" method="post">
    <div>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required>
    </div>
    <div>
        <label for="password_hash">Password:</label>
        <input type="password" id="password_hash" name="password_hash" required>
    </div>
    <div>
        <input type="submit" value="Login">
    </div>
</form>

</body>
</html>
