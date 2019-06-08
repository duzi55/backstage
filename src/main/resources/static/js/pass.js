$(document).ready(function(){

    $.get("/jiyu/propaganda/findallbystatus/"+0,function (data) {
        for(i=0;i<data.length;i++){
            var title1=data[i].firstTitle;
            var title2=data[i].secondTitle;
            var id=data[i].id;
            $("#slogan1").append('<tr>\n' +
                '    <td>'+title1+'</td>\n' +
                '    <td>'+title2+'</td>\n' +
                '    <td style="width: 120px"><div class="btn-group" style="width: 120px;">\n' +
                '      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="titleupdate(\''+title1+'\',\''+title2+'\',\''+id+'\')">修改</button>\n' +
                '      <button type="button" class="btn btn-primary" onclick="titledelete('+id+')">删除</button></div></td>\n' +
                '  </tr>')
        }
    })
    $("#savasl").click(function () {
        $("#uptitle1").val("")
        $("#uptitle2").val("")
        $("#titleupdate").click(function () {
            if(confirm("确定提交？")){
                $.post("/jiyu/propaganda/savashortslogan",{firstTitle:$("#uptitle1").val(),secondTitle: $("#uptitle2").val()},function (data) {
                    if(data){
                        alert("提交成功！")
                        window.location.href="pass.html";
                    }else {
                        alert("刷新重试")
                    }
                })

            }
        })
    })
    $("#ptitle1").text("第一个标题")
    $("#pslogan1").text("短语")
    $("#sava1").click(function () {
        $("#status").val(2)
    })
    $("#sava2").click(function () {
        $("#status").val(1)
    })
    $("#tj").submit(function () {

        var form= new FormData(document.getElementById("tj"))
        $.ajax({
            url:"/jiyu/propaganda/uploadsloganimage",
            type:"post",
            data:form,
            processData:false,
            contentType:false,
            xhr: function() { //用以显示上传进度
                var xhr = $.ajaxSettings.xhr();
                if (xhr.upload) {
                    xhr.upload.addEventListener('progress', function(event) {
                        var percent = Math.floor(event.loaded / event.total * 100);
                        // document.querySelector("#progress .progress-item").style.width = percent + "%";
                        //  $("#progress .progress-item").text(percent + "%")
                        if(percent==100){
                            confirm("上传成功")
                        }
                    }, false);
                }
                return xhr
            },
            success:function(data){
                if(data){
                    window.location.href="pass.html"
                }

            },
            error:function(e){
                alert("错误！！");

            }
        });
    })
})

//修改标题什么的
$.get("/jiyu/propaganda/indexpropaganda",function (data) {
    console.log(data)
    $("#ptitle1").text(data[3].title)
    $("#pslogan1").text(data[3].slogan)
    $("#ptitle2").text(data[4].title)
    $("#pslogan2").text(data[4].slogan)

});


//----------------------------------------------------------------定义titleupdate函数----------------------------------------------------------------------------------------------
function titleupdate(x,y,z) {
    $("#uptitle1").val(x)
    $("#uptitle2").val(y)
    $("#titleupdate").click(function () {
        if(confirm("确定提交？")){
            $.post("/jiyu/propaganda/updateshortslogan",{firstTitle:$("#uptitle1").val(),secondTitle: $("#uptitle2").val(),id:z},function (data) {
                if(data){
                    alert("提交成功！")
                    window.location.href="pass.html";
                }else {
                    alert("刷新重试")
                }
            })

        }
    })

}
//----------------------------------------------------------------定义titledelete函数----------------------------------------------------------------------------------------------
function titledelete(id) {
    if(confirm("确认删除？")){
        $.post("/jiyu/propaganda/deleteshortslogan",{id:id},function (data) {
            if(data){
                alert("删除成功！")
                window.location.href="pass.html";
            }else {
                alert("数据库缓慢，刷新页面重试")
            }
        })
    }
}