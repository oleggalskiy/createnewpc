<#import "parts/common.ftl" as c>

<@c.page>
<h2>List of users</h2>
<table>
    <thead>
    <tr>
        <th>Login</th>
        <th>Email</th>
        <th>IsActive</th>
        <th>Role</th>

    </tr>
    </thead>
    <tbody>
<#list usersList as users>
    <tr>
        <td>${users.username}</td>
        <td>${users.email}</td>
        <td>${users.active?string("Yes","No")}</td>
        <td><#list users.roles as role>${role}<#sep>,</#list></td>

    </tr>
</#list>
    </tbody>
</table>
</@c.page>