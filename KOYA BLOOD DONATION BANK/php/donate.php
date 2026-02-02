<?php
session_start();
require_once('connection.php');
$id = $_SESSION['id'];
$sql = "UPDATE DONORS SET NUMBER_OF_DONATION =  NUMBER_OF_DONATION + 1, LAST_BLOOD_DONATION_DATE = CURDATE() WHERE DONOR_ID = $id;";
$connection->query($sql);
$sql = "DELETE FROM APPOINTMENT WHERE DONOR_ID = $id;";
if($connection->query($sql)===TRUE){
    header('Location: admin_appointments.php');
}
else{
    echo $connection->error;
}
?>