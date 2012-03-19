
username_not_empty = "Please input username";//Ban chua nhap username"
password_not_empty="Please input password";//Ban chua nhap password";
username_password_not_empty="Username and Password not empty‚";//UserName va Password khong duoc rong";
user_not_exist="User not exits";//"User ko ton tai";
not_connect_server="not connect to server ! please try again !";
pass_not_true = "Password is not true";
function LoginCheck() {

	var userName = $("#txt_id").val();
	var passWord = $("#txt_pass").val();
	var error = "";
	if (userName.toString().length == 0 && passWord.toString().length == 0) {
            error = username_password_not_empty;
            $("#lberror").html(error);
	} else {
            if (passWord.toString().length == 0) {
                // KhÃ´ng nháº­p máº­t kháº©u
                error = password_not_empty;
                $("#lberror").html(error);
            } else {                      
                var sendData = "action=login&un=" + userName + "&pw=" + passWord;                       
                $.ajax({
                    type : "POST",
                    url : 'login.htm',     //'/login.htm', 
                    data : sendData,
                    success : function(msg) {
                        if (msg=="access") {
                            // Ä�Äƒng nháº­p thÃ nh cÃ´ng, chuyá»ƒn trang
                            $(location).attr('href', "MainMenu.htm");
                        } else if(msg=="password_not_true") {
                            // Ä�Äƒng nháº­p tháº¥t báº¡i, hiá»ƒn thá»‹ thÃ´ng bÃ¡o
                            error = pass_not_true;
                            $("#lberror").html(error);
                        }else if(msg=="username_not_true") {
                            error =user_not_exist;
                            $("#lberror").html(error);
                        }else{
                            error = msg;
                            $("#lberror").html(error);
                        }
                    }
                }); 

            }

	}

}


$(document).ready(function() {
	$("#txt_pass").keyup(function(e) {

		if (e.which == '13') {
			LoginCheck();
		} else {
			textBoxOnKeyUp(this);
		}

	});
	$('#txt_pass').blur(function() {
		textBoxOnKeyUp(this);
	});
        $(".ui-button-text-only").hover(function() {$(this).css("color", "#b81900");$(this).addClass('ui-state-hover');}, function() {$(this).css("color", "#417394");$(this).removeClass('ui-state-hover');});
         
         if($.client.version<7 && $.client.browser =="Explorer"){
            humane.waitForMove = true;
            $("#lberror").html("not support for IE"+$.client.version+",please use IE7 or IE8");
            $("#btn_submit").attr("disabled", "true");
        }   


});

function textBoxOnKeyUp(input) {
	var alphabet = /[\W]/g;
	var text = $(input).val();
	text = text.replace(alphabet, '');
	$(input).attr('value', text);
}
