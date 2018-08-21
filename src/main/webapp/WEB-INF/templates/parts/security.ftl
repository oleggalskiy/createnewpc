<#assign
known = Session.checkSessionExistence()
>

<#if known>
    <#assign
    user = Session.get("user")
    name = user.getUsername()
    isAdmin = user.isAdmin()
    >
<#else>
    <#assign
    name = "guest"
    isAdmin = false
    >
</#if>