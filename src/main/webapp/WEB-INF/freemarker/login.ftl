<html>
    <head>
        <title>Login Page</title>
    </head>
<body>
    <h1>Log in</h1>
        admin@gmail.com 125
        <form role="form" action="spring_security_check" method="post">

            <div>
                <label for="email">Email address</label>
                <input type="email" name="email" id="email" required autofocus/>
            </div>
            <div>
                <label for="password">Password</label>
                <input type="password" name="password" id="password" required/>
            </div>
            <div>
                <label for="remember-me">Remember me</label>
                <input type="checkbox" name="remember-me" id="remember-me"/>
            </div>
            <button type="submit">Sign in</button>
        </form>
</body>
</html>