<#macro login path isRegistredForm>
<form action="${path}" method="post" xmlns="http://www.w3.org/1999/html">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">User Name:</label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" placeholder="User name"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password"/></div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Email:</label>
        <div class="col-sm-6">
            <input type="text" name="email" class="form-control" placeholder="Email"/></div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">First name:</label>
        <div class="col-sm-6">
            <input type="text" name="firstname" class="form-control" placeholder="First name"/></div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Surname:</label>
        <div class="col-sm-6">
            <input type="text" name="surname" class="form-control" placeholder="Surname"/></div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Age:</label>
        <div class="col-sm-6">
            <input type="text" name="age" class="form-control" placeholder="Age"/></div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Address:</label>
        <div class="col-sm-6">
            <input type="text" name="address" class="form-control" placeholder="Address"/></div>
    </div>
    <button class="btn btn-primary" type="submit">Create</button>
</form>
</#macro>
<#macro logout>
<div>
    <form action="" method="post">
        <button class="btn btn-primary" type="submit">Sign Out</button>
    </form>
</div>
</#macro>