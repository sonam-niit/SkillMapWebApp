<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script> 
<title>Insert title here</title>
</head>
<body>
	

<div class="container">
	<div class="row">
		<h2>Create Your Simple Registration Form</h2> 
        
        <form class="form-horizontal" method="post" action="register">
<fieldset>

<!-- Form Name -->
<legend>Register Here</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="eid">Employee Id:</label>  
  <div class="col-md-4">
  <input id="eid" name="eid" placeholder="Insert your Employee Id" class="form-control input-md" 
  required="" type="text" oninvalid="this.setCustomValidity('Please Enter valid Employee Id')">
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Name:</label>  
  <div class="col-md-4">
  <input id="name" name="name" placeholder="Insert your Full Name" class="form-control input-md" required="" type="text">
  <span class="help-block"> </span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email:</label>  
  <div class="col-md-4">
  <input id="email" name="email" placeholder="Insert your Email" class="form-control input-md" required="" type="text">
  <span class="help-block"> </span>  
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="phone">Phone:</label>  
  <div class="col-md-4">
  <input id="textinput" name="phone" placeholder="Insert your Phone" class="form-control input-md" required="" type="text">
  <span class="help-block"> </span>  
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="city">City:</label>  
  <div class="col-md-4">
  <input id="city" name="city" placeholder="Insert your City" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="qualification">Qualification:</label>  
  <div class="col-md-4">
  <input id="qualification" name="qualification" placeholder="Insert your Qualification" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="skill">Skill Set:</label>  
  <div class="col-md-4">
  <input id="skill" name="skill" placeholder="Insert your Skill Set" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="certification">Certification:</label>  
  <div class="col-md-4">
  <input id="certification" name="certification" placeholder="Insert your Certification" class="form-control input-md" required="true" type="text">
  <span class="help-block"> </span>  
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>  
  <div class="col-md-4">
  <input id="password" name="password" placeholder="Insert your Password" class="form-control input-md" required="" type="password">
  <span class="help-block"> </span>  
  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"> </label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Submit</button>
  </div>
</div>

</fieldset>
</form>
  
	</div>
</div>
</body>
</html>