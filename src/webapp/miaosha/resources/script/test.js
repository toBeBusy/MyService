var test = {
		init : function() {
			var userName = $("#userName").text();
			var passWord = $("#passWord").text();
			$("#submitUser").click(function(){
				alert(userName);
				alert(passWord);
				$.ajax({
						url : '/user/queryUserByName',
						type : 'POST',
//						{userName : userName, pawssWord : passWord},
						data : {userName : userName, password : passWord},
						dataType : 'json',
						success : function(user){
							alert(user.userName);
							alert(user.passWord);
					  }});
			});
		}
}