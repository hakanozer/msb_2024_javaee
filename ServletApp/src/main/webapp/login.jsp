<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  boolean errorStatus = false;
  Object errorObj = request.getParameter("error");
  if (errorObj != null) {
    errorStatus = true;
  }
%>
<!doctype html>
<html lang="tr">
<head>
  <jsp:include page="inc/header.jsp" />
  <title>Login</title>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <h2>User Login</h2>
        <c:if test="<%=errorStatus %>" >
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong>Error!</strong> E-Mail or Passwod Fail
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
          </div>
        </c:if>
        <form action="/" method="post">
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
  </div>
</body>
</html>
