<jsp:useBean class="model.Employee" id="e"/>
<%@page  import="dao.EmployeeDao" %>
<jsp:setProperty name="e" property="*" />

<%
TeacherDao.updateEmployee(e);
response.sendRedirect("success.jsp");

%>
