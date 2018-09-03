<#macro regForm>
<form action="/Controller?command=reg_user" method="post" xmlns="http://www.w3.org/1999/html">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">User Name:</label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" placeholder="User name"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password"/>
        </div>
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
    <#if errorMessages??>
        <#list errorMessages as message>
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong>${message.errorText}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        </#list>
    </#if>
    <button class="btn btn-primary" type="submit">Registration</button>
</form>
</#macro>
<#macro login>
<form action="/Controller?command=check_user" method="post" xmlns="http://www.w3.org/1999/html">
    <div class="form-group" >
        <label for="inputLogin">Login</label>
        <input type="text" name="login" class="form-control mb-2 mr-sm-2" id="inputLogin"  placeholder="Enter login" required>

    </div>
    <div class="form-group">
        <label for="inputPassword">Password</label>
        <input type="password" name="password" class="form-control mb-2 mr-sm-2" id="inputPassword" aria-describedby="passwordHelp" placeholder="Password" required>
        <small id="passwordHelp" class="form-text text-muted">We'll never share your login with anyone else.</small>

    </div>
    <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <#if errorMessages??>
        <#list errorMessages as message>
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong>${message.errorText}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        </#list>
    </#if>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

</#macro>

<#macro logout>
<div>
    <form action="/Controller?command=log_out" method="post">
        <button class="btn btn-primary" type="submit">Sign Out</button>
    </form>
</div>
</#macro>