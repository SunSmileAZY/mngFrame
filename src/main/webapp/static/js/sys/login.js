/**
 * Created by anzy on 2017/12/16.
 */
var login = new Vue({
    el: '#login_box',
    data: {
        message: 'Hello Vue.js!',
        errorMsg:''
    },
    // 选项
    methods: {
        login: function (event) {
            var account = $("#username");
            var passwd = $("#password");
            if (!account.val().trim()) {
                account.focus();
                login.errorMsg = "请输入用户名！";
                return;
            }
            if (!passwd.val().trim()) {
                passwd.focus();
                login.errorMsg = "请输入密码！";
                return;
            }
            var that = this;
            that.$http({           //调用接口
                method:'POST',
                url:ctxPath + "/login/doLogin" , //this指data
                params:{
                    userName : account.val().trim(),
                    password : passwd.val().trim()
                }
            }).then(function(response){  //接口返回数据
                if(response.body == "success"){
                    window.location.href = ctxPath + "/user/init";
                }else{
                    login.errorMsg=response.body;
                }
            },function(error){
            })
        },
        reset:function(){
            $("#username").val("");
            $("#password").val("");
            $("#error_msg").text("");
            $("#username").focus();
        }
    }
})