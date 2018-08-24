<#include "security.ftl">
<#import "login.ftl" as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/Controller?command=hello_page">createmypc</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/Controller?command=hello_page">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/Controller?command=main_page">Main Page</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/Controller?command=reg_page">Reg Page</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/Controller?command=profile_page">User Page</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/Controller?command=userlist_page">Users Edit Page</a>
            </li>
        </ul>
        <div class = "navbar-text mr-3">"${name}"</div>
         <@l.logout />
    </div>
</nav>