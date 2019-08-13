<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仿华为商城</title>
</head>
<body>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		//当文档加载完毕的时候发起异步的请求获取到所有分类的json字符串
		$(function() {
			$.getJSON("${pageContext.request.contextPath }/findAllCategory.action",function(result){
				//遍历result
				$(result).each(function(index,element) {
					//index是索引，element就是遍历出来的每一个元素
					$("#ct").append("<li><a href='${pageContext.request.contextPath}/listProductByCategory.action?curPage=1&cid="+element.cid+"'>"+element.cname+"</a></li>")
				})
			})
		})
	</script>
	<div class="container-fluid">
		<div class="col-md-4">
			<img src="${pageContext.request.contextPath}/img/zqq.png" />
		</div>
		<div class="col-md-5">
			<img src="${pageContext.request.contextPath}/img/header.png" />
		</div>
		<div class="col-md-3" style="padding-top:20px">
			<ol class="list-inline">
				<%--如果未登录，则显示登录和注册按钮 --%>
				<c:if test="${empty user}">
					<li><a href="${pageContext.request.contextPath }/login.action">登录</a></li>
					<li><a href="${pageContext.request.contextPath }/regist.action">注册</a></li>
					<li><a href="${pageContext.request.contextPath }">购物车</a></li>
				</c:if>
				
				<%--如果已登录，则显示欢迎语句，并且有购物车、订单、注销等按钮 --%>
				<c:if test="${not empty user}">
					<li>欢迎${user.name }登录</li>
					<li><a href="${pageContext.request.contextPath }/car/showCar.action">购物车</a></li>
					<li><a href="${pageContext.request.contextPath }/order?methodStr=page&curPage=1">订单</a></li>
					<li><a href="${pageContext.request.contextPath }/logout.action">注销</a></li>
				</c:if>
			</ol>
		</div>
	</div>
	<!--
          	时间：2018-12-30
          	描述：导航条
          -->
	<div class="container-fluid">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${pageContext.request.contextPath }/index.action">首页</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav" id="ct">
						
					</ul>
					<form class="navbar-form navbar-right" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>

				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>
</body>
</html>