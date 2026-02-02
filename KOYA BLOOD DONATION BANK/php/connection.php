<?php
$server_name = "localhost";
$user_name = "root";
$password = "";
$database_name = "KOYA_BLOOD_DONATION_BANK";
$port = 3307;

// Create initial connection to the server
$connection = new mysqli($server_name, $user_name, $password, $database_name, $port);

if ($connection->connect_error) {
    die("Connection failed: " . $connection->connect_error);
}
?>