<%@include file="header.jsp" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.User" %>
<%@page import="dao.UserDao" %>
<%@page import="java.util.*" %>

<%
List<User> userList=UserDao.getAllUser();
request.setAttribute("userList",userList);

//int counter=1;
//for(User u:userList){
//    u.setSequence(counter++);
//    }

%>

<div class="container my-3 py-2">
    <div class="bg-success text-center">
        <h1 class="jumborton">View All User</h1>
    </div>
    
    <table class="table table-striped mb-3">
        <thead>
            <tr>
                <th scope="col">UID</th>
                <th scope="col">Full Name</th>
                <th scope="col">User Name</th>
                <th scope="col">Password</th>
                <th scope="col">Email</th>
                <th scope="col">Action</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${userList}" var="u">
                <tr>
                    <td>${u.getUid()}</td>
                    <td>${u.getFullName()}</td>
                    <td>${u.getUserName()}</td>
                    <td>${u.getPassword()}</td>
                    <td>${u.getEmail()}</td>
                    <td>
                        <a class="btn btn-primary" href="">Edit</a>
                        <a  class="btn btn-warning" href="deleteUser.jsp?=${u.getUid()}">Delete</a>
                    </td>

                </tr>               
            </c:forEach>            
        </tbody>

    </table>