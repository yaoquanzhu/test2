<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="header.jsp" %> 
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<script src="ckeditor/ckeditor.js"></script>


<div id="regLogin" class="wrap">
		<div class="dialog">
			<dl class="clearfix">
				<dt>新房屋信息发布</dt>
				<dd class="past">填写房屋信息</dd>

			</dl>
			<div class="box">
				<form id="House_add_action" name="House_add_action" action="user/house_doAdd.action" method="post">
					<div class="infos">
						<table class="field">
							<tr>
								<td class="field">标 题：</td>
								<td>
									<input type="text" name="title" value="" id="House_add_action_title" class="text"/>
								</td>
							</tr>
							<tr>
								<td class="field">户 型：</td>
									<td>
									<select class="text" name="type.id" id="houseType">
												<%-- <c:forEach items="${houseTypeList }" var="houseType">
									  				<option value="${houseType.id }">${houseType.name}</option>
									  		</c:forEach>	 --%>						
										</select> 
									</td>
							</tr>
							<tr>
								<td class="field">面 积：</td>
								<td><input type="text" name="floorage" value="" id="House_add_action_floorage" class="text"/></td>
							</tr>
							<tr>
								<td class="field">价 格：</td>
								<td><input type="text" name="price" value="" id="House_add_action_price" class="text"/></td>
							</tr>

							<!-- <tr>
								<td class="field">房产证日期：</td>
								<td><input type="text" class="text" name="pubDate" value="" id="House_add_action_pubDate"/></td>
							</tr> -->

							<tr>
								<td class="field">位 置：</td>
								<td>区：
									  <select class="text" name="district.id" id="houseDistrict" onchange="onchangeDistrict(this.value)">
									  	<%-- <c:forEach items="${districtList }" var="district">
									  				<option value="${district.id }">${district.name}</option>
									  		</c:forEach>  --%>
									  </select> 
								         
								         
								         街：
								     <select class="text" name="street.id" id="houseStreet">
								         
								     </select>
								</td>
							</tr>
							<tr>
								<td class="field">联系方式：</td>
								<td><input type="text" name="contact" value="" id="House_add_action_contact" class="text"/></td>
							</tr>
							<tr>
								<td class="field">详细信息：</td>
								<td>
										<textarea class="ckeditor" name="description"></textarea>
								</td>
							</tr>
						</table>
						<div class="buttons">
							<input type="submit" id="House_add_action_0" value="立即发布"/>

						</div>
					</div>
				</form>




			</div>
		</div>
	</div>

<script type="text/javascript">

 $.getJSON("houseType.action",function(data){
  var obj=data.obj;
	for ( var i = 0; i < obj.length; i++)
	{
		$("#houseType").append("<option value='" + obj[i].id + "'>" + obj[i].name+obj[i].id + "</option>");  
	}
})
 
 $.getJSON("houseDistrict.action",function(data){
  var obj=data.obj;
  for ( var i = 0; i < obj.length; i++)
	{
		$("#houseDistrict").append("<option value='" + obj[i].id + "'>" + obj[i].name +obj[i].id+ "</option>");  
	}
}) 
 

   function onchangeDistrict(obj){
	   var districtid=obj;
	  // alert("obj");
	   $.ajax({
		   url:"street_list.action",
		   tyype:"POST",
		   data:"id="+districtid,
		   dataType:"JSON",
		   success:function(data){
			   //alert(data);
			   var str="";
			   var length=data.rows.length;
			   for( var i=0;i<length;i++){
				   var street=data.rows[i];
				   //alert("street");
				   str+='<option value="'+street.id+'">'+street.name+street.id+'</option>';
			   }
			   $("#houseStreet").html(str)
		   }
	   });
   }


</script>



<%@ include file="bottom.jsp" %> 