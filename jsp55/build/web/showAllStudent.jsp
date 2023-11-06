<%@include file="header.jsp" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  import="model.Student"%>
<%@page  import="dao.StudentDao"%>
<%@page  import="java.util.*"%>


<%  
    List<Student> list=StudentDao.getAllStudent();
    request.setAttribute("list", list);
    
int counter=1; 

for(Student student: list){
student.setSequence(counter++);
}
    
%>  




<div class="container my-3 py-2">
    <div class="bg-success text-center">
        <h1 class="jumborton">Add Student</h1>
    </div>

    <table class="table table-striped mb-3">
        <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Subject</th>
                <th scope="col">Gender</th>
                <th scope="col">Action</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${list}" var="s">
                <tr>
                    <td>${s.getSequence()}</td>
                    <td>${s.getFirstName()}</td>
                    <td>${s.getLastName()}</td>
                    <td>${s.getGender()}</td>
                    <td>${s.getSubject()}</td>
                    <td>
                        <a class="btn btn-primary" href="editForm.jsp?Sid=${s.getId()}">Edit</a>
                        <a  class="btn btn-warning" href="delete.jsp?id=${s.getId()}">Delete</a>
                    </td>

                </tr>               
            </c:forEach>            
        </tbody>

    </table>

</div>

<div class="mb-3">

</div>


<%@include file="footer.jsp" %>
