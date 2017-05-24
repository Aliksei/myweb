<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Welcome</title></head>
<body>
<h3>Welcome</h3>
<hr/>
${user} , hello . Your session id  = [ ${session_id} ]

<table style="width:50%">
 <caption>Available films</caption>
    <tr>
        <th>FilmName</th>
        <th>Price</th>
        <th></th>
    </tr>
    <tr>
        <form method="POST">
            <td>First film</td>
            <input type="hidden" name="filmName" value="Terminator" />
            <td>12$</td>
            <input type="hidden" name="price" value="12" />
            <td><input type=submit value="buy"></td>
            <input type="hidden" name="command" value="buy" />
         </form>
    </tr>

     <tr>
            <form method="POST">
                <td>Second film</td>
                <input type="hidden" name="filmName" value="Lord of the Rings" />
                <td>10$</td>
                <input type="hidden" name="price" value="10" />
                <td><input type=submit value="buy"></td>
                <input type="hidden" name="command" value="buy"/>
             </form>
     </tr>

</table

<b>Tickets that you alredy have:</b>

<table>
 <c:forEach var="elem" items="${tickets}">
<tr>
 <td>Film ---  <c:out value="${ elem.filmName }" /></td>
</tr>
 </c:forEach>
</table>

<hr/>
<a href="controller?command=logout">Logout</a>
</body></html>