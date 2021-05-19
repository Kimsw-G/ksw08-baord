<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <div>${errMsg}</div>
    <div>
        <form action="login" method="post">
            <div><input type="text" name="uid" placeholder="id" value="kimsw"></div>
            <div><input type="password" name="upw" placeholder="password" value="3445"></div>
            <div>
                <input type="submit" value="Login">
            </div>
        </form>

        <div>
            <a href="join">join</a>
        </div>
    </div>
</body>
</html>