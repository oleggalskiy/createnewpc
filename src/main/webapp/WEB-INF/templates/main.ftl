<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#include "parts/security.ftl">


<@c.page>
<#if !Session.user??>
    <@l.login/>
</#if>
<#if Session.user??>
<h2>List of pc</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>CREATION DATE</th>
        <th>Author</th>
        <th>isActive</th>
    </tr>
    </thead>
    <tbody>
<#list pcList?if_exists as pc>
<tr>
    <td>${pc.idPC}</td>
    <td>${pc.date}</td>
    <td>${pc.author.username}</td>
    <td>${pc.active?string("Yes","No")}</td>
</tr>
</#list>
    </tbody>
</table>
</#if>


</@c.page>