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
                $to="gamaportal8@gmail.com";
                $subject="Contact to FAJ EXAMINATION SYSTEM";
                $messages="asasdas";
                $headers="From: gamaportal8@gmail.com";
                if(mail($to,$subject,$messages,$headers)){
                    echo "mail Send Successfull";
                }else{
                    echo "not";
                }

            $sql = "INSERT INTO `contact` (`id`,`name`, `email`, `message`) VALUES (NULL, '$name', '$email', '$message');";
            
            $result = mysqli_query($conn,$sql); 
            //mail sender in php
           
            header("Location: login_page.php");
	        exit();
            }
         }
}else{
	header("Location: login_page.php");
	exit();
}