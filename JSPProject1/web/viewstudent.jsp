<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>
<%@page import="model.Student" %>
<%@page import="dao.StudentDao" %>

<%
    List<Student> list = StudentDao.viewStd();
    request.setAttribute("list", list);
%>

<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Email</th> 
            <th>Action</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="s" items="${list}">
            <tr>
                <td>${s.getId()}</td>
                <td>${s.getName()}</td>                
                <td>${s.getAddress()}</td>
                <td>${s.getEmail()}</td>
                <td>
                    <a href="updatestudent.jsp?id=${s.getId()}">Edit</a>
                    <a href="deletestudent.jsp?id=${s.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>   
</table>
