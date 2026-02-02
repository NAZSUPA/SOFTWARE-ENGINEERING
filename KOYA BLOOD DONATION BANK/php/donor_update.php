<?php
 $fn = $ln = $bd = $g = $bg = $un = $p = $aa = "";
 require_once('connection.php');
session_start();
$id = $_SESSION['id'];
            $statement = $connection->prepare(
             "SELECT FIRST_NAME,LAST_NAME,BIRTHDAY,GENDER,BLOOD_GROUP,USER_NAME,PASS_WORD,ACCOUNT_ACTIVATION
            FROM DONORS WHERE DONOR_ID = ?;
            ");
            $statement->bind_param("i",$id);
            $statement->execute();
            $result = $statement->get_result(); 
            $row = $result->fetch_assoc();

            $fn = $row['FIRST_NAME'];
            $ln = $row['LAST_NAME'];
            $bd = $row['BIRTHDAY'];
            $g = $row['GENDER'];
            $bg = $row['BLOOD_GROUP'];
            $un = $row['USER_NAME'];
            $p = $row['PASS_WORD'];
            if($row['ACCOUNT_ACTIVATION']=='0'){
            $aa = "Non-Active";
            }
        else{
            $aa = "Active";
        }


            $message = "";
$fname_error = $lname_error = $user_name_error = $password_error =$bd_error ="";
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        $fname = $lname = $bd = $gender = $blood_group = $user_name = $password =$account_activation= "";

        if(empty($_POST['fn'])){
            $fname_error = "First Name is required"."<br>";
        }
        else{
            $fname = htmlspecialchars($_POST['fn']);
            if(strlen($fname) > 25){
                $fname_error .= "First Name must be 1-25 characters long"."<br>";
            }
               if(preg_match('/[0-9]|[!@#$%^&*()_+{}|:<>?\/,.;]/', $fname)){
                $fname_error .= "First Name must not contain numbers or special characters"."<br>";
            }
        }
         if(empty($_POST['ln'])){
            $lname_error .= "Last Name is required"."<br>";
        }
        else{
            $lname = htmlspecialchars($_POST['ln']);
            if(strlen($lname) > 25){
                $lname_error .= "Last Name must be 1-25 characters long"."<br>";
            } 
            if(preg_match('/[0-9]|[!@#$%^&*()_+{}|:<>?\/,.;]/', $lname)){
                $lname_error .= "Last Name must not contain numbers or special characters"."<br>";
            }
        }   
         if(empty($_POST['un'])){
            $user_name_error .= "User Name is required"."<br>";
        }
        else{
            $user_name = htmlspecialchars($_POST['un']);
            if(strlen($user_name) > 20){
                $user_name_error .= "UserName must be 1-20 characters long"."<br>";
            }
        }
         if(empty($_POST['pw'])){
            $password_error .= "Password is required"."<br>";
        }
        else{
            $password = $_POST['pw'];
             if(strlen($password) > 60){
                $password_error .= "Passowrd must be 1-60 characters long"."<br>";
            } 
        }
              if(empty($_POST['bd'])){
                $bd_error .= "Birthday is required"."<br>";
            }
            else{
                $bd = $_POST['bd'];
            }
        if(empty($fname_error) && empty($lname_error) && empty($user_name_error) && empty($password_error) && empty($bd_error)){
            $account_activation = $_POST['aa'];
            $gender = $_POST['gn'];
            $blood_group = $_POST['bg'];
            $STATEMENT = $connection->prepare("SELECT FIRST_NAME,LAST_NAME,BIRTHDAY,GENDER,BLOOD_GROUP,USER_NAME,PASS_WORD,ACCOUNT_ACTIVATION
            FROM DONORS
            WHERE USER_NAME = ?;
            ");
            $STATEMENT->bind_param("s",$user_name);
            $STATEMENT->execute();
            $STATEMENT->store_result();
            if($STATEMENT->num_rows > 0 || $STATEMENT->num_rows == 1 ){
                $message = "Username Taken. Please Choose Another One.";
            }
            else{
                $sql = "SELECT TIMESTAMPDIFF(YEAR,'$bd',CURDATE()) AS age;";
                $result = $connection->query($sql);
                $rows = $result->fetch_assoc();
                $age = $rows['age'];
                if($age<18 && $age<39){
                    $bd_error .= "Age Should Be 18-39";
                }

                else{
            $statement = $connection->prepare("UPDATE donors SET FIRST_NAME = ? , LAST_NAME = ?, BIRTHDAY = ? , GENDER = ? , BLOOD_GROUP=?, USER_NAME=?, PASS_WORD=? , ACCOUNT_ACTIVATION=? WHERE DONOR_ID = $id;");
            $statement->bind_param("sssssssi",$fname, $lname, $bd, $gender, $blood_group, $user_name, $password,$account_activation);
            $statement->execute();
            if($connection->affected_rows > 0){
                header("Location: donors.php");
                exit();
            }
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
    <title>KOYA Blood Donation Bank | Donors-Update</title>
    <style>
        .back{
            text-decoration: none;
            position: absolute;
            margin-top: 35%;
            margin-left: 15%;
            width: 10%;
            height: 4%;
            text-align: center;
            font-size: 20px;
             border: 3px solid rgb(0, 125, 125);
    color: rgb(0, 125, 125);
    background-color: whitesmoke;
    border-radius: 10px;
        }
        form{
    position: absolute;
    margin-left: 15%;
    margin-top: 10%;
    white-space: nowrap;
    width: 65%;
    height: 50%;
    background-color: rgb(226, 255, 255);
    border: 2px solid rgb(0, 125, 125);
    border-radius: 10px;
}
label{
    position: relative;
    font-size: 25px;
    margin-left: 5%;
    margin-top: 5%;
    color: rgb(0, 125, 125);
}
input{
    margin-left: 5%;
    margin-top: 4%;
    position: relative;
    width: 15%;
    height: 7%;
    font-size: 20px;
}
select{
width: 12%;
height: 10%;
font-size: 15px;
}
#fne{
    position: absolute;
    margin-left: 27%;
    margin-top: 6%;
    font-size: 27px;
    color: red;
}
#lne{
position: absolute;
    margin-left: 52%;
    margin-top: 6%;
    font-size: 27px;
    color: red;
}
#une{
position: absolute;
    margin-left: 26%;
    margin-top: 22%;
    font-size: 27px;
    color: red;
}
#pwe{
position: absolute;
    margin-left: 51%;
    margin-top: 22%;
    font-size: 27px;
    color: red;
}
#bde{
  position: absolute;
    margin-left: 26%;
    margin-top: 16%;
    font-size: 27px;
    color: red;  
}
#error{
      position: absolute;
    margin-left: 35%;
    margin-top: 5%;
    font-size: 27px;
    color: red;  
}

#button{
       border: 3px solid rgb(0, 125, 125);
    color: rgb(0, 125, 125);
    background-color: whitesmoke;
    border-radius: 10px;
    position: absolute;
    margin-left: 38%;
    width: 200px;
     font-size: 20px;
    margin-top: 1%;
    height: 40px;
}
#button:hover{
    background-color: rgba(228, 235, 235, 1);
    cursor: pointer;
}
.back:hover{
    background-color: rgba(228, 235, 235, 1);
    cursor: pointer;
}
.aa{
    position: absolute;
    margin-left: 5%;
    color: rgb(0, 125, 125);
    font-size: 20px;
}
.ao{
    width: 45%;
    height: 10%;
    font-size: 20px;
}

@media (max-width:480px) {
    .back{
        margin-top: 75%;
    }
    body{
        background-color: black;
    }
      label{
        font-size: 12px;
        margin-left: 1%;
    }
    input{
        width: 15%;
    }
    #button{
        width: 90px;
        margin-left: 75%;
        font-size: 20px;
    }
    form{
        width: 100%;
        font-size: 15px;
        margin-top: 20%;
        margin-left: 1%;
    }
    select{
        font-size: 10px;
        width: 10%;
    }
    .aa{
        margin-left: 1%;
    }
}
@media (min-width: 481px) and (max-width: 523px) {
      .aa{
        margin-left: 1%;
    }
        #button{
        width: 90px;
        margin-left: 75%;
        font-size: 20px;
    }
     .back{
        margin-top: 71%;
    }
      label{
        font-size: 15px;
        margin-left: 1%;
    }
    input{
        width: 20%;
    }

    form{
        width: 95%;
        font-size: 15px;
        margin-top: 20%;
        margin-left: 0%;
    }
}
@media (min-width: 517px) and (max-width: 635px) {
 
          .aa{
        margin-left: 1%;
    }
        #button{
        width: 90px;
        margin-left: 75%;
        font-size: 20px;
    }
     .back{
        margin-top: 54%;
        margin-left: 56%;
    }
      label{
        font-size: 15px;
        margin-left: 1%;
    }
    input{
        width: 20%;
    }
    form{
        width: 95%;
        font-size: 15px;
        margin-top: 20%;
        margin-left: 0%;
        height: 45%;
    }
}
@media (min-width: 636px) and (max-width: 780px) {
 
          .aa{
        margin-left: 1%;
    }
        #button{
        width: 90px;
        margin-left: 75%;
        font-size: 20px;
    }
     .back{
        margin-top: 46%;
        margin-left: 56%;
    }
      label{
        font-size: 15px;
        margin-left: 1%;
    }
    input{
        width: 20%;
    }
    form{
        width: 95%;
        font-size: 15px;
        margin-top: 15%;
        margin-left: 0%;
        height: 50%;
    }
}

@media (min-width: 781px) and (max-width: 954px) {
          .aa{
        margin-left: 1%;
        margin-top: -5%;
    }
        #button{
        width: 90px;
        margin-left: 75%;
        font-size: 20px;
    }
     .back{
        margin-top: 46%;
        margin-left: 56%;
    }
      label{
        font-size: 15px;
        margin-left: 5%;
    }
    input{
        width: 20%;
        margin-left: 7%;
    }
 
    form{
        width: 95%;
        font-size: 30px;
        margin-top: 9%;
        margin-left: 0%;
        height: 65%;
    }
}
@media (min-width: 955px) and (max-width: 1200px) {
               body{
        background-color: black;
    }
          .aa{
        margin-left: 1%;
        margin-top: -5%;
    }
        #button{
        width: 90px;
        margin-left: 75%;
        font-size: 20px;
    }
     .back{
        margin-top: 46%;
        margin-left: 56%;
    }
      label{
        font-size: 15px;
        margin-left: 5%;
    }
    input{
        width: 20%;
        margin-left: 7%;
    }

    form{
        width: 95%;
        font-size: 30px;
        margin-top: 9%;
        margin-left: 2%;
        height: 70%;
    }
}
    </style>
</head>
<body>
    <form action="<?php echo$_SERVER['PHP_SELF'];?>" method="POST">
 <label for="fn">First Name</label>
        <input type="text" name="fn" placeholder="first-name" value="<?php echo $fn;?>">
        &nbsp;
        <label for="ln">Las Name</label>
        <input type="text" name="ln" placeholder="last-name" value="<?php echo $ln;?>">
        <br>
        <br>
        <label for="bd">Birthday</label>
        <input type="date" name="bd" value="<?php echo $bd;?>">
        &nbsp;
        <label for="gn">Gender</label>
        &nbsp;
        <select name="gn" required>
            <option value="FEMALE" name="gn" <?php echo ($g == 'FEMALE') ? 'selected' : ''; ?>>Female</option>
            <option value="MALE" name="gn" <?php echo ($g == 'MALE') ? 'selected' : ''; ?>>male</option>
        </select>
        &nbsp;
        <label for="bg">Blood Group</label>
        
               <select name="bg" required value="<?php echo $bg;?>">
            <option value="A+" <?php echo ($bg == 'A+') ? 'selected' : ''; ?>>A+</option>
            <option value="A-" <?php echo ($bg == 'A-') ? 'selected' : '';?>>A-</option>
            <option value="B+" <?php echo ($bg == 'B+') ? 'selected' : '';?>>B+</option>
            <option value="B-" <?php echo ($bg == 'B-') ? 'selected' : '';?>>B-</option>
            <option value="AB+" <?php echo ($bg == 'AB+') ? 'selected' : '';?>>AB+</option>
            <option value="AB-" <?php echo ($bg == 'AB-') ? 'selected' : '';?>>AB-</option>
            <option value="O+" <?php echo ($bg == 'O+') ? 'selected' : '';?>>O+</option>
            <option value="O-" <?php echo ($bg == 'O-') ? 'selected' : '';?>>O-</option>
        </select>
        &nbsp;
         <br>
        <br>
        <label for="un">Username</label>
        <input type="text" name="un" value="<?php echo $un;?>">
        <label for="pw">Password</label>
        <input type="text" name="pw" value="<?php echo $p;?>">
        <br>
        <br>
         <input type="submit" name="sign_up" value="Update" id="button">
         <br>
         <br>
        <span class="aa"> Account Activation :
         <select name="aa"required  class="ao">
            <option value="1" class="ao" <?php echo ($aa == 'Active') ? 'selected' : '';?>>Active</option>
            <option value="0" class="ao" <?php echo ($aa == 'Non-Active') ? 'selected' : '';?>>Non-Active</option>
         </select>
          </span>
    </form>
    
    <span id="error"><?php echo $message;?></span>
    <span id="fne"><?php echo $fname_error?></span>
    <span id="lne"><?php echo $lname_error?></span>
    <span id="une"><?php echo $user_name_error?></span>
    <span id="pwe"><?php echo $password_error?></span>
    <span id="bde"><?php echo $bd_error?></span>

    <a href="donors.php" class="back">Back</a>
</body>
</html>