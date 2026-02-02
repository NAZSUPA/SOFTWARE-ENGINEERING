<?php
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KOYA Blood Bank Donation | Admin</title>
    <style>
        h1{
            position: absolute;
            margin-left: 40%;
            font-size: 100px;
            color: rgba(5, 89, 89, 1);
        }
        div {
            position: absolute;
            margin-left: 25%;
            margin-top: 16%;
        }

        a {
            margin: 20px;
            text-decoration: none;
            font-size: 60px;
            border: 3px solid rgb(0, 125, 125);
            color: rgb(0, 125, 125);
            background-color: whitesmoke;
            border-radius: 10px;
            padding: 10px;
            width: 30%;
        }
        a:hover{
            background-color: rgba(207, 197, 197, 1);
        }

        @media (max-width:480px) {
            h1{
                margin-left: 20%;
            }
            div{
             margin-top: 50%; 
             margin-left: 5%;  
            }
            a{
                font-size: 30px;
            }
            #d{
                position: relative;
                top: 44px;
            }
        }
        @media (min-width: 481px) and (max-width: 523px) {
               h1{
                margin-left: 20%;
            }
                div{
             margin-top: 50%; 
             margin-left: 5%;  
            }
            a{
                font-size: 30px;
            }
            #d{
                position: relative;
                top: 44px;
            }
        }
        @media (min-width: 517px) and (max-width: 612px) {
               h1{
                margin-left: 20%;
            }
                 div{
             margin-top: 50%; 
             margin-left: 20%;  
            }
            a{
                font-size: 30px;
            }
            #d{
                position: relative;
                top: 44px;
            }
        }
        @media (min-width: 613px) and (max-width: 780px) {
               h1{
                margin-left: 32%;
            }
         div{
             margin-top: 50%; 
             margin-left: 20%;  
            }
            a{
                font-size: 30px;
            }

        }

            @media (min-width: 781px) and (max-width: 954px) {
                    h1{
                margin-left: 32%;
            }
                  div{
             margin-top: 50%; 
             margin-left: 20%;  
            }
            a{
                font-size: 30px;
            }
            }
            @media (min-width: 955px) and (max-width: 1200px) {
                        div{
             margin-top: 30%; 
             margin-left: 23%;  
            }
            a{
                font-size: 50px;
            }
            }




    </style>
</head>

<body>
    <h1>Admin</h1>
    <div>
        <a href="admin_appointments.php" id="a">APPIONTMENTS</a>
        <a href="donors.php" id="d">DONORS</a>
    </div>
</body>

</html>