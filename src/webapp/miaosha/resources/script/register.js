//登录操作相关js
var register = {
	URL:{
		loginUrl : function(){
			return "/user/register";
		}
	},
		
	registerHandler : function(){
		$('#userName').blur(function (){
			var userName = $('#userName').val();
			if(userName || userName.trim() == ''){
				$('#userNameError').hide();
				$('#userNameError').html("请输入用户名！");
				$('#userNameError').show(300);
			}
		});
		$('#userPhone').blur(function (){
			var userPhone = $('#userPhone').val();
			if(userPhone || userPhone.trim() == '' 
				|| userPhone.length != 11 || !isNaN(userPhone)){
				$('#userPhoneError').hide();
				$('#userPhoneError').html("请输入电话号码！");
				$('#userPhoneError').show(300);
			}
		});
	}

}