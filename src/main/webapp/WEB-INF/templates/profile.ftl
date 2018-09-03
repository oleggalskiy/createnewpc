<#import "parts/common.ftl" as c>
<@c.page>
<h2>User Editor</h2>

 <form>
        <div class="form-group row">
            <label class="col-sm-1 col-form-label" for="inputLogin">Login</label>
            <div id="inputLogin" class="form-group col-md-4">
                <input type="text" class="form-control" id="inputLogin2" value="${user.getUsername()}" readonly>
            </div>
        </div>
 </form>
    <form>
        <div class="form-group row">
            <label class="col-sm-1 col-form-label mt-4" for="inputName">Name</label>
            <div id="inputName" class="form-group col-md-4">
                <label for="inputName1">Present Value</label>
                <div id="inputName1">
                    <input type="text" class="form-control" value="${user.getFirstName()}" readonly>
                </div>
            </div>
            <div class="form-group col-md-4">
                <label for="inputName2">New Value</label>
                <div id="inputName2">
                    <input type="text" class="form-control"  placeholder="New name" value="">
                </div>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-1 col-form-label" for="inputSurname">Surname</label>
            <div id="inputSurname" class="form-group col-md-4">
                <input type="text" class= "form-control" value="${user.getSurname()}" readonly>
            </div>
            <div class="form-group col-md-4">
                <input type="text" class="form-control"  placeholder="New surname" value="">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-1 col-form-label" for="inputAge">Age</label>
            <div id="inputAge" class="form-group col-md-4">
                <input type="text" class="form-control" value="${user.getAge()}" readonly>
            </div>
            <div class="form-group col-md-4">
                <input type="text" class="form-control"  placeholder="New age" value="">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-1 col-form-label" for="inputAddress">Address</label>
            <div id="inputAddress" class="form-group col-md-4">
                <input type="text" class="form-control" value="${user.getAddress()}" readonly>
            </div>
            <div class="form-group col-md-4">
                <input type="text" class="form-control"  placeholder="New address" value="">
            </div>
        </div>
       <div class="form-group row">
            <label class="col-sm-1 col-form-label" for="inputEmail">Email</label>
            <div id="inputEmail" class="form-group col-md-4">
                <input type="email" class="form-control" value="${user.getEmail()}" readonly>
       </div>
            <div class="form-group col-md-4">
                <input type="email" class="form-control"  placeholder="New email" value="">
            </div>
        </div>

    </form>



</@c.page>
