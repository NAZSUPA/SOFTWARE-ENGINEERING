<?php

session_start();
require_once("connection.php");
$message = "";
   if($_SERVER["REQUEST_METHOD"] == "POST"){
         $username = $_POST['username'];
         $password = $_POST['password'];

         $Admin_username = "ADMIN";
         $Admin_password = "Admin_koya";

         if($Admin_username == $username && $Admin_password == $password ){
          header("Location: admin.php");
          exit();
         }
       
         else{
          $STATEMENT = $connection->prepare("SELECT * FROM DONORS WHERE USER_NAME = ? AND PASS_WORD = ?;");
          $STATEMENT->bind_param("ss",$username,$password);
          $STATEMENT->execute();
          $result =  $STATEMENT->get_result();
         if ($result->num_rows > 0) {
            $row = $result->fetch_assoc();
            $active = $row['ACCOUNT_ACTIVATION'];
            $_SESSION['user_id'] = $row['DONOR_ID'];
            if($active != 0){
              // Successful login
              $_SESSION['active'] = '1';
              $_SESSION['username'] = $username;
              $_SESSION['location']= "dashboard.php";
              header("Location: dashboard.php");
              exit();
            }
            else{$_SESSION['location']= "waitboard.php";
              $_SESSION['active'] = '0';
               $_SESSION['username'] = $username;
              header("Location: waitboard.php");
              exit(); 
            }
         } else {
            $_SESSION['location']= "board.php";
              // Invalid credentials
                $message = "Invalid username or password.";
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
        <link rel="stylesheet" href="../css/login.css">
    <title>Blood Donation Bank | Login</title>
</head>
<body>
    <form action="<?php echo $_SERVER["PHP_SELF"]; ?>" method="POST">
        
       <h3 style="color: red; position: absolute; margin-left: 35%; font-size: 24px;"><?php echo $message; ?></h3>
       <br>
        <label for="username">Username</label>
        <input type="text" name="username" placeholder="username" required>
        <br>
        <br>
        <label for="password">Password</label>
        <input type="text" name="password" placeholder="password" required>
        <br>
        <button>Log In</button>
        <div id="div">
        <p>If You Don't Have Account? &nbsp;<a href="signup.php">Sign Up</a></p>
        </div>
    </form>
</body>
</html>