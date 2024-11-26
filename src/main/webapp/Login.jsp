<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<!-- Link to Google Fonts -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Lora:wght@600&display=swap" rel="stylesheet">
<!-- Font Awesome for Icons -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<style>
    body {
    background: url('https://www.example.com/food-background.jpg') no-repeat center center fixed; 
    background-size: cover;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

/* Login Card with Light Green and White */
.login-container {
    background: rgba(144, 238, 144, 0.1); /* Light Green with Transparency */
    padding: 40px;
    border-radius: 10px;
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 400px;
    text-align: center;
}

    /* Header */
    .login-container h2 {
        font-family: 'Lora', serif; /* New font */
        font-size: 1.8rem; /* Reduced font size */
        color: #4caf50; /* Light green */
        margin-bottom: 30px;
        font-weight: bold;
        letter-spacing: 1px;
        white-space: nowrap; /* Ensures text stays in a single line */
        overflow: hidden;
        text-overflow: ellipsis; /* Adds ellipsis if the text overflows */
    }

    /* Labels */
    .login-container label {
        display: block;
        font-size: 1.1rem;
        margin: 10px 0;
        color: #2c6c39;
        text-align: left;
        font-weight: 500;
    }

    /* Input Fields */
    .login-container .input-container {
        position: relative;
        width: 100%;
    }

    .login-container input[type="text"],
    .login-container input[type="password"] {
        width: 100%;
        padding: 10px;
        padding-right: 40px; /* Space for the icon */
        margin: 10px 0;
        border-radius: 8px;
        border: 2px solid #81c784; /* Light green border */
        background-color: #f1f8e9; /* Light greenish background */
        color: #333;
        font-size: 0.9rem; /* Reduced font size */
        box-sizing: border-box;
        transition: border-color 0.5s, background-color 0.3s;
    }

    /* Icon Style */
.login-container .show-password-icon {
    position: absolute;
    top: 50%;
    right: 10px;
    transform: translateY(-50%);
    font-size: 1.2rem;
    color: #000; /* Black color for the icon */
    cursor: pointer;
    transition: color 0.3s ease;
}
    

    /* Input Focus Effect */
    .login-container input[type="text"]:focus,
    .login-container input[type="password"]:focus {
        border-color: #66bb6a; /* Slightly darker green on focus */
        background-color: #e8f5e9; /* Slightly lighter green background on focus */
        outline: none;
    }

    /* Submit Button */
    .login-container input[type="submit"] {
        width: 100%;
        padding: 15px;
        margin-top: 20px;
        background-color: #ffeb3b; /* Soft yellow */
        border: none;
        border-radius: 30px;
        color: #fff;
        font-size: 1.2rem;
        font-weight: bold;
        cursor: pointer;
        transition: transform 0.3s ease, background-color 0.3s ease;
    }

    /* Submit Button Hover Effect */
    .login-container input[type="submit"]:hover {
        transform: scale(1.05);
        background-color: #fbc02d; /* Darker yellow on hover */
    }
    
    
    /* Links */
   .login-container .links {
    margin-top: 20px;
    font-size: 0.9rem;
    color: #333;
    text-align: center; /* Align the links to the left */
    }

    .login-container .links a {
    display: block; /* Makes each link a block-level element */
    color: black; /* Vibrant orange color */
    text-decoration: none;
    margin: 10px 0; /* Adds space between the links */
    font-family: 'Poppins', sans-serif; /* New font family */
    transition: color 0.3s ease;
    
    }

    .login-container .links a:hover {
    text-decoration: underline;
    color: #e64a19; /* Slightly darker orange on hover */
    }
    

    
    /* Animations */
    @keyframes fadeIn {
        from {
            opacity: 0;
            transform: translateY(-50px);
        }
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }

    /* Responsive Design */
    @media (max-width: 768px) {
        .login-container {
            padding: 30px;
        }

        .login-container h2 {
            font-size: 1.6rem; /* Slightly smaller on smaller screens */
        }
    }

</style>
</head>
<body>

<div class="login-container">
    <h2>Login to Your Account</h2>
    <form action="Login">
        <label for="email">Email Address</label>
        <input type="text" id="email" name="email" placeholder="Enter your email" required>

        <label for="password">Password</label>
        <div class="input-container">
            <input type="password" id="password" name="password" placeholder="Enter your password" required>
            <!-- Show/Hide password icon -->
            <i id="toggle-password" class="fas fa-eye show-password-icon"></i>
        </div>

        <input type="submit" value="Login">
    </form>

    <!-- Forgot Password & Sign Up Links -->
    <div class="links">
        <a href="forgot-password.html">Forgot Password?</a>
        <a href="sign-up.html">Don't have an account?</a>
    </div>
</div>

<script>
    // JavaScript to toggle password visibility
    document.getElementById('toggle-password').addEventListener('click', function() {
        var passwordField = document.getElementById('password');
        var icon = this;

        if (passwordField.type === 'password') {
            passwordField.type = 'text'; // Show password
            icon.classList.remove('fa-eye'); // Change icon
            icon.classList.add('fa-eye-slash');
        } else {
            passwordField.type = 'password'; // Hide password
            icon.classList.remove('fa-eye-slash');
            icon.classList.add('fa-eye');
        }
    });
</script>

</body>
</html>
