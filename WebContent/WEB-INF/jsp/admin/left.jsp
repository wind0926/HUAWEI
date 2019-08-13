<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">
	
		d = new dTree('d');
		d.add('01',-1,'系统菜单树');//添加根节点，第一个参数表示添加的节点的"id",第二个参数表示"父节点的id"，第三个参数表示添加的节点的"文字描述"
		
		d.add('0101','01','分类管理','','','');
		//第四个参数表示，当点击这个节点的时候跳转的路径，第五个参数表示当鼠标悬停在这个节点上的时候显示的文字,第六个参数表示在哪里打开新页面
		
		d.add('010101','0101','所有分类','${pageContext.request.contextPath}/admin/listCategory.action','','mainFrame');
		d.add('010102','0101','添加分类','${pageContext.request.contextPath}/admin/addCategory.action','','mainFrame');
		
		
		d.add('0102','01','商品管理','','','');
		d.add('010201','0102','所有商品','${pageContext.request.contextPath}/admin/listProduct.action?curPage=1','','mainFrame');
		d.add('010202','0102','添加商品','${pageContext.request.contextPath}/admin/showAddProduct.action','','mainFrame');
		
		d.add('0103','01','订单管理','','','');
		d.add('010301','0103','所有订单','${pageContext.request.contextPath}/admin/listOrder?methodStr=page&curPage=1','','mainFrame');
		d.add('010302','0103','未付款订单','${pageContext.request.contextPath}/adminOrder?methodStr=page&curPage=1&state=0','','mainFrame');
		d.add('010303','0103','已付款订单','${pageContext.request.contextPath}/adminOrder?methodStr=page&curPage=1&state=1','','mainFrame');
		d.add('010304','0103','已发货订单','${pageContext.request.contextPath}/adminOrder?methodStr=page&curPage=1&state=2','','mainFrame');
		d.add('010305','0103','已完成订单','${pageContext.request.contextPath}/adminOrder?methodStr=page&curPage=1&state=3','','mainFrame');
		document.write(d);
		
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
