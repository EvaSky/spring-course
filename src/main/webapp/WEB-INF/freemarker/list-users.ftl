<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>List of users</title>
</head>
<body>
    <h3>List of users</h3>
    <div>
        <div>Search user</div>
        <form action="/users/list" method="get">
          Name: <input type="text" name="name" /><br/>
          <input type="submit" value="search" />
        </form>
      <br/>
        <#list model["users"] as user>
          <div>
            Email: <span>${user.email}</span> ---
            Name: <span>${user.name}</span>
          </div>
        </#list>
    </div>
</body>
</html>