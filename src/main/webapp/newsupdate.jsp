<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改新闻</title>
    <script charset="utf-8" src="<c:url value="kindeditor/kindeditor-all-min.js"/>"></script>
	<script charset="utf-8" src="<c:url value="kindeditor/zh_CN.js"/>"></script>
    <script type="text/javascript" src="kindeditor/kindeditor.js"></script>
    <script type="text/javascript" >
    	KindEditor.ready(function(K) {
    			K.create('#content_1', {
    				uploadJson : 'kindeditor/jsp/upload_json.jsp',
    				fileManagerJson:'kindeditor/jsp/file_manager_json.jsp',
    				allowFileManager : true
    			});
    		});
    </script>
    
  </head>
  
  <body>
    <form action="NewsServlet" method="post" >
    	<input type="hidden" value="${news.newsId}" name="id"/>
    	<input type="hidden" name="oprate" value="updatenews"/>
    	<input type="text" name="newstitle" value="${news.newstitle}" placeholder="请输入标题"/><br/>
    	新闻栏目
    	<select name = "newstype">

    		<option <c:if test="${news.newsType==\"html\"}">selected</c:if> value = "html">html</option>
    		<option <c:if test="${news.newsType==\"Javascript\"}">selected</c:if> value = "Javascript">Javascript</option>
    		<option <c:if test="${news.newsType==\"oracle\"}">selected</c:if> value = "oracle">oracle</option> 
    	</select>
    	<br/>
			<textarea id="content_1" name="newscontent" style="width:700px;height:300px;">${news.newsContent}
			</textarea>
   			<input type = "submit" value = "确定修改"/>
    </form>
  </body>
</html>