$(document).ready(function(){
    $("#formId").submit(function () {
        var form= new FormData(document.getElementById("formId"))
        $.ajax({
            url:"/jiyu/image/upload",
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

                    window.location.href='/jiyu/adv.html'
                }

            },
            error:function(e){
                alert("错误！！");

            }
        });
    })

    $.get("/jiyu/image/findindeximage", function(data){
        for(i=0;i<data.length;i++){
            $('.table.table-hover.text-center').append('\n' +
                '    <tr>\n' +
                '      <td>'+data[i].id+'</td>     \n' +
                '      <td><img src="'+data[i].src+'" alt="" width="120" height="50" /></td>     \n' +
                '\n' +
                '      <td><div class="button-group">\n' +
                '\n' +
                '      <button class="button border-red" onclick="deleteImage('+data[i].id+')" value="'+data[i].id+'"><span class="icon-trash-o"></span> 删除</button>\n' +
                '      </div></td>\n' +
                '    </tr>\n' +
                '   ')
        }
    });



});
function deleteImage(imageId) {
    // console.log(imageId)
    var rst=confirm("你真的确定要删除吗?");
    if (rst==true){
       $.post("/jiyu/image/deleteindeximg",{id:imageId},function (data) {
           console.log(data)
           confirm("删除成功！")
           window.location.href='/jiyu/adv.html'
       })
    }

}