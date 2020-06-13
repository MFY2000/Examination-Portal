<?php 
session_start(); 
include "db_conn.php";

if (isset($_POST['name']) && isset($_POST['email']) && isset($_POST['message'])) {

	function validate($data){
       $data = trim($data);
	   $data = stripslashes($data);
	   $data = htmlspecialchars($data);
	   return $data;
	}
         if($_SERVER['REQUEST_METHOD'] == 'POST'){
            // error_reporting(E_ERROR | E_PARSE);
            $name = validate($_POST['name']);
            $email = validate($_POST['email']);
            $message = validate($_POST['message']);
        
            if (empty($name)) {
                header("Location: contact.php?error=Name is required");
                exit();
            }else if(empty($email)){
                header("Location: contact.php?error=Email is required");
                exit();
            }else if(empty($message)){
                header("Location: contact.php?error=Message is required");
                exit();
            }else{
            $sql = "INSERT INTO `contact` (`id`,`name`, `email`, `message`) VALUES (NULL, '$name', '$email', '$message');";
            
            $result = mysqli_query($conn,$sql); 

            header("Location: login_page.php");
	exit();
            }
         }
}else{
	header("Location: login_page.php");
	exit();
}