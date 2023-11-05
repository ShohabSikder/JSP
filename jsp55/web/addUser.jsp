<jsp:useBean class="model.User"  id="u" />
<%@page  import="dao.UserDao" %>
<jsp:setProperty  name="u" property="*" />

<% 
int result=UserDao.saveUser(u);

if(result>0){
    response.sendRedirect("success.jsp");
    
    }
    else{
    
    response.sendRedirect("error.jsp");
    
    }


%>
