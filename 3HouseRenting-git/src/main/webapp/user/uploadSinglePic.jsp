<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.yc.utils.*,java.util.*"%>
<%

FileUpLoad fu=new FileUpLoad();
Map<String,String> map=fu.uploadFiles(pageContext, request);
//取出回调函数  json技术
response.setContentType("text/html;charset=UTF-8");

//function show()  因为CKEditorFuncNum参数是在地址栏中，即以GET的方式传到服务器中，所以可以使用 HTTPServletRequest来接收
String callback=request.getParameter("CKEditorFuncNum");

//将结果以客户端指定的函数的形式，以JavaScript代码写到客户端去，这样客户端的浏览器的js引擎就可以运行
out.println("<script type=\"javascript\">");
out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + map.get("upload_weburl") + "','')");
out.println("</script>");
out.flush();

%>















