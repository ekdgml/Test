$(document).ready(function(){
	$("button[name=show_btn]").click(function(){
		//
		var btn = this;
		$.ajax({
			"url" : ctx + "/detail",
			"data" : {"name" : $(this).data("name")},
			"type" : "get",
			"dataType" : "json",
			"success" : function(data) {
				//
				// data = {name:"홍길동", email:"hong@naver.com" }
				// <tr>
				//    <td colspan = "2">hong@naver.com</td>
				// </tr>
				
				var html = '<tr name="detail">';
				html += '<td colspan="2">' + data.email + '</td>';
				html += '</tr>';
				
				$(btn).hide().next("button[name=hide_btn]").show();
				$(btn).parents("tr:first").after(html);
			}
		});
		
		$("button[name=hide_btn]").click(function(){
			$(this).hide().prev("button[name=show_btn]").show();
			$(this).parents("tr:first").next("tr[name=detail]").remove();
		});
	});
});