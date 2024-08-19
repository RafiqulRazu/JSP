<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="saveemployee.jsp" method="post">
            Name: <input type="text" name="name"> <br>
            Address: <input type="text" name="address"> <br>
            Email: <input type="email" name="email"> <br>
            
            <input type="submit" value="Save">
        </form>
    </body>
</html>