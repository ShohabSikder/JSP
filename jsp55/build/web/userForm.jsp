
<%@include file="header.jsp" %>

<div class="container bg-success text-center mt-3 ">
    <h1 style="color: white ">Add User</h1>
</div>
<form class="container" action="addUser.jsp" method="post" >
    <div class="row">
        <div class="col-md-6">
            <label  class="form-label">Full Name</label>
            <input type="text" class="form-control" id="FullName" name="fullName" placeholder="Full Name">
        </div>

        <div class="col-md-6">
            <label  class="form-label">User Name</label>
            <input type="text" class="form-control" id="UserName" name="userName" placeholder="username">
        </div>
        
        <div class="row mt-3">
            <div class="col-md-6">
            <label  class="form-label">Email</label>
            <input type="email" class="form-control" id="Email" name="email" placeholder="example@gmail.com">
        </div>
            
            <div class="col-md-6">
            <label  class="form-label">Password</label>
            <input type="password" class="form-control" id="Password" name="password" placeholder="*******">
        </div>
            
            <div class="row mt-3 text-center">
        <div class="col-md-6">
            <button type="submit" class="btn btn-success text-center" >Save</button>

        </div>

        <div class="col-md-6">
            <button type="reset" class="btn btn-danger text-center" >Reset</button>

        </div>
    </div>
            
        </div>
        
   
        <%@include file="footer.jsp" %>