<#assign
known = Session.user??

>

<#if known>
    <#assign
    user = Session.user
    name = user.getUsername()
   <#-- isAdmin = user.isAdmin()-->
    >
<#else>
    <#assign
    name = "guest"
    isAdmin = false
    >
</#if>