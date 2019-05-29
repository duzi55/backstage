$(document).ready(function(){
        $('#formId').submit(function () {
            var str = $('#image1').val();
            if (str == '' || str == undefined || str == null) {
                alert('请选择文件')
            }else{
                //是form提交，不是button，input的的，记得id也不要取成关键字！！
                $('#formId').submit();
                confirm("提交成功！")
                window.location.href='/jiyu/adv.html'
            }
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