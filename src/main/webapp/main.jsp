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
        <th>Number of Tickets</th>
        <th></th>
    </tr>
    <tr>
        <form method="POST">
            <td>Second film</td>
            <td><input type="text" name="numberOfTickets" value="0" size="5"></td>
            <td><input type=submit value="buy"></td>
            <input type="hidden" name="command" value="buy" />
         </form>
    </tr>

     <tr>
            <form method="POST">
                <td>Second film</td>
                <td><input type="text" name="numberOfTickets" value="0" size="5"></td>
                <td><input type=submit value="buy"></td>
                <input type="hidden" name="command" value="buy"/>
             </form>
     </tr>

</table

Ваши билеты :

<hr/>
<a href="controller?command=logout">Logout</a>
</body></html>