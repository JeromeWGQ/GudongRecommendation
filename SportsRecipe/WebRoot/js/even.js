var URL;
$(function(){
    $("input#login").click(function () {
        $.ajax({
            type:"get",
            async:false,
            url:"http://localhost:8080/SportsRecipe/login",
            data:{
                name:$("#name").val(),
                password:$("#password").val(),
            },
            success:function (datas) {
                var json=eval('('+datas+')');
                if(json.data == 1) {
                    window.location.href ='www.baidu.com' ;
                }else{
                    alert('登录失败！');
                }
            },
            error:function () {
            }
        });
    })
})

$(function(){
    $('#name').blur(function(){
        var reg=/[!@#$%^&*()-+,、:;"'.]/
        var str=$("#name").val()
        var r=reg.exec(str)
        if(r!=null){
            alert("有非法字符！请重新输入用户名！(用户名中不允许有!@#$%^&*()-+,、:;\"\'.)")
            $("#name").val('')
        }
    })
})