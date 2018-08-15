<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %> 

<script type="text/javascript">

 	$(function(){
		goPages(1);
	})
 /* data:{pages:1,pagesize:10},	data:"pages="+pages+"pagesize=10"}, */
 	function goPages(pages){
 		$.ajax({
 		      type:'POST',
 					url:"house_list.action",
 					data:"pages="+pages+"&pagesize=10",
 					dataType:"html",
 					success:function(data){
 						$("#houseArea").html(data);
 					}
 				});
 	}
	

</script>

<c:if test="${user!=null}">
	<script>
			function add(){
				document.location="user/house_toAdd.action";
			}
</script>


<script>
			function update(id,pages){
				alert("修改？");
				location.href="user/house_toUpdate.action?id="+id;
			}
</script>

	<div class="search">
				<label class="ui-green">
					<input onclick="add()" type="button" name="search" value="发布房屋信息" />
				</label> 
				<label class="ui-green">
					<input type="button" name="search" value="退       出" 
					       onclick='document.location="user/user_logout.action"' />
				</label>
	</div>
</c:if>


<div class="main wrap">
		<div id="houseArea">
		
		</div>
</div>



<%@ include file="bottom.jsp" %>  