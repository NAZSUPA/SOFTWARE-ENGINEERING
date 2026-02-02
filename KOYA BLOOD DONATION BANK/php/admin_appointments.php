<?php
$done = true;
session_start();
require_once('connection.php');
$sql = "SELECT DONORS.DONOR_ID AS 'DONOR ID', 
CONCAT(DONORS.FIRST_NAME,' ',DONORS.LAST_NAME) AS 'FULL NAME', 
DONORS.GENDER AS 'GENDER',
DONORS.BLOOD_GROUP AS 'BLOOD GROUP',
 APPOINTMENT.DATE , 
 APPOINTMENT.HOUR AS 'TIME'
FROM APPOINTMENT JOIN DONORS
ON (APPOINTMENT.DONOR_ID = DONORS.DONOR_ID)
WHERE APPOINTMENT.DATE=CURDATE() 
ORDER BY APPOINTMENT.DATE, APPOINTMENT.HOUR;
";
$result = $connection->query($sql);
if ($result && $result->num_rows>0) {
    $_SESSION['id'] = "";
    echo "
 <h1>Today's Appointements</h1>";
    echo "   <table>
        <tr>
            <td>Donor ID</td>
            <td>Full Name</td>
            <td>Gendar</td>
            <td>Blood Group</td>
            <td>Date</td>
            <td>Hour</td>
            <td>Is Donate ?</td>
            <td>Is Not Come ?</td>
        </tr>";
        while($row = $result->fetch_assoc()){
            $id = $row['DONOR ID'];
            $_SESSION['id']= $id;
            $fn = $row['FULL NAME'];
            $g = $row['GENDER'];
            $bg = $row['BLOOD GROUP'];
            $d = $row['DATE'];
            $h = $row['TIME'];
            echo "<tr>
            <td>$id</td>
            <td>$fn</td>
            <td>$g</td>
            <td>$bg</td>
            <td>$d</td>
            <td>$h</td>
            <td><a href='donate.php'><button>Donate</button></td>
            <td><a href='not_come.php'><button>Not Come</button></td>
        </tr>";
        }
        echo "   </table>";


} 
else if ($result && $result->num_rows === 0) {
    $done = false;
    echo "<h3>No Appointemnt Found For Today!</h3>
    ";
    echo "<a href='admin.php' id='b'>Back</a>";
}
else {
    echo "hi"."<br>";
    echo $connection->errno;
}

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KOYA Blood Donation Bank | Today's Appointemnts</title>
</head>
<style>
    body{
        min-width: 1000px;
        max-width: 1400px;
    }
    table,tr,td{
        border: 2px solid black;
        border-collapse: collapse;
    }
    td{
        text-align: center;
        font-size: 20px;
    }
    table{
        position: absolute;
        margin-left: 17%;
        width: 70%;
        height: 20%;
        margin-top: 10%;
    }
    h1{
        position: absolute;
        margin-left: 40%;
    }
    button{
        width: 100%;
        height: 100%;
        font-size: 30px;
    }
    h3{
        font-size: 50px;
        position: absolute;
        margin-left: 25%;
        margin-top: 15%;
}
#b{
    position: absolute;
    margin-top: 20%;
    margin-left: 42%;
    width: 10%;
    font-size: 35px;
    height: 6%;
    text-decoration: none;
    text-align: center;
       border: 3px solid rgb(0, 125, 125);
    color: rgb(0, 125, 125);
    background-color: whitesmoke;
}
#b:hover{
    background-color: rgba(207, 197, 197, 1);
}
        .back{
               text-decoration: none;
            position: absolute;
            margin-top: 5%;
            margin-left: 5%;
            width: 5%;
            height: 4%;
            text-align: center;
            font-size: 25px;
             border: 3px solid rgb(0, 125, 125);
    color: rgb(0, 125, 125);
    background-color: whitesmoke;
        }
        .back:hover{
    background-color: rgba(228, 235, 235, 1);
    cursor: pointer;
}
@media (min-width:1000px) and (max-width: 1400px) {
    table{
        width: 10%;
        height: 10%;
        margin-left: 7%;
    }
    td{
        font-size: 15px;
    }
    button{
        font-size: 10px;
        width: 100%;
    }
    h1{
        margin-left: 10%;
    }
   
}
@media (min-width:800px) and (max-width: 1000px) {
    table{
        width: 10%;
        height: 10%;
        margin-left: 5%;
    }
    td{
        font-size: 15px;
    }
    button{
        font-size: 10px;
        width: 100%;
    }
    h1{
        margin-left: 10%;
    }
         .back{
        margin-left: 50%;
        width: 6%;
        height: 4%;
        font-size: 15px;
    }
}
@media (min-width:600px) and (max-width: 800px) {
       table{
        width: 10%;
        height: 10%;
        margin-left: 7%;
    }
    td{
        font-size: 15px;
    }
    button{
        font-size: 10px;
        width: 100%;
    }
    h1{
        margin-left: 10%;
    }
       .back{
        margin-left: 65%;
        width: 6%;
        height: 4%;
        font-size: 15px;
    }
}
@media (min-width:480px) and (max-width: 600px) {
       table{
        width: 10%;
        height: 10%;
        margin-left: 7%;
        margin-top: 15%;
    }
    td{
        font-size: 15px;
    }
    button{
        font-size: 10px;
        width: 100%;
    }
    h1{
        margin-left: 10%;
    }
    .back{
        margin-left: 70%;
        width: 10%;
        height: 7%;
    }
}

</style>

<body>
     <?php if($done){

        echo "<a href='admin.php' class='back'>Back</a>";
     }?>

</body>

</html>