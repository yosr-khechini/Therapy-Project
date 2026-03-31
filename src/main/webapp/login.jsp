<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
<form action="login.php" method="post">
	<div class="container">
		<div>
  			<label class="col-form-label mt-4" for="login">Login</label>
  			<input type="text" class="form-control" placeholder="Login" id="login" name="login" required >
		</div>

	    <div>
      		<label for="password" class="form-label mt-4">Password</label>
      		<input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
    	</div>
    	<button type="submit" class="btn btn-primary" name="connecter">Submit</button>
	</div>
	</form>
</body>
</html>