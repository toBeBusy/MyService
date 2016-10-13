var login = {
		url : {
			queryUserName : function() {
				return '/user/queryUserByName';
			} 
		},
		
		init : function(){
			var username = $.cookie("userName");
			var password = $.cookie("password");
			if(username){
				$('#userName').val = username;
			}
			if(password){
				$('#password').val = password;
			}
		},
		
		userNameCheck : function(){
			$('#userName').blur(function(){
				var userName = $('#userName').val();
				if(!userName || userName.trim() == ''){
					$('#checkUserName').html('用户名不能为空。');
					return;
				}
				var queryUserName = login.url.queryUserName();
				$.post(queryUserName,
						{userName: userName},
						function(data){
							if(!data['userName']){
								$('#checkUserName').html('用户名不存在。');
							} else {
								$('#checkUserName').html('嘿嘿。');
							}
						})
			});
		}	
}