<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加新闻</title>
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
    	<input type="hidden" name="oprate" value="addnews"/>
    	<input type="text" name="newstitle" placeholder="请输入标题"/><br/>
    	新闻栏目
    	<select name = "newstype">
    		<option value = "html">html</option>
    		<option value = "Javascript">Javascript</option>
    		<option value = "oracle"> oracle</option> 
    	</select>
    	<br/>
			<textarea id="content_1" name="newscontent" style="width:700px;height:300px;"></textarea>
   			<input type = "submit" value = "添加"/>
    </form>
  </body>
</html>