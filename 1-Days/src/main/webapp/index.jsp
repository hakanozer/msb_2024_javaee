<%@ page import="com.works.days1.services.LoginService" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    boolean error = false;
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    if (email != null  && password != null) {
        LoginService loginService = new LoginService();
        boolean status = loginService.userLogin(email, password);
        if (status) {
            System.out.println("Login Status:" + status);
            response.sendRedirect("dashboard.jsp");
        }else {
            error = true;
        }
    }
    String[] arr = {"İstanbul", "Ankara", "İzmir", "Antalya"};
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <h2>User Login</h2>
            <c:if test="<%=error%>">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>Error!</strong> E-Mail or Passwod Fail
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <form action="index.jsp" method="post">
                <div class="mb-3">
                    <input required type="email" placeholder="E-Mail" class="form-control" name="email" />
                </div>
                <div class="mb-3">
                    <input required type="password" placeholder="Password" class="form-control" name="password" />
                </div>
                <button class="btn btn-danger">Send</button>
            </form>
        </div>
        <div class="col-sm-4"></div>
    </div>




<h1><%= "Hello World!" %>
</h1>
<div> <c:out value="Hello JSTL"></c:out> </div>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<% for(String item : arr) { %>
    <h1><%=item%></h1>
<% } %>
<hr/>

<c:forEach items="<%=arr%>" var="item">
    <h1><c:out value="${item}"></c:out></h1>
</c:forEach>

</div>
</body>
</html>