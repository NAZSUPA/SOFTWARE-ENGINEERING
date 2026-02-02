<?php
session_start();
$location = "board.php";
if(isset($_SESSION['location'])){
    $location = $_SESSION['location'];
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<style>
    #wlecom {
    position: relative;
    left: 18%;
    font-size: 55px;
    color: rgb(197, 50, 50);
}

header {
    border: 2px solid rgb(197, 50, 50);
    margin: 1%;
    border-radius: 38px;
}

header nav {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: center;
}

header nav a {
    margin: 3%;
    background-color: rgb(197, 50, 50);
    color: whitesmoke;
    width: 11%;
    text-align: center;
    height: 34px;
    text-decoration: none;
    border-radius: 10px;
    font-size: 30px;
}

header nav a:hover {
    background-color: rgb(224, 197, 197);
    color: rgb(197, 50, 50);
    font-weight: bold;
}

header nav a:active {
    background-color: rgb(255, 255, 255);
    color: rgb(61, 58, 227);
    font-weight: bold;
}

#blood_icon_right {
    width: 15%;
    height: 24%;
    position: absolute;
    left: 83%;
    top: 4%;
}

#blood_icon_left {
    width: 15%;
    height: 24%;
    position: absolute;
    left: 3%;
    top: 4%;
}

@media (max-width: 480px) {
    header nav a {
        font-size: 12px;
        height: 17px;
        width: 63px;
    }

    #wlecom {
        left: 14%;
        font-size: 18px;
    }

    #blood_icon_right {
        width: 50px;
        height: 50px;
        left: 84%;
    }

    #blood_icon_left {
        width: 50px;
        height: 50px;
    }
}

@media (min-width: 481px) and (max-width: 523px) {
    header nav a {
        font-size: 12px;
        height: 17px;
        width: 63px;
    }

    #wlecom {
        left: 12%;
        font-size: 20px;
    }

    #blood_icon_right {
        width: 50px;
        height: 50px;
        left: 84%;
    }

    #blood_icon_left {
        width: 50px;
        height: 50px;
    }
}

@media (min-width: 517px) and (max-width: 563px) {
    header nav a {
        font-size: 12px;
        height: 17px;
        width: 63px;
    }

    #wlecom {
        left: 13%;
        font-size: 22px;
    }

    #blood_icon_right {
        width: 50px;
        height: 50px;
        left: 84%;
    }

    #blood_icon_left {
        width: 50px;
        height: 50px;
    }
}
@media (min-width: 564px) and (max-width: 635px) {
        header nav a {
        font-size: 12px;
        height: 20px;
        width: 100px;
    }

    #wlecom {
        left: 14%;
        font-size: 25px;
    }

    #blood_icon_right {
        width: 50px;
        height: 50px;
        left: 84%;
    }

    #blood_icon_left {
        width: 50px;
        height: 50px;
    }
}

@media (min-width: 635px) and (max-width: 780px) {
    header nav a {
        font-size: 20px;
        height: 28px;
        width: 120px;
    }

    #wlecom {
        left: 18%;
        font-size: 26px;
    }

    #blood_icon_right {
        width: 70px;
        height: 70px;
        left: 87%;
    }

    #blood_icon_left {
        width: 70px;
        height: 70px;
    }
}
@media (min-width: 781px) and (max-width: 869px) {
    header nav a {
        font-size: 20px;
        height: 26px;
        width: 125px;
    }

    #wlecom {
        left: 20%;
        font-size: 28px;
    }

    #blood_icon_right {
        width: 70px;
        height: 70px;
        left: 87%;
        top: 9%;
    }

    #blood_icon_left {
        width: 70px;
        height: 70px;
        top: 9%;
    }
}
@media (min-width: 870px) and (max-width: 972px) {
    header nav a {
        font-size: 20px;
        height: 28px;
        width: 130px;
    }

    #wlecom {
        left: 23%;
        font-size: 30px;
    }

    #blood_icon_right {
        width: 100px;
        height: 87px;
        left: 87%;
        top: 8%;
    }

    #blood_icon_left {
        width: 100px;
        height: 87px;
        top: 8%;
    }
}
@media (min-width:973px) and (max-width: 1200px) {
        header nav a {
        font-size: 20px;
        height: 30px;
        width: 150px;
    }

    #wlecom {
        left: 23%;
        font-size: 35px;
    }

    #blood_icon_right {
        width: 100px;
        height: 87px;
        left: 87%;
        top: 8%;
    }

    #blood_icon_left {
        width: 100px;
        height: 87px;
        top: 8%;
    }
}

</style>
<body>
      <header>
    <h1 id="wlecom">Welcom To Koya Blood Donation Bank</h1>
        <img src="../images/blood-drop.png" alt="a blood icon" id="blood_icon_right">
        <img src="../images/blood-drop.png" alt="a blood icon" id="blood_icon_left">
    <nav>
        <a href="index.php">Home</a>
        <a href="information.php">Information</a>
        <a href="<?php echo $location;?>">DashBoard</a>
    </nav>
</header>
</body>
</html>