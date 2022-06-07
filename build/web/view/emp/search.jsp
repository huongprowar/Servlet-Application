<%-- 
    Document   : search
    Created on : Jun 2, 2022, 10:36:05 AM
    Author     : Ngo Tung Son
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="search" method="POST">
            Department:<select name="did">
                <c:forEach items="${requestScope.depts}" var="d">
                    <option 
                        <c:if test="${param.did eq d.id}">selected="selected"</c:if>
                        value="${d.id}">${d.name}</option>
                </c:forEach>
            </select> <br/>
            <input type="submit" value="Search" /> 
        </form>
        <br/>
        <c:if test="${requestScope.emps ne null}">
            <table>
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Gender</td>
                    <td>Dob</td>
                    <td>Department</td>
                </tr>
                <c:forEach items="${requestScope.emps}" var="e">
                    <tr>
                        <td>${e.id}</td>
                        <td>${e.name}</td>
                        <td>${e.gender}</td>
                        <td>${e.dob}</td>
                        <td>${e.dept.name}</td>
                    </tr>   
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
