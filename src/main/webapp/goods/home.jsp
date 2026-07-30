<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row{
   margin: 0px auto;
   width: 960px;
}
p {
   overflow: hidden;
   white-space: nowrap;
   text-overflow: ellipsis;
}
</style>
</head>
<body>
 <div class="container">
    <div class="row">
      <c:forEach var="vo" items="${list}">
      <div class="col-sm-3">      
        <div class="thumbnail">
          <a href="../goods/detail.do?no=${vo.no}">
          <img src="${vo.goods_poster}" title="${vo.goods_sub}" style="width: 250px;height: 130px;object-fit:cover">
          <p>${vo.goods_name}</p>
          </a>
        </div>
      </div>
      </c:forEach>
    </div>
    <div class="row text-center" style="margin-top: 10px">
      <ul class="pagination">
       <c:if test="${startPage>1}">
        <li><a href="../goods/main.do?page=${startPage-1}">&laquo;</a></li>
       </c:if>
       <c:forEach var="i" begin="${startPage}" end="${endPage}">
        <li ${i==curpage?"class=active":""}><a href="../goods/main.do?page=${i}">${i}</a></li>
       </c:forEach>        
       <c:if test="${endPage<totalpage }">
        <li><a href="../goods/main.do?page=${endPage+1}">&raquo;</a></li>
       </c:if>
      </ul>
    </div>
</body>
</html>