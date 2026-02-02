<?php 
session_start();
require_once('connection.php');
$id = $_SESSION['id'];

$sql = "DELETE FROM APPOINTMENT WHERE DONOR_ID = $id;";
$connection->query($sql);
header('Location: admin_appointments.php');
?>
