<#import "parts/common.ftl" as c>
<#import "parts/carousel.ftl" as crs>
<@c.page>
<@crs.carousel/>
<h2>List of pc</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>CREATION DATE</th>
        <th>Author</th>
    </tr>
    </thead>
    <tbody>
<#list pcList as pc>
<tr>
    <td>${pc.idPC}</td>
    <td>${pc.date}</td>
    <td>${pc.username.username}</td>
</tr>
</#list>
    </tbody>
</table>


</@c.page>