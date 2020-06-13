<!DOCTYPE html>
<html>
<head>
	<title>LOGIN</title>
	<link rel="stylesheet" type="text/css" href="style.css">
	
	<link href="https://fonts.googleapis.com/css2?family=Odibee+Sans&display=swap" rel="stylesheet">
</head>
<body>
<div ><p Id="FAJ_LOGO">FAJ EXAMINATION SYSTEM</p></div>
     <form action="contact_backend.php" method="POST">
     	<h2>CONTACT US</h2>
     	<?php if (isset($_GET['error'])) { ?>
     		<p class="error"><?php echo $_GET['error']; ?></p>
     	<?php } ?>
     	<label>Name</label>
     	<input type="text" name="name" placeholder="Name">

     	<label>Email</label>
        <input type="email" name="email" placeholder="email">
         
        <label>Measage</label>
        <textarea  id="exampleFormControlTextarea1" name="message" rows="3"></textarea>

     	<button type="submit" id="contact" style="margin-left:-40px">Contact us</button>
	 </form>
</body>
</html>