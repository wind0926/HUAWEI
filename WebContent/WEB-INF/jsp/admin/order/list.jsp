<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
	</HEAD>
	<script type="text/javascript">
		//给订单详情按钮绑定点击事件
		$(function() {
			//页面加载完毕,给订单详情按钮绑定点击事件
			$(".info").click(function() {
				
				var oid = this.getAttribute("oid")
				//当按钮被点击的时候，给服务器发送一个异步请求------>请求该订单的所有订单项信息
				var content = "<table border='1' cellspacing='0' width='100%' align='center'><tr><th>商品图片</th><th>商品名称</th><th>购买数量</th></tr>"
				$.getJSON("${pageContext.request.contextPath}/adminOrder",{"methodStr":"detail","oid":oid},function(result){
					//result就是响应的json数据
					//遍历result，每遍历出来一个数据就往content中添加一个tr
					$(result).each(function(index,element) {
						content += "<tr><td><img width='50px' height='50px' src='${pageContext.request.contextPath}/"+element.product.pimage+"' /></td><td>"+element.product.pname+"</td><td>"+element.count+"</td></tr>"
					})
					
					//最后还要拼接一个"</table>"
					content += "</table>"
					layer.open({
						type: 1,//0:信息框; 1:页面; 2:iframe层;	3:加载层;	4:tip层
				        title:"订单详情",//标题
				        area: ['400px', '200px'],//大小
				        shadeClose: true, //点击弹层外区域 遮罩关闭
				        content: content//弹框里面的内容
					})
				})
			})
		})
	</script>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单列表</strong>
						</TD>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="10%">
										序号
									</td>
									<td align="center" width="10%">
										订单编号
									</td>
									<td align="center" width="10%">
										订单金额
									</td>
									<td align="center" width="10%">
										收货人
									</td>
									<td align="center" width="10%">
										订单状态
									</td>
									<td align="center" width="50%">
										订单详情
									</td>
								</tr>
								<c:forEach items="${page.list }" var="o" varStatus="vs">
										<tr>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												${vs.count }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${o.oid }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
													${o.total }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												${o.name }
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<c:if test="${o.state == 0}">
													未付款
												</c:if>
												<c:if test="${o.state == 1 }">
													<a href="${pageContext.request.contextPath }/adminOrder?methodStr=update&oid=${o.oid}">去发货</a>
												</c:if>
												<c:if test="${o.state == 2 }">
													等待确认收货
												</c:if>
												<c:if test="${o.state== 3 }">
													订单完成
												</c:if>
											
											</td>
											<td align="center" style="HEIGHT: 22px">
												<input class="info" type="button" value="订单详情" oid='${o.oid }'/>
											</td>
										</tr>
									</c:forEach>
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
			<div style="text-align: center;">
						<ul class="pagination">
							<c:if test="${page.curPage != 1 }">
								<li><a href="${pageContext.request.contextPath }/adminOrder?methodStr=page&curPage=${page.curPage - 1}&state=${param.state}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
							</c:if>
							
							<c:forEach begin="1" end="${page.totalPage }" var="i">
								<c:if test="${page.curPage == i }">
									<li class="active"><a>${i }</a></li>
								</c:if>
								
								<c:if test="${page.curPage != i }">
									<li><a href="${pageContext.request.contextPath }/adminOrder?methodStr=page&curPage=${i}&state=${param.state}">${i }</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${page.curPage != page.totalPage }">
								<li>
									<a href="${pageContext.request.contextPath }/adminOrder?methodStr=page&curPage=${page.curPage + 1}&state=${param.state}" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</c:if>
					</ul>
				</div>
		</form>
	</body>
</HTML>

