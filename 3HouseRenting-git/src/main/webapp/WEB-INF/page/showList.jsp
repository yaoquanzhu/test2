<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ page import="com.yc.web.model.*,java.util.*,com.yc.bean.*" %>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
function del(id,pages){
	var r=window.confirm("您确定要删除编号为："+id+"的记录吗?");
	//alert(r);
	if(r==true){
		$.ajax({
		      type:'POST',
					url:"user/house_del.action",
					data:"id="+id,
					dataType:"json",
					success:function(data){
						alert(data);
						goPages(pages);
					}
				});
	}
	
}

/* function update(id,pages){
	alert("修改？");
	location.href="user/house_toUpdate.action?id="+id;
}  */

</script>

		<table class="house-list">

			 <c:forEach items="${ jsonModel.rows}"  var="v">
				<tr>
					<td class="house-thumb">
						<span> 
							 <a href="page/show.jsp?id=10001"> 
							  <img src="images/thumb_house.gif" />
							 </a>
						</span>
					</td>
					
					<td>
						<dl>
							<dt>
								<a href="house_detail.action/${v.id}">${v.title }</a>
							</dt>
							<dd>
							 	${v.description } ${v.type.id }  ${ user.id} ${v.user.id}  
							</dd>
							<dd>
							  housetypeid:${v.type.id }    
							</dd>
						</dl>
					</td>
					
					<c:if test="${user.id==v.user.id }"> 
							<td class="house-type">
								<label class="ui-green">
									<input type="button" onclick='update(${v.id},${jsonModel.pages })' value="修    改" />
								</label>
					    </td>
							<td class="house-price">
								<label class="ui-green">
										<input	type="button" onclick='del(${v.id},${jsonModel.pages })' value="删    除" />
								</label>
							</td>
				 	</c:if> 
						<c:if test="${ user.id != v.user.id}">
								<td class="house-type" colspan="2"></td>
						</c:if>
					
				</tr>
			
			</c:forEach>
	</table>		





<div class="pager">
	<ul>
		<li class="current">
				<a href="javascript:goPages(1)" >首页</a>
		</li>
		<%
	    JsonModel jsonModel=(JsonModel)request.getAttribute("jsonModel");
	    int pages=jsonModel.getPages();
	    int total=jsonModel.getTotal();
	    int pagesize=jsonModel.getPagesize();
	    int totalPages=   total%pagesize==0?total/pagesize:total/pagesize+1;
	    int prepage=pages;
	    if(pages>1){
	    	prepage=pages-1;
	    }
	    int nextpage=totalPages;
	    if( pages<totalPages){
	    	nextpage=pages+1;
	    }
		%>
		<li class="current">
		    <a href="javascript:goPages(<%=prepage %>)" >上一页</a> 
		</li>
		<li class="current">
		   <a href="javascript:goPages(<%=nextpage %>)" >下一页</a> 
		</li>
		<li class="current">
		    <a href="javascript:goPages(<%=totalPages %>)" >尾页</a> 
		</li>
	</ul>
	<span class="total">第<%=pages %>页/共<%=totalPages %>頁 记录总数：<%=total%>条 每页显示<%=pagesize %>条</span>
</div>

