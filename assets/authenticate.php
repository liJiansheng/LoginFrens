<?php

// User id

$email = $_POST['email'];
$password = $_POST['password'];

$dbConnect = GetDbConnection();

 function GetDbConnection() {
  $db_host = "localhost";
$db_username = "user";
$db_passwd = "password123";
$db_name = "cep13y4";
$dbc = mysqli_connect($db_host, $db_username, $db_passwd, $db_name) or die ("Could not connect!\n ");

return $dbc;
  }
  
 function Login($dbConnection, $email,$password) {

 $q="SELECT name, email FROM users WHERE email='$email' and password='$password'";
 $r = mysqli_query($dbConnection,$q);

 
 while ($row = mysqli_fetch_array($r, MYSQLI_ASSOC)){
    $d = $row;
}
echo json_encode($d); 
/* $r = mysqli_query($dbConnection,$q);
 $str = "<div id='events'><h1>Events</h1><ul id ='events'>";
		while ($row = mysqli_fetch_array($r, MYSQLI_ASSOC)) {
			$str = $str. "<li>". $row['event_name'] ."</li>";
			}
	$str = $str . "</ul></div>";
	
	echo $str;*/
}
 
Login($dbConnect, $email,$password);

?>