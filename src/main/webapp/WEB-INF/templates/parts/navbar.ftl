<#include "security.ftl">
<#import "login.ftl" as l>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
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
    <#if Session.user??>
            <li class="nav-item">
                <a class="nav-link" href="/Controller?command=profile_page">User Page</a>
            </li>
    </#if>
    <#if isAdmin= true >
            <li class="nav-item">
                <a class="nav-link" href="/Controller?command=userlist_page">Users Edit Page</a>
            </li>
    </#if>

        </ul>
        <div class = "navbar-text mr-3">${name}</div>
         <@l.logout />
    </div>
</nav>