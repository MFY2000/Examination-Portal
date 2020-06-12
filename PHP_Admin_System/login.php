<?php 
session_start(); 
include "db_conn.php";

if (isset($_POST['username']) && isset($_POST['password'])) {

	function validate($data){
       $data = trim($data);
	   $data = stripslashes($data);
	   $data = htmlspecialchars($data);
	   return $data;
	}

	$uname = validate($_POST['username']);
	$pass = validate($_POST['password']);

	if (empty($uname)) {
		header("Location: login_page.php?error=User Name is required");
	    exit();
	}else if(empty($pass)){
        header("Location: login_page.php?error=Password is required");
	    exit();
	}else{
		$sql = "SELECT * FROM admin WHERE username='$uname' AND password='$pass'";

		$result = mysqli_query($conn, $sql);

		if (mysqli_num_rows($result) === 1) {
			$row = mysqli_fetch_assoc($result);
            if ($row['username'] === $uname && $row['password'] === $pass) {
            	$_SESSION['username'] = $row['username'];
            	//$_SESSION['name'] = $row['name'];
            	$_SESSION['id'] = $row['id'];
            	header("Location: Admin_pannel.php");
		        exit();
            }else{
				header("Location: login_page.php?error=Incorect User name or password");
		        exit();
			}
		}else{
			header("Location: login_page.php?error=Incorect User name or password");
	        exit();
		}
	}
	
}else{
	header("Location: login_page.php");
	exit();
}