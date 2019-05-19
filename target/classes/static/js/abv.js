$(document).ready(function(){
        $('#sub').click(function () {
            var str = $('#image1').val();
            if (str == '' || str == undefined || str == null) {
                alert('请选择文件')
            }else{
                //是form提交，不是button，input的的，记得id也不要取成关键字！！
                $('#formId').submit();
            }
        })
    $('.table.table-hover.text-center').append('\n' +
        '    <tr>\n' +
        '      <td>1</td>     \n' +
        '      <td><img src="images/11.jpg" alt="" width="120" height="50" /></td>     \n' +
        '\n' +
        '      <td><div class="button-group">\n' +
        '\n' +
        '      <a class="button border-red"><span class="icon-trash-o"></span> 删除</a>\n' +
        '      </div></td>\n' +
        '    </tr>\n' +
        '   ')


});