<#import "parts/common.ftl" as c>

<@c.page>
<h2>List of users</h2>
<table>
    <thead>
    <tr>
        <th>Login</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
<#list usersList as users>
    <tr>
        <td>${users.username}</td>
        <td>${users.age}</td>
        <td>${users.address}</td>
        <td>${users.email}</td>
    </tr>
</#list>
    </tbody>
</table>
</@c.page>