<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Kid ABC</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">      
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="lib/flaticon/font/flaticon.css" rel="stylesheet">
        <link rel="stylesheet" href="css/styleLogin.css" />
        <link href="img/favicon.ico" rel="icon">
        <link rel="shortcut icon" href="img/icon.ico">
        <style>
            body {

                background-image: url("img/school.jpg");
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size:cover;
                background-position : 50% 50%;
            }

        </style>
    </head>

    <body>
        <div class="container ">
            <div class="form login">
                <form method="post" action="login">
                    <p class="text-danger">${msq}</p>
                    <h3>Login</h3>
                    <p>
                        <label>Phone or email address<span>*</span></label>
                        <input type="txt" name="acc" value="${email1}" required>
                    </p>
                    <p>
                        <label>Password<span>*</span></label>
                        <input type="password" name="password" required>
                    </p>
                    <p>
                        <label>
                            <a href="forgotPassword.jsp">Forgot password?</a>
                            <a href="registration.jsp">Create an account</a>
                        </label>
                        <input type="submit" value="Login" />
                    </p>
                </form>
            </div>
        </div>
    </body>
</html>
