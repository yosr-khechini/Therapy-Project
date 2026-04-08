<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="login.css">
</head>
<body>
<form action="login.php" method="post">
	<div class="container mt-5">
		<div class="col-md-4 offset-md-4">
  			<label class="form-label mt-4" for="login">Login</label>
  			<input type="text" class="form-control" placeholder="Login" id="login" name="login" required>
		</div>

	    <div class="col-md-4 offset-md-4">
      		<label for="password" class="form-label mt-4">Password</label>
      		<input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
    	</div>
    	<div class="col-md-4 offset-md-4 mt-4">
    		<button type="submit" class="btn btn-primary w-100" name="connecter">Submit</button>
    	</div>
	</div>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>