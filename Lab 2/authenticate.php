<?php
session_start();
// Change this to your connection info.
$DATABASE_HOST = 'localhost';
$DATABASE_USER = '';
$DATABASE_PASS = '';
$DATABASE_NAME = 'ams_test';
// Try and connect using the info above.
$db = new PDO('mysql:host=127.0.0.1;dbname=ams_test', $DATABASE_USER, $DATABASE_PASS);

$con = mysqli_connect($DATABASE_HOST, $DATABASE_USER, $DATABASE_PASS, $DATABASE_NAME);
if ( mysqli_connect_errno() ) {
	// If there is an error with the connection, stop the script and display the error.
	die ('Failed to connect to MySQL: ' . mysqli_connect_error());
}


// Now we check if the data from the login form was submitted, isset() will check if the data exists.
if ( !isset($_POST['username'], $_POST['password']) ) {
	// Could not get the data that should have been sent.
	die ('Please fill both the username and password field!');
}

$username = $_POST['username'];
$password = $_POST['password'];

$results = $db->query("SELECT * FROM accounts WHERE username = '{$username}' AND password = '{$password}'");


if ($results->rowCount()) {
        session_regenerate_id();
		$_SESSION['loggedin'] = TRUE;
		$_SESSION['name'] = $_POST['username'];
		$_SESSION['id'] = $id;
		echo 'Welcome ' . $_SESSION['name'] . '!';
}