<html>
    <head>
        <title>Login Page</title>
    </head>
<body>
    <h1>Log in</h1>
        <p><b>admin login:</b> admin@gmail.com, <b>pass:</b> 125</p>
        <p><b>user login:</b> user@gmail.com, <b>pass:</b> 124</p>
        <form role="form" action="spring_security_check" method="post">

            <table>
                <tr>
                    <td><label for="email">Email address</label></td>
                    <td><input type="email" name="email" id="email" required autofocus/></td>
                </tr>
                <tr>
                    <td><label for="password">Password</label></td>
                    <td><input type="password" name="password" id="password" required/></td>
                </tr>
            <tr>
                <td><label for="remember-me">Remember me</label>
                <input type="checkbox" name="remember-me" id="remember-me"/></td>
            </tr>
            <tr><td><button type="submit">Sign in</button></td></tr>
        </form>
</body>
</html>