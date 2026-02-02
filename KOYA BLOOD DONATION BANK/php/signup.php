<?php
session_start();
require_once("connection.php"); 
$message = "";
$fname_error = $lname_error = $user_name_error = $password_error =$bd_error ="";
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        $fname = $lname = $bd = $gender = $blood_group = $user_name = $password ="";

        if(empty($_POST['fn'])){
            $fname_error = "First Name is required"."<br>";
        }
        else{
            $fname =  $connection->real_escape_string(htmlspecialchars($_POST['fn']));
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
            $lname =  $connection->real_escape_string(htmlspecialchars($_POST['ln']));
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
            $user_name =  $connection->real_escape_string(htmlspecialchars($_POST['un']));
            if(strlen($user_name) > 20){
                $user_name_error .= "UserName must be 1-20 characters long"."<br>";
            }
        }
         if(empty($_POST['pw'])){
            $password_error .= "Password is required"."<br>";
        }
        else{
            $password =  $connection->real_escape_string($_POST['pw']);
             if(strlen($password) > 60){
                $password_error .= "Passowrd must be 1-60 characters long"."<br>";
            } 
        }
              if(empty($_POST['bd'])){
                $bd_error .= "Birthday is required"."<br>";
            }
            else{
                $bd =  $connection->real_escape_string($_POST['bd']);
            }
        if(empty($fname_error) && empty($lname_error) && empty($user_name_error) && empty($password_error) && empty($bd_error)){
            $gender = $_POST['gn'];
            $blood_group = $_POST['bg'];
            $STATEMENT = $connection->prepare("SELECT PASS_WORD
            FROM DONORS
            WHERE USER_NAME = ?;
            ");
            $STATEMENT->bind_param("s",$user_name);
            $STATEMENT->execute();
            $STATEMENT->store_result();
            if($STATEMENT->num_rows > 0){
                $message = "Username Taken. Please Choose Another One.";
            }
            else{
                $sql = "SELECT TIMESTAMPDIFF(YEAR,'$bd',CURDATE()) AS age;";
                $result = $connection->query($sql);
                $rows = $result->fetch_assoc();
                $age = $rows['age'];
                if($age<18 && $age<39){
                    $bd_error .= "Your Age Should Be 18-39";
                }

                else{
            $statement = $connection->prepare("INSERT INTO donors (FIRST_NAME, LAST_NAME , BIRTHDAY, GENDER, BLOOD_GROUP, USER_NAME, PASS_WORD)
            values(?,?,?,?,?,?,?);");
            $statement->bind_param("sssssss",$fname, $lname, $bd, $gender, $blood_group, $user_name, $password);
            $statement->execute();
            if($connection->affected_rows > 0){
                $_SESSION['username'] = $user_name;
                header("Location: login.php");
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
        <link rel="icon" href="../images/blood-bag.png">
        <link rel="stylesheet" href="../css/signup.css">
    <title>Koya Blood Donation Bank | Sign Up</title>
</head>
<body>
    <form action="<?php echo $_SERVER["PHP_SELF"];?>" method="POST">
        <label for="fn">First Name</label>
        <input type="text" name="fn" placeholder="first-name" >
        &nbsp;
        <label for="ln">Las Name</label>
        <input type="text" name="ln" placeholder="last-name" >
        <br>
        <br>
        <label for="bd">Birthday</label>
        <input type="date" name="bd" >
        &nbsp;
        <label for="gn">Gender</label>
        &nbsp;
        <select name="gn" required>
            <option value="FEMALE" name="gn">Female</option>
            <option value="MALE" name="gn">male</option>
        </select>
        &nbsp;
        <label for="bg">Blood Group</label>
        &nbsp;
        <select name="bg" required>
            <option value="A+">A+</option>
            <option value="A-">A-</option>
            <option value="B+">B+</option>
            <option value="B-">B-</option>
            <option value="AB+">AB+</option>
            <option value="AB-">AB-</option>
            <option value="O+">O+</option>
            <option value="O-">O-</option>
        </select>
        <br>
        <br>
        <label for="un">Username</label>
        <input type="text" name="un" >
        <label for="pw">Password</label>
        <input type="text" name="pw" >
        <br>
        <br>
         <input type="submit" name="sign_up" value="Sign Up" id="button">
    </form>
   
    <span id="error"><?php echo $message;?></span>
    <span id="fne"><?php echo $fname_error?></span>
    <span id="lne"><?php echo $lname_error?></span>
    <span id="une"><?php echo $user_name_error?></span>
    <span id="pwe"><?php echo $password_error?></span>
    <span id="bde"><?php echo $bd_error?></span>
</body>
</html>