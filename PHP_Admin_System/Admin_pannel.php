<!-- 1 -->
<?php 
 
   error_reporting(E_ERROR | E_PARSE);
   session_start();

   if (isset($_SESSION['id']) && isset($_SESSION['username'])) {
   
    
    $insert  = false;
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



        
        if($_SERVER['REQUEST_METHOD'] == 'POST'){
          error_reporting(E_ERROR | E_PARSE);
            $show = $_POST['Answer2'];
            $Question = $_POST['Question'];
            $Option1 = $_POST['option1'];
            $Option2 = $_POST['option2'];
            $Option3 = $_POST['option3'];
            $Option4 = $_POST['option4'];
            $Answer =  $_POST['Answer'];
        
            $sql = "INSERT INTO  `".$show."` (`Id`, `Question`, `option1`, `option2`, `option3`, `option4`, `Answer`) VALUES (NULL, '$Question', '$Option1', '$Option2', '$Option3', '$Option4', '$Answer');";
            
            $result = mysqli_query($conn,$sql); 
    
        }
   

     

          if($_SERVER['REQUEST_METHOD'] == 'POST'){
            error_reporting(E_ERROR | E_PARSE);
            $Feild = $_POST['Field'];
            $Pincode = $_POST['Pincode'];
            $Quiz = $_POST['QuizTime'];
            $Attemps = $_POST['QuizNoofAttemp'];

        
            $sql = "INSERT INTO `subjectlist` (`id`, `Field`, `Pincode`, `QuizTime`, `QuizNoofAttemp`) VALUES (NULL, '$Feild', '$Pincode', '$Quiz', ' $Attemps');";
            
            $result = mysqli_query($conn,$sql); 
            // createTable();
        }
        
          error_reporting(E_ERROR | E_PARSE);
          $sql ="CREATE TABLE `javalogin`.`".$Feild."` ( `id` INT(11) NOT NULL AUTO_INCREMENT ,  `Question` VARCHAR(1000) NOT NULL ,  `option1` VARCHAR(1000) NOT NULL ,  `option2` VARCHAR(1000) NOT NULL ,  `option3` VARCHAR(1000) NOT NULL ,  `option4` VARCHAR(1000) NOT NULL ,  `Answer` VARCHAR(1000) NOT NULL ,    PRIMARY KEY  (`id`(1))) ENGINE = InnoDB"; 
          $result = mysqli_query($conn,$sql); 

        
          session_start();
          
         
          
          ?>          
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- <link rel="stylesheet" href="../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic">
    <link rel="stylesheet" href="../assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="../assets/fonts/simple-line-icons.min.css">
    <link rel="stylesheet" href="../cdn\animate.min.css">
    <link rel="stylesheet" href="../cdn\font-awesome.min.css">
    <link rel="stylesheet" href="../cdn\bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" > -->

     <!-- BOOTSTRAP STYLES-->
     <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
     <link href="assets2/css.css" rel="stylesheet" />
     <link href="assets2/css/bootstrap.css" rel="stylesheet" />
     
     <link href="assets2/custom.css" rel="stylesheet" />
     <link href="assets2/css/font-awesome.css" rel="stylesheet" />
     
     <link rel="stylesheet" href="//cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
 <style>

 </style>
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">ADMIN</a>
            </div>
            <div style="color: white;padding: 15px 50px 5px 50px;float: right;font-size: 16px;"> <?php  if($_SESSION['username'] === "admin"){echo "JAFFAR ABBAS"; }else if($_SESSION['username'] === "admin2"){echo "MUHAMMAD FAHAD";}else if($_SESSION['username'] === "admin3"){echo "AHMED AMIN" ;} ?> &nbsp; <a href="logout.php" class="btn btn-primary square-btn-adjust">Logout</a> </div>
        </nav>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li class="text-center">
                    <?php 
                         
                         if($_SESSION['username'] === "admin"){
                          echo"<img src='assets2/img/admin.jpg' class='user-image img-responsive' style=' border-radius: 50%;'/>";
                         }
                         else if($_SESSION['username'] === "admin2"){
                          echo"<img src='assets2/img/admin2.jpeg' class='user-image img-responsive' style=' border-radius: 50%;'/>";
                         }
                         else if($_SESSION['username'] === "admin3"){
                          echo"<img src='assets2/img/admin3.jpeg' class='user-image img-responsive'  style=' border-radius: 50%; width:200px ;'/>";
                         }
                        
                         
                         ?>
                        
                    </li>
                    <li>
                        <a class="active-menu" onclick="mypop3()"><i class="fa fa-dashboard fa-3x"></i> Dashboard</a>
                    </li>
                    <li>
                        <a onclick="mypop4()"><i class="fa fa-book fa-3x"></i>Insert Major<span class="fa arrow"></span></a>
                    </li>
                    <li>
                        <a  onclick="mypop()"><i class="fa fa-users fa-3x"></i>Exam Insertion<span class="fa arrow"></span></a>
                    </li>
                    <li>
                        <a  onclick="mypop5()"><i class="fa fa-user fa-3x"></i>Major View<span class="fa arrow"></span></a>
                    </li>
                    <li>
                        <a  onclick="mypop2()"><i class="fa fa-user fa-3x"></i>Result<span class="fa arrow"></span></a>
                    </li>
                </ul>
            </div>
        </nav>
        
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class="text-primary">FAJ EXAMINATION SYSTEM</h2>
                        <h5> Welcome ,<?php  if($_SESSION['username'] === "admin"){
                          echo "JAFFAR ABBAS"; 
                         }
                         else if($_SESSION['username'] === "admin2"){
                          echo "MUHAMMAD FAHAD";
                         }
                         else if($_SESSION['username'] === "admin3"){
                          echo "AHMED AMIN" ;
                         } ?> Love to see you back. </h5>
                       <!-- table show -->
                       <section class="page_for_dashboared" id="dashboared">
                       <section class="text-gray-700 body-font relative">
  <div class="container px-5 py-24 mx-auto">
    <div class="flex flex-col text-center w-full mb-12">
      <h1 class="sm:text-3xl text-2xl font-medium title-font mb-4 text-gray-900">Contact Us</h1>
      <p class="lg:w-2/3 mx-auto leading-relaxed text-base">Whatever cardigan tote bag tumblr hexagon brooklyn asymmetrical gentrify.</p>
    </div>
    <div class="lg:w-1/2 md:w-2/3 mx-auto">
      <div class="flex flex-wrap -m-2">
        <div class="p-2 w-1/2">
          <input class="w-full bg-gray-100 rounded border border-gray-400 focus:outline-none focus:border-indigo-500 text-base px-4 py-2" placeholder="Name" type="text">
        </div>
        <div class="p-2 w-1/2">
          <input class="w-full bg-gray-100 rounded border border-gray-400 focus:outline-none focus:border-indigo-500 text-base px-4 py-2" placeholder="Email" type="email">
        </div>
        <div class="p-2 w-full">
          <textarea class="w-full bg-gray-100 rounded border border-gray-400 focus:outline-none h-48 focus:border-indigo-500 text-base px-4 py-2 resize-none block" placeholder="Message"></textarea>
        </div>
        <div class="p-2 w-full">
          <button class="flex mx-auto text-white bg-indigo-500 border-0 py-2 px-8 focus:outline-none hover:bg-indigo-600 rounded text-lg">Button</button>
        </div>
        <div class="p-2 w-full pt-8 mt-8 border-t border-gray-200 text-center">
          <a class="text-indigo-500">example@email.com</a>
          <p class="leading-normal my-5">49 Smith St.
            <br>Saint Cloud, MN 56301
          </p>
          <span class="inline-flex">
            <a class="text-gray-500">
              <svg fill="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-5 h-5" viewBox="0 0 24 24">
                <path d="M18 2h-3a5 5 0 00-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 011-1h3z"></path>
              </svg>
            </a>
            <a class="ml-4 text-gray-500">
              <svg fill="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-5 h-5" viewBox="0 0 24 24">
                <path d="M23 3a10.9 10.9 0 01-3.14 1.53 4.48 4.48 0 00-7.86 3v1A10.66 10.66 0 013 4s-4 9 5 13a11.64 11.64 0 01-7 2c9 5 20 0 20-11.5a4.5 4.5 0 00-.08-.83A7.72 7.72 0 0023 3z"></path>
              </svg>
            </a>
            <a class="ml-4 text-gray-500">
              <svg fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-5 h-5" viewBox="0 0 24 24">
                <rect width="20" height="20" x="2" y="2" rx="5" ry="5"></rect>
                <path d="M16 11.37A4 4 0 1112.63 8 4 4 0 0116 11.37zm1.5-4.87h.01"></path>
              </svg>
            </a>
            <a class="ml-4 text-gray-500">
              <svg fill="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="w-5 h-5" viewBox="0 0 24 24">
                <path d="M21 11.5a8.38 8.38 0 01-.9 3.8 8.5 8.5 0 01-7.6 4.7 8.38 8.38 0 01-3.8-.9L3 21l1.9-5.7a8.38 8.38 0 01-.9-3.8 8.5 8.5 0 014.7-7.6 8.38 8.38 0 013.8-.9h.5a8.48 8.48 0 018 8v.5z"></path>
              </svg>
            </a>
          </span>
        </div>
      </div>
    </div>
  </div>
</section>
                       </section>
                        <?php
                        if($result){
                            $insert  = true;
                            if(isset($_POST['exam'])) {
                                echo  '<div><h4 style="color : green">Question Inserted !!</h4></div>';
                            }
                        }
                        // else{
                        //    error_reporting(E_ERROR | E_PARSE);
                        //    echo "Error". mysqli_error($conn);
                        // }
                        ?>
                        </section>
                        <div class="Insert_main" id="staff_inser" style="display=none" name="exam_insertion">
                            <section class="sec_insert">
                                <form class="form_insert" action="Admin_pannel.php" method="POST" style="display=none">           
                                <label for="">Select</label>
                                      <select  class="form-control" id="" name="Answer2" >
                                      <?php   
  
                                       $sql = "SELECT * FROM `subjectlist` WHERE 1";
                                       $result = mysqli_query($conn,$sql) ;
                                       $id = 0;
                                       while($row = mysqli_fetch_assoc($result)){
                                           $id = $id +1;
                                         echo ' <option id="Selecter_3" name="hel">'.$row['Field'].'</option>';
                                       }  ?>
                                     
                                      
                                      </select>        
                                      <label for="">Question</label>
                                      <textarea class="form-control" id="Question_insert" name="Question" rows="3"></textarea>
                                     
                                      
                                      <label for="">Option 1</label>
                                      <input class="form-control" id="option_1" name="option1" >
                                     
                                      
                                      <label for="">Option 2</label>
                                      <input class="form-control" id="option_2" name="option2" >
                                     
                                      
                                      <label for="">Option 3</label>
                                      <input class="form-control" id="option_3" name="option3" >
                                     
                                      
                                      <label for="">Option 4</label>
                                      <input class="form-control" id="option_4" name="option4" >
                                     
                                      <div class="form-group" onclick="gr()">
                                      <label for="">Answers</label>
                                      <select class="form-control" id="" name="Answer" >
                                      <option id="Selecter_1"></option>
                                      <option id="Selecter_2"></option>
                                      <option id="Selecter_3"></option>
                                      <option id="Selecter_4"></option>
                                      </select>
                                                                          
                                    <input type="submit" class="btn btn-primary form-control"  id="btn_reg" name="exam"/>
                                 </form>
                            </section>
                        </div>
                       <section id="Student_insert">
                       <table class="table" id="myTable">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Question</th>
      <th scope="col">Option1</th>
      <th scope="col">Option2</th>
      <th scope="col">Option3</th>
      <th scope="col">Option4</th>
      <th scope="col">Answers</th>
    </tr>
  </thead>
  <tbody>

  <?php   
    $show2 = $_POST['Answer2'];
    $sql = "SELECT * FROM `".$show2."` WHERE 1";
    $result = mysqli_query($conn,$sql) ;
    $id = 0;
    while($row = mysqli_fetch_assoc($result)){
        $id = $id +1;
        echo "<tr>
        <th scope='row'>".$id."</th>
        <td>".$row['Question']."</td>
        <td>".$row['option1']."</td>
        <td>".$row['option2']."</td>
        <td>".$row['option3']."</td>
        <td>".$row['option4']."</td>
        <td>".$row['Answer']."</td>
      </tr>";
    }  ?>
  </tbody>
</table>
</section>   

<section id="insert_major">
	<form class="form_insert" action="Admin_pannel.php" method="POST" >
		<label for="">Feild Name</label>
		<textarea class="form-control" id="Question_insert"  rows="2" name="Field"></textarea>
		<label for="">Pincode</label>
		<input class="form-control" id="Pincode"  name="Pincode">
		<label for="">Quiz Time</label>
		<input class="form-control" id="QuizTime"  name="QuizTime">
		<label for="">Number of Attemps</label>
		<input class="form-control" id="option_4"  name="QuizNoofAttemp">
        <br>
		<input type="submit" class="btn btn-primary form-control"  id="btn_reg" name="feild_i"/>
		</form>
</section>


<section id="show_major">
<table class="table" id="myTable2">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Feild Name</th>
      <th scope="col">Pincode</th>
      <th scope="col">Quiz Time</th>
      <th scope="col">Number of Attemps</th>
    
    </tr>
  </thead>
  <tbody>

  <?php   
  
    $sql = "SELECT * FROM `subjectlist` WHERE 1";
    $result = mysqli_query($conn,$sql) ;
    $id = 0;
    while($row = mysqli_fetch_assoc($result)){
        $id = $id +1;
        echo "<tr>
        <th scope='row'>".$id."</th>
        <td>".$row['Field']."</td>
        <td>".$row['Pincode']."</td>
        <td>".$row['QuizTime']."</td>
        <td>".$row['QuizNoofAttemp']."</td>
       
      </tr>";
    }  ?>
  </tbody>
</table>

</section>

                <!-- /. ROW  -->

<!-- Insert major -->


</body>

<script src="assets2/js/bootstrap.min.js"></script>
<script src="assets2/js/custom.js"></script>
<script src="assets2/js/jquery-1.10.2.js"></script>
<script src="assets2/js/jquery.metisMenu.js"></script>


<script>
    function mypop()
{
    var k = document.getElementById("show_major"); 
  var x = document.getElementById("staff_inser");
  var y = document.getElementById("Student_insert");
  var m = document.getElementById("insert_major");
    var a = document.getElementById("dashboared");
  if (x.style.display === "none") {
    x.style.display = "block";
    y.style.display = "none"
    m.style.display = "none";
    a.style.display = "none";
     k.style.display ="none";
  } else {
    x.style.display ="none";
  } 
}
function mypop2()
{
    var k = document.getElementById("show_major"); 
  var x = document.getElementById("Student_insert");
  var y = document.getElementById("staff_inser");
  var m = document.getElementById("insert_major");
    var a = document.getElementById("dashboared");
  if (x.style.display === "none") {
    x.style.display = "block";
    y.style.display ="none";
    m.style.display = "none";
    a.style.display = "none";
     k.style.display ="none";
  } else {
    x.style.display ="none";
  } 
}

function mypop3(){
    var k = document.getElementById("show_major"); 
    var a = document.getElementById("dashboared");
    var x = document.getElementById("Student_insert");
    var y = document.getElementById("staff_inser");
    var m = document.getElementById("insert_major");

  if (a.style.display === "none") {
    a.style.display = "block";
    x.style.display = "none";
    y.style.display ="none";
    m.style.display = "none";
     k.style.display ="none";
  } else {
    a.style.display ="none";
  } 
}


function mypop4(){
    var k = document.getElementById("show_major"); 
    var m = document.getElementById("insert_major");
    var a = document.getElementById("dashboared");
    var x = document.getElementById("Student_insert");
    var y = document.getElementById("staff_inser");
  if (m.style.display === "none") {
    m.style.display = "block";
    a.style.display = "none"
     k.style.display ="none";
    x.style.display = "none";
    y.style.display ="none";
  } else {
    m.style.display ="none";
  } 
}


function mypop5(){
   
    var k = document.getElementById("show_major"); 
    var m = document.getElementById("insert_major");
    var a = document.getElementById("dashboared");
    var x = document.getElementById("Student_insert");
    var y = document.getElementById("staff_inser");
  if (k.style.display === "none") {
    
    k.style.display = "block";
    m.style.display = "none";
    a.style.display = "none";
    x.style.display = "none";
  
    y.style.display ="none";
  } else {
    k.style.display ="none";
  } 
}

function gr()
{
    var var_for_selecter_1 =  document.getElementById('option_1').value; 
            
    document.getElementById('Selecter_1').innerHTML = var_for_selecter_1; 

    var var_for_selecter_2 =  document.getElementById('option_2').value; 
            
    document.getElementById('Selecter_2').innerHTML = var_for_selecter_2; 

    var var_for_selecter_3 =  document.getElementById('option_3').value; 
            
    document.getElementById('Selecter_3').innerHTML = var_for_selecter_3; 

    var var_for_selecter_4 =  document.getElementById('option_4').value; 
            
    document.getElementById('Selecter_4').innerHTML = var_for_selecter_4; 
}


</script>

<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="..\assets\bootstrap\js\bootstrap.min.js"></script>
<script src="..\cdn\bootstrap.min.js"></script>
<script src="../js/js.js"></script> -->
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>

<script src="//cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script>
$(document).ready( function () {
    $('#myTable').DataTable();
} );
$(document).ready( function () {
    $('#myTable2').DataTable();
} );
</script>
</html>
<?php 
}else{
     header("Location: login_page.php");
     exit();
}
 ?>