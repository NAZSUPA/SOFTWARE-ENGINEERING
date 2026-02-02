<?php
require_once('connection.php');
session_start();

$date = $hour = "";
$date_error = $hour_erro = "";


// This condition ensures the error message is only shown after form submission
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Check if 'date' is provided
    if (empty($_POST['date'])) {
        $date_error = "Please Choose A Date.";  // Error if no date is selected
    } else {
        $date = $_POST['date'];
    }

    // Check if the date is valid (today or in the future)
    if (!empty($date)) {
        $sql = "SELECT '$date' >= CURDATE() AS result;";
        $result = $connection->query($sql);
        $row = $result->fetch_assoc();
        

        // If the date is valid (today or in the future)
        if ($row['result'] == 1) {
            $hour = $_POST['hour'];

            // Check if the chosen time slot is already booked
            $sql = "SELECT APPOINTMENT_ID FROM APPOINTMENT WHERE DATE = '$date' AND HOUR = '$hour';";
            $result = $connection->query($sql);

            if ($result && $result->num_rows > 0) {
                $date_error .= "This Date And Time Is Taken";
            } else {
                // Get the donor ID
                $username = $_SESSION['username'];
                $sql = "SELECT DONOR_ID FROM DONORS WHERE USER_NAME = '$username'";
                $result = $connection->query($sql);
                $row = $result->fetch_assoc();
                $id = (int) $row['DONOR_ID'];


                // Get Chosen Date
                $date = $_POST['date'];

                // Get the last blood donation date
                $sql = "SELECT LAST_BLOOD_DONATION_DATE FROM DONORS WHERE DONOR_ID = $id;";
                $result = $connection->query($sql);
                $row = $result->fetch_assoc();
                $last_blood_donation_date = $row['LAST_BLOOD_DONATION_DATE'];

                // Check if the donor's last donation date is available and calculate days passed
                if ($last_blood_donation_date != NULL) {
                    $sql = "SELECT TIMESTAMPDIFF(DAY, '$last_blood_donation_date', '$date') AS passed_days;";
                    $result = $connection->query($sql);
                    $row = $result->fetch_assoc();
                    $passed_days = $row['passed_days'];

                    // Check if 58 days have passed since the last donation
                    if ($passed_days < 58) {
                        $date_error .= "You Can Donate Blood Each 58 Days Cycle";
                    } else {

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



    // Convert the appointment time to DateTime objects
    $appointment_hour = DateTime::createFromFormat('g:i A', $hour);
    $current_hour = DateTime::createFromFormat('g:i A', $now);
                        
    if ($current_hour > $appointment_hour && ($today==$appointment) ){
        $hour_erro .= "Please Choose Valid Hour";
    }
    else{
                        // Insert the appointment
                        $sql = "INSERT INTO APPOINTMENT (DATE, HOUR, DONOR_ID) VALUES ('$date', '$hour', $id);";

                        if ($connection->query($sql) === TRUE) {
                            $_SESSION['date'] = $date;
                            $_SESSION['hour'] = $hour;
                            header('Location: dashboard.php');
                        } else {
                            $date_error .= "Sorry, there was an error.";
                        }
                    }
                }
                } else {

                    // Insert the appointment if there's no last donation date
                    $sql = "INSERT INTO APPOINTMENT (DATE, HOUR, DONOR_ID) VALUES ('$date', '$hour', $id);";

                    if ($connection->query($sql) === TRUE) {
                        $_SESSION['date'] = $date;
                        $_SESSION['hour'] = $hour;
                        header('Location: dashboard.php');
                    } else {
                        $date_error .= "Sorry, there was an error.";
                    }
                }
            }
        } else {
            // If date is not valid
            $date_error .= "Please Choose a Correct Date.";
        }
    }
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KOYA Blood Donation Bank | Appointment</title>
    <style>
        /* Your CSS styles here */
        form {
            position: absolute;
            margin-left: 36%;
            margin-top: 5%;
            width: 30%;
            height: 15%;
        }

        .input {
            width: 100%;
            height: 30%;
            font-size: 20px;
        }

        h1 {
            position: relative;
            margin-left: 15%;
        }

        .button {
            position: absolute;
            margin-left: 36%;
            margin-top: 25%;
            cursor: pointer;
            width: 30%;
            height: 5%;
            font-size: 25px;
            text-decoration: none;
            text-align: center;
            border: 3px solid rgba(194, 188, 188, 1);
            color: black;
            background-color: whitesmoke;

        }

        .button:hover {
            background-color: rgba(231, 234, 228, 1);
        }

        .error {
            color: red;
            font-size: 25px;
        }

        @media (max-width : 480px) {
            .button {
                margin-top: 63%;
            }

            .input {
                height: 35%;
            }

            h1 {
                margin-left: 2%;
                font-size: 30px;
            }

        }

        @media (min-width: 481px) and (max-width: 523px) {
            .button {
                margin-top: 63%;
            }

            .input {
                height: 35%;
            }

            h1 {
                margin-left: 2%;
                font-size: 30px;
            }

        }

        @media (min-width: 517px) and (max-width: 635px) {

            .button {
                margin-top: 300px;
            }

            .input {
                height: 35%;
            }

            h1 {
                margin-left: 2%;
                font-size: 30px;
            }
        }

        @media (min-width: 636px) and (max-width: 780px) {
            .button {
                margin-top: 300px;
            }

            .input {
                height: 35%;
            }

            h1 {
                margin-left: 2%;
                font-size: 30px;
            }
        }

        @media (min-width: 781px) and (max-width: 954px) {
            .button {
                margin-top: 320px;
            }

            .input {
                height: 35%;
            }

            h1 {
                margin-left: 2%;
                font-size: 30px;
            }
        }

        @media (min-width: 955px) and (max-width: 1200px) {
            .button {
                margin-top: 320px;
            }

            .input {
                height: 35%;
            }

            h1 {
                margin-left: 2%;
                font-size: 30px;
            }
        }
       @media (max-width: 1200px) {
    .button {
        margin-top: 484px;
    }
}
    </style>
</head>

<body>

    <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="POST">
        <h1>Request Appointment</h1>
        <!-- Display the error message only if it exists -->
         <span class="error"><?php echo$hour_erro;?></span>
        <span class="error"><?php echo $date_error; ?></span>
        <br>
        <br>
        Date : <input type="date" name="date" class="input"> &nbsp; &nbsp;
        <br>
        Hour : <select name="hour" class="input">
            <option value="8:00 AM">8:00 AM</option>
            <option value="8:30 AM">8:30 AM</option>
            <option value="9:00 AM">9:00 AM</option>
            <option value="9:30 AM">9:30 AM</option>
            <option value="10:00 AM">10:00 AM</option>
            <option value="10:30 AM">10:30 AM</option>
            <option value="11:00 AM">11:00 AM</option>
            <option value="11:30 AM">11:30 AM</option>
            <option value="12:00 PM">12:00 PM</option>
            <option value="12:30 PM">12:30 PM</option>
            <option value="1:00 PM">1:00 PM</option>
            <option value="1:30 PM">1:30 PM</option>
            <option value="2:00 PM">2:00 PM</option>
            <option value="2:30 PM">2:30 PM</option>
            <option value="3:00 PM">3:00 PM</option>
            <option value="3:30 PM">3:30 PM</option>
            <option value="4:00 PM">4:00 PM</option>
        </select>
        <br>
        <br>
        <input type="submit" value="Request" class="input">
        <br>
        <br>
    </form>
    <a href="dashboard.php" class="button">Back</a>
</body>

</html>