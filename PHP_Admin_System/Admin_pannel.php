<!-- 1 -->
<?php 
 
   error_reporting(E_ERROR | E_PARSE);
 
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
    
     <link href="assets2/css/css.css" rel="stylesheet" />
     <link href="assets2/css/bootstrap.css" rel="stylesheet" />
     <link href="assets2/css/custom.css" rel="stylesheet" />
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
            <div style="color: white;padding: 15px 50px 5px 50px;float: right;font-size: 16px;"> Last access : 30 May 2014 &nbsp; <a href="#" class="btn btn-danger square-btn-adjust">Logout</a> </div>
        </nav>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li class="text-center">
                        <img src="assets2/img/find_user.png" class="user-image img-responsive" />
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
                        <h2>Admin Dashboard</h2>
                        <h5> Welcome , Love to see you back. </h5>
                       <!-- table show -->
                       <section class="page_for_dashboared" id="dashboared">
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
                                                                          
                                    <input type="submit" class="btn btn-warning form-control"  id="btn_reg" name="exam"/>
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
		<input type="submit" class="btn btn-warning form-control"  id="btn_reg" name="feild_i"/>
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
  var x = document.getElementById("staff_inser");
  var y = document.getElementById("Student_insert");
  if (x.style.display === "none") {
    x.style.display = "block";
    y.style.display = "none"
  } else {
    x.style.display ="none";
  } 
}
function mypop2()
{
  var x = document.getElementById("Student_insert");
  var y = document.getElementById("staff_inser");
  if (x.style.display === "none") {
    x.style.display = "block";
    y.style.display ="none";
  } else {
    x.style.display ="none";
  } 
}

function mypop3(){
    var a = document.getElementById("dashboared");
    var x = document.getElementById("Student_insert");
    var y = document.getElementById("staff_inser");
  if (a.style.display === "none") {
    a.style.display = "block";
    x.style.display = "none";
    y.style.display ="none";
  } else {
    a.style.display ="none";
  } 
}


function mypop4(){
    var m = document.getElementById("insert_major");
    var a = document.getElementById("dashboared");
    var x = document.getElementById("Student_insert");
    var y = document.getElementById("staff_inser");
  if (m.style.display === "none") {
    m.style.display = "block";
    a.style.display = "none";
    x.style.display = "none";
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