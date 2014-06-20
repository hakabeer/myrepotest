<?xml version="1.0" encoding="ISO-8859-1" ?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8"></meta>
<title>MyRegIntel SitePage</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/admin/css/normalize.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/admin/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/admin/css/style.css"/>
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/admin/css/font-awesome.min.css"/>
</head>
<body>
<div id="login-page">
	<header>
		<div class="logo"></div>

		<!-- <h2>Welcome to MyRegIntel</h2> -->
		<p>Sign in to your account</p>
	</header>
	<form id="form" name="loginForm" action="/en/login" method="post">
		<div class="row-fluid">
			<div class="span6">
				<div class="text-field">
					<i class="fa fa-envelope-o"></i>
					<input tabindex="1" placeholder="Email address" name="LoginForm[email]" id="LoginForm_email" type="text"/>	
				</div>
			</div>

			<div class="span6">
				<div class="text-field">
					<i class="fa fa-key"></i>
					<input autocomplete="off" tabindex="2" placeholder="Password" name="LoginForm[password]" id="LoginForm_password" type="password"/>
				</div>
			</div>
		</div>

		<div class="row-fluid">
				<div class="mri_signin_holder">
				<button type="button" class="btn btn-success mri_signin">Sign In</button>
				</div>
		</div>
	<section class="mri_signin_others">
	<div class="mri_pass"><a href="#">Forgot Password?</a></div>
	<div class="mri_signup"><a href="#">New User Sign Up</a></div>
	<div class="mri_signup"><a href="#">Home</a></div>
	</section>		
	</form>

</div>
</body>
</html>