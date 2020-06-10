<?php

//calling login function
if(isset($_POST['login_btn'])) {
	 question();
}
error_reporting(E_ERROR | E_PARSE);
// function login(){
	  
// define('DB_SERVER','localhost');
// define('DB_USERNAME','root');
// define('DB_PASSWORD','');
// define('DB_NAME','javalogin');

// //try connecting to database
// $conn = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_NAME);

// //check connection
// if($conn == false){
//     dir('Error : Connot Connect');
// }


// if(isset($_SESSION['email_id'])){
// 	header("location: Admin_pannel.php");
// 	exit;
// }
// require_once "login_page.php";

// $email_id = $password = "";
// $error = "";

// //if request method is post

// if($_SERVER['REQUEST_METHOD'] == "POST"){
// 	if(empty(trim($_POST['email_id'])) || empty(trim($_POST['[password']))){
// 		$error = "Plaser enter name + password";
// 	}
// 	else{
// 		$email_id = trim($_POST['email_id']);
// 		$password = trim($_POST['password']);
// 	}

// 	if(empty($error)){
// 		$sql ="SELECT * from login where email_id = '$email_id' and password = '$password'";

// 		$row = mysql_fetch_array($sql);
// 		if($row['email_id'] == $email_id && $row['password'] ==$password){
// 			header("location: Admin_pannel.php");
// 		}
// 		else{
// 			echo "Login faild";
// 		}          
// 	}


	
// }
// }

//function for login
// function login(){

// }



function question(){
	error_reporting(0);
    $insert  = false;
    $servername = "localhost";
    $username = "root";
    $passsword = "";   
    $database = "javalogin";
    $conn = mysqli_connect($servername,$username,$passsword,$database);   
    //check connection
    
        if($conn == false){
            dir('Error : Connot Connect');
        }
        
        if($_SERVER['REQUEST_METHOD'] == 'POST'){
        
            $Question = $_POST['Question'];
            $Option1 = $_POST['option1'];
            $Option2 = $_POST['option2'];
            $Option3 = $_POST['option3'];
            $Option4 = $_POST['option4'];
            $Answer =  $_POST['Answer'];
        
            $sql = "INSERT INTO `questioncurd` (`Id`, `Question`, `option1`, `option2`, `option3`, `option4`, `Answer`) VALUES (NULL, '$Question', '$Option1', '$Option2', '$Option3', '$Option4', '$Answer')";
            
            $result = mysqli_query($conn,$sql); 
    
        }

        if($_SERVER['REQUEST_METHOD'] == 'POST'){
        
            $Feild = $_POST['Field'];
            $Pincode = $_POST['Pincode'];
            $Quiz = $_POST['QuizTime'];
            $Attemps = $_POST['QuizNoofAttemp'];

        
            $sql = "INSERT INTO `subjectlist` (`id`, `Field`, `Pincode`, `QuizTime`, `QuizNoofAttemp`) VALUES (NULL, '$Feild', '$Pincode', '$Quiz', ' $Attemps');";
            
            $result = mysqli_query($conn,$sql); 
    
        }

}

?>