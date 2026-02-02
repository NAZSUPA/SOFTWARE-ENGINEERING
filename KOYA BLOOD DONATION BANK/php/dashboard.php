<?php
require_once("header.php");
require_once("connection.php");

$have_appointment = false;
$full_name = $id = $age = $gender = $blood_group = $last_blood_donation_date = $number_of_donations = "";



// Get the donor ID
$username = $_SESSION['username'];
$sql = "SELECT DONOR_ID FROM DONORS WHERE USER_NAME = '$username'";
$result = $connection->query($sql);
$row = $result->fetch_assoc();
$id = (int) $row['DONOR_ID'];


// Finding Today Date
$sql = "SELECT CURDATE() AS today;";
$result = $connection->query($sql);
$row = $result->fetch_assoc();
$today = $row['today'];

// Finding Appointement Date
$sql = "SELECT DATE FROM APPOINTMENT WHERE DONOR_ID = $id;";
$result = $connection->query($sql);
$row = $result->fetch_assoc();
if($row)
$appointment = $row['DATE'];


// Get the current time in 12-hour format with AM/PM
$sql = "SELECT DATE_FORMAT(NOW(), '%l:%i %p') AS current";
$result = $connection->query($sql);
$row = $result->fetch_assoc();
$now = $row['current'];

// Fetch appointment details for the donor
$sql = "SELECT DATE, HOUR FROM APPOINTMENT WHERE DONOR_ID = $id AND DATE >= CURDATE()";
$result = $connection->query($sql);
$row = $result->fetch_assoc();

// Default values if no appointment exists
$next_date_of_donation = "No Appointment Yet.";
$available_hour_to_come = "No Appointment Yet.";

if ($row != NULL) {
    // Appointment exists, fetch details
    $date = $row['DATE'];
    $hour = $row['HOUR'];

    // Convert the appointment time to DateTime objects
    $appointment_hour = DateTime::createFromFormat('g:i A', $hour);
    $current_hour = DateTime::createFromFormat('g:i A', $now);

    // Compare current time with appointment hour
    if ($current_hour > $appointment_hour && ($today==$appointment)) {
        $have_appointment = true;
        $next_date_of_donation = "No Appointment Yet.";  
        $available_hour_to_come = "No Appointment Yet.";
    } else {
        $next_date_of_donation = $date;
        $available_hour_to_come = $hour;
    }
} else {
    // If no appointment exists, set flags
    $have_appointment = true;
}

// Fetch donor's personal details
$sql = "SELECT CONCAT_WS(' ', FIRST_NAME, LAST_NAME) AS FULL_NAME, 
               TIMESTAMPDIFF(YEAR, BIRTHDAY, CURDATE()) AS AGE, 
               GENDER, 
               BLOOD_GROUP, 
               LAST_BLOOD_DONATION_DATE, 
               NUMBER_OF_DONATION
        FROM DONORS 
        WHERE USER_NAME = '$username'";

$result = $connection->query($sql);
if ($result && $result->num_rows > 0) {
    $row = $result->fetch_assoc();
    $full_name = $row['FULL_NAME'];
    $age = $row['AGE'];
    $gender = $row['GENDER'];
    $blood_group = $row['BLOOD_GROUP'];
    $number_of_donations = $row['NUMBER_OF_DONATION'];
    $last_blood_donation_date = $row['LAST_BLOOD_DONATION_DATE'];

    if ($last_blood_donation_date == NULL) {
        $last_blood_donation_date = "No Donations Yet";
    }
} 
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="..//css/dashboard.css">
    <link rel="icon" href="../images/blood-bag.png">
    <title>KOYA Blood Donation Bank | Dashboard</title>
</head>
<body>

<section>
    <div id="dashboard">
        <h1>Main Dashboard</h1>
        <div id="board">
            <table>
                <tr>
                    <td class="lables">DONOR ID :</td>
                    <td id="donor_id" class="col2"><?php echo $id; ?></td>
                    <td class="col3" class="lables">NUMBER OF DONATIONS :</td>
                    <td class="col4" id="number_of_donations"><?php echo $number_of_donations; ?></td>
                </tr>
                <tr>
                    <td class="lables">FULL NAME :</td>
                    <td id="full_name" class="col2"><?php echo $full_name; ?></td>
                    <td class="col3" class="lables">NEXT DATE OF DONATION :</td>
                    <td class="col4" id="next_date_of_donation"><?php echo $next_date_of_donation?></td>
                </tr>
                <tr>
                    <td class="lables">AGE :</td>
                    <td id="age" class="col2"><?php echo $age;?></td>
                    <td class="col3" class="lables">AVAILABLE HOUR TO COME :</td>
                    <td class="col4" id="available_hour_to_come"><?php echo $available_hour_to_come;?></td>
                </tr>
                <tr><td class="lables">GENDER :</td>
                <td id="gender" class="col2"><?php echo $gender;?></td>
            <td class="col3" class="lables">LAST DONATION DATE :</td>
            <td class="col4" id="floor_number"><?php echo$last_blood_donation_date;?></td></tr>
                <tr><td class="lables">BLOOD GROUP :</td>
                <td id="blood_group" class="col2"><?php echo $blood_group;?></td>
            <td class="col3" class="lables" style="font-size: 20px; position: absolute; margin-top: 1%;">FLOOR NUMBER - LABORATORY NUMBER : </td>
        <td class="col4" id="laboratory_number">1 - A1</td></tr>
            </table>
        </div>
        
    </div>
</section>

<?php
if($have_appointment){
echo "<a href='appointment.php'><button class='ra'>Reques Appointment</button></a>";
}
?>

<footer>
    <p>Copy Write Reserved For Blood Donation Bank In Koya Hospital &copy;</p>
</footer>
    
</body>
</html>