<?php
$ID = "";
require_once("header.php");
if(isset($_SESSION['user_id'])){
    $ID = $_SESSION['user_id'];
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KOYA Blood Donation Bank | Waitboard</title>
    <style>
        #text{
            
    position: absolute;
    padding: 10px;
    margin-left: 10%;
    width: 80%;
    height: 40%;
    font-size: 55px;
    background-color: #a2caf0;
    margin-top: 3%;
    border: 2px solid black;
    border-radius: 30px;
}
footer {
    margin-top: 26%;
    border: 2px solid rgb(197, 50, 50);
    border-radius: 38px;
}

footer p {
    text-align: center;
    font-size: 25px;
    color: rgb(197, 50, 50);
    font-weight: bold;
}
    </style>
</head>
<body>
  <h3 id="text">PLEASE VISIT KOYA BANK DONATION FOR MEDICAL TEST AND ACCOUNT ACTIVATION TO SEE YOUR DASHBOARD AND CAN REQUEST APPOINTMENT.
     &nbsp; YOUR ID : <?php echo $ID; ?></h3>  
    <footer>
        <p>Copy Write Reserved For Blood Donation Bank In Koya Hospital &copy;</p>
    </footer>
</body>
</html>