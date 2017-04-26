<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Registration</title></head>
<body>

    <b>Hello, please create unique login and password</b>

    <form name="registrationForm" method="POST" action="controller">

        <input type="hidden" name="command" value="register" /> Login: <br/>

        <input type="text" name="login" value=""/> <br/>Password: <br/>

        <input type="password" name="password" value=""/>

        <br/>
            ${errorMessagePassMessage}
        <br/>
            ${wrongAction}
        <br/>
            ${nullPage}
        <br/>

     <input type="submit" value="Continue....."/>
    </form>
<hr/>

</body></html>