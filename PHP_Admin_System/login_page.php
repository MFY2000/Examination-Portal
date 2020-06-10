<!-- 3 -->


<?php 
error_reporting(E_ERROR | E_PARSE);
if(isset($_POST['login_btn'])) {
	
	login();
	//question();
   }
   
   function login(){
		 
   define('DB_SERVER','localhost');
   define('DB_USERNAME','root');
   define('DB_PASSWORD','');
   define('DB_NAME','javalogin');
   
   //try connecting to database
   $conn = mysqli_connect(DB_SERVER,DB_USERNAME,DB_PASSWORD,DB_NAME);
   
   //check connection
   if($conn == false){
	   dir('Error : Connot Connect');
   }
   
   
   if(isset($_SESSION['email_id'])){
	   header("location: Admin_pannel.php");
	   exit;
   }
   require_once "login_page.php";
   
   $email_id = $password = "";
   $error = "";
   
   //if request method is post
   
   if($_SERVER['REQUEST_METHOD'] == "POST"){
	   if(empty(trim($_POST['email_id'])) || empty(trim($_POST['[password']))){
		   $error = "Plaser enter name + password";
	   }
	   else{
		   $email_id = trim($_POST['email_id']);
		   $password = trim($_POST['password']);
	   }
   
	   if(empty($error)){
		   $sql ="SELECT * from login where email_id = '$email_id' and password = '$password'";
   
		   $row = mysql_fetch_array($sql);
		   if($row['email_id'] == $email_id && $row['password'] ==$password){
			   header("location: Admin_pannel.php");
		   }
		   else{
			   echo "Login faild";
		   }          
	   }
   
   
	   
   }
   }

  
?>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="//cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<title>Crud App</title>
</head>
<body>
<?php include 'function.php';?>
<div class="header">
		<h2>Login</h2>
	</div>
	<form method="post" action="Admin_pannel.php">
		<div class="input-group">
			<label>Username</label>
			<input type="text" name="email_id" >
		</div>
		<div class="input-group">
			<label>Password</label>
			<input type="password" name="password">
		</div>
		<div class="input-group">
			<button type="submit" class="btn" name="login_btn">Login</button>
		</div>
	</form>

</body>
<script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
<script src="//cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<!-- <script>
    $(document).ready( function () {
    $('#myTable').DataTable();
} );
</script> -->

</html>