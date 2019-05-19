$(document).ready(function(){

    $(".button.button-block.bg-main.text-big.input-big").click(function () {
        $.post("/jiyu/user/login",{userName:$("#username").val(),passWord:$("#password").val()}, function(data){
            if(data){
                window.location.href='/jiyu/index.html';
            }
        });
    })


});