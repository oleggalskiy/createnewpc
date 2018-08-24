<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>


<@c.page>
<h2 class="mb-1">Add new User</h2>
    ${message?ifExists}
    <@l.login "/Controller?command=reg_user" true/>
</@c.page>
