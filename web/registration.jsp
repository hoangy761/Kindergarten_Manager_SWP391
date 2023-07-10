<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Kid ABC</title>
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
        <div class="container clearfix">
            <div class="form registration">
                <h3>Create an account</h3>
                <form action="registration" method="POST">
                    <p class="text-danger">${msq}</p>
                    <p>
                        <label>Full name<span>*</span></label>
                        <input name="fullName" type="text" value="${UserWrong.fullName}" required>
                        
                    </p>
                    <p>
                        <label>Date of birth<span>*</span></label>
                        <input name="dob" class="form-control" type="date" value="${UserWrong.dob}" required>
                    </p>
                    <p>
                        <label>Address <span>*</span></label>
                        <input type="text" name="address" class="form-control"  value="${UserWrong.address}"  placeholder="number-street-district-city" required>
                    </p>
                    <p>
                         <label>Gender <span>*</span></label>
                        <select class="form-select form-control border-warning"  value="${UserWrong.gender}"   name="gender" >
                        <option value="M"  >Male</option>
                        <option value="F"  >Female</option>
                    </select>
                    </p>
                    <p>
                        <label>Phone<span>*</span></label>
                        <input name="phone" class="form-control" value="${UserWrong.phoneNumber}" pattern="[0]{1}[0-9]{3}[0-9]{3}[0-9]{3}"  type="tel" required>
                    </p>
                    <p>
                        <label>Email</label>
                          <input name="email" id="email-input" class="form-control" value="${UserWrong.email}"  type="email">
                    </p>
                    <p>
                        <label>Password<span>*</span></label>
                        <input name="password" class="form-control" type="password" minlength="6" maxlength="30"  pattern="^(?=.*[a-z])(?=.*[A-Z]).*$" 
                               title="Please include at least 1 uppercase character, 1 lowercase character, and 1 number." id="password" required>
                    </p>
                    <p>
                        <label>Again password<span>*</span></label>
                        <input name="repeatPassword" class="form-control"type="password" required>
                    </p>
                    <p>
                        <label>
                            <a href="login.jsp">Have an account</a>
                        </label>
                        <input type="submit" value="Signup" />
                    </p>
                </form>
            </div>
        </div>
    </body>
     <script>
        var password = document.getElementById("password")
                , confirm_password = document.getElementById("confirm_password");

        function validatePassword() {
            if (password.value != confirm_password.value) {
                confirm_password.setCustomValidity("Passwords Don't Match");
            } else {
                confirm_password.setCustomValidity('');
            }
        }

        password.onchange = validatePassword;
        confirm_password.onkeyup = validatePassword;
        const emailInput = document.getElementById('email-input');
  const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}(?:\.[a-zA-Z]+)*$/;

  emailInput.addEventListener('input', function() {
    if (!emailPattern.test(emailInput.value)) {
      emailInput.setCustomValidity('Please enter a valid email address(EX: ex@ex.ex or ex@ex.ex.ex)');
    } else {
      emailInput.setCustomValidity('');
    }
  });
    </script>
</html>
