<?php

session_start();

?>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Login</title>
	</head>
	<body>
		<div>
			<h1>Login</h1>
			<form action="authenticate.php" method="post">
				<label for="username">
				</label>
				<input type="text" name="username" placeholder="Username" id="username" required>
				<label for="password">
				</label>
				<input type="password" name="password" placeholder="Password" id="password" required>
				<input type="submit" value="Login">
			</form>
		</div>
        
        <br><br><br><br>
        <form action="script.php" method="get">
        <label>Enter text!</label><br><br>
            <input type="text" name="query" style="font-size: 20px; width: 300px;">
            <input type="submit" value="Go" style="font-size: 20px;">
        </form><br><br>
	</body>
</html>