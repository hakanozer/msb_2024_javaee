<%@ page import="com.works.servletapp.services.ProductService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.works.servletapp.entities.Product" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ProductService productService = new ProductService();
    List<Product> ls = productService.allProduct();
 %>
<html>
<head>
    <jsp:include page="inc/header.jsp" />
    <title>Product</title>
</head>
<body>
  <div class="container">
      <jsp:include page="inc/navbar.jsp" />
      <h2>Product</h2>
      <div class="row">
          <div class="col-sm-4">
              <h3>Add</h3>
              <form action="/product" method="post">
                  <div class="mb-3">
                      <input name="title" class="form-control" placeholder="Title" />
                  </div>
                  <div class="mb-3">
                      <input type="number" name="price" class="form-control" placeholder="Price" />
                  </div>
                  <div class="mb-3">
                      <input name="detail" class="form-control" placeholder="Detail" />
                  </div>
                  <button class="btn btn-success">Send</button>
              </form>
          </div>
          <div class="col-sm-8">
              <h3>List</h3>
              <table class="table table-hover">
                  <thead>
                  <tr>
                      <th scope="col">#ID</th>
                      <th scope="col">Title</th>
                      <th scope="col">Price</th>
                      <th scope="col">Detail</th>
                      <th scope="col">Delete</th>
                  </tr>
                  </thead>
                  <tbody>

                  <c:forEach items="<%=ls%>" var="item">
                      <tr>
                          <th scope="row">${item.pid}</th>
                          <td>${item.title}</td>
                          <td>${item.price}</td>
                          <td>${item.detail}</td>
                          <td>
                              <button class="btn btn-danger btn-sm">Delete</button>
                          </td>
                      </tr>
                  </c:forEach>

                  </tbody>
              </table>
          </div>
      </div>
  </div>
</body>
</html>
