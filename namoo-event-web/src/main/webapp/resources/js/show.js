$(document).ready(function(){
	$("button[name=show_btn]").click(function(){
		//
		var btn = this;
		$.ajax({
			"url" : ctx + "/detail",
			"data" : {"id" : parseInt($(this).data("id"))},
			"type" : "get",
			"dataType" : "json",
			"success" : function(data) {
				//
//				<p><img src="${ctx}/${event.id}/largeImg" class="img-responsive"></img></p>
//			    <p> 일시 : ${event.openDate}<br /></p>
//			    <p> 설명 : ${event.description}<br /></p>
				
				var html = '<p><img src="' + ctx + '/'+ data.id + '/largeImg" class="img-responsive"></img></p>';
				html += '<p>일시 : ' + data.openDate + '</p><br />';
				html += '<p>설명 : ' + data.description + '</p><br />';
				
				$(btn).hide().next("button[name=hide_btn]").show();
				
				$(btn).nextAll("div:first").html(html).show();
			}
		});
		
		$("button[name=hide_btn]").click(function(){
			$(this).hide();
			$("button[name=show_btn]").show();
			$(this).nextAll("div:first").hide();
		});
	});
});