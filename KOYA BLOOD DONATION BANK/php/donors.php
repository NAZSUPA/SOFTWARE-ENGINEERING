<?php
require_once('connection.php');
session_start();
$id_error = $id = "";
if($_SERVER['REQUEST_METHOD']==='GET'){
    
    if(isset($_GET['id']) && !empty($_GET['id'])){
        $id = $connection->real_escape_string($_GET['id']);
        if(!preg_match('/^[0-9]+$/', $id)){
            $id_error .= "Donor ID Should Only Contian Number";
        }
        else{
            $_SESSION['id'] = $id;
              $statement = $connection->prepare(
             "SELECT FIRST_NAME
            FROM DONORS WHERE DONOR_ID = ?;
            ");
            $statement->bind_param("i",$id);
            $statement->execute();
            $result = $statement->get_result(); 
            $row = $result->fetch_assoc();

            if($result->num_rows>0){
            header("Location: donor_update.php");
            exit();  
            }
            else{
                $id_error .= "There Is No Such Donor ID";
            }
            
        }
    }
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KOYA Blood Donation Bank | Donors-Search </title>
    <style>
        h1 {
            position: absolute;
            margin-left: 45%;
            margin-top: 10%;
        }

        form {
            position: absolute;
            margin-left: 32%;
            margin-top: 15%;
        }

        input {
            width: 60%;
            height: 20%;
            font-size: 30px;
        }

        .text {
            font-size: 30px;
            font-weight: bold;
        }

        .button {
            position: relative;
            left: 27%;
            border: 3px solid rgb(0, 125, 125);
            color: rgb(0, 125, 125);
            background-color: whitesmoke;
        }
        .button:hover{
            background-color: rgba(214, 221, 221, 1);
            cursor: pointer;
        }
             .error{
            color: red;
            font-size: 25px;
            position: absolute;
            margin-left: 25%;
            margin-top: -5%;
        }
        .back{
               text-decoration: none;
            position: absolute;
            margin-top: 25%;
            margin-left: 41%;
            width: 20%;
            height: 5%;
            text-align: center;
            font-size: 33px;
             border: 3px solid rgb(0, 125, 125);
    color: rgb(0, 125, 125);
    background-color: whitesmoke;
        }
        .back:hover{
    background-color: rgba(228, 235, 235, 1);
    cursor: pointer;
}
@media (max-width:480px) {
    .back{
        margin-top: 60%;
        margin-left: 33%;
        width: 38%;
        height:5%;
    }
    input.button{
        margin-top: 5%;
        margin-left: -25%;
    }
    h1{
        margin-right: 3%;
    }
}

@media (min-width: 481px) and (max-width: 523px) {

        .back{
        margin-top: 60%;
        margin-left: 33%;
        width: 38%;
        height:5%;
    }
    input.button{
        margin-top: 5%;
        margin-left: -25%;
    }
    h1{
        margin-right: 3%;
    }
}
@media (min-width: 517px) and (max-width: 635px) {
    
        .back{
        margin-top: 45%;
        margin-left: 33%;
        width: 38%;
        height:5%;
    }
    input.button{
        margin-top: 5%;
        margin-left: -25%;
    }
    h1{
        margin-right: 3%;
    }
}
@media (min-width: 636px) and (max-width: 780px) {
          .back{
        margin-top: 40%;
        margin-left: 33%;
        width: 38%;
        height:5%;
    }
    input.button{
        margin-top: 5%;
        margin-left: -25%;
    }
    h1{
        margin-right: 3%;
    }
}

@media (min-width: 781px) and (max-width: 954px) {
           .back{
        margin-top: 35%;
        margin-left: 33%;
        width: 32%;
        height:5%;
    }
    input.button{
        margin-top: 5%;
        margin-left: -25%;
    }
    h1{
        margin-right: 3%;
    }
}
@media (min-width: 955px) and (max-width: 1200px) {
            .back{
        margin-top: 30%;
        margin-left: 33%;
        width: 25%;
        height:5%;
    }
    input.button{
        margin-top: 5%;
        margin-left: -25%;
    }
    h1{
        margin-right: 3%;
    }
}

    </style>
</head>

<body>
    <h1>Search </h1>
    <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="GET">
        <span class="error"><?php echo $id_error;?></span>
        <br><br>
        <span class="text">Donor ID</span> &nbsp; <input type="text" name="id" required>
        <br>
        <br>
        <input type="submit" value="Search" class="button">
    </form>
    <a href="admin.php" class="back">Back</a>
</body>

</html>