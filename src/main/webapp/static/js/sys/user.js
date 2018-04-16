/**
 * 用户管理
 * Created by anzy on 2017/12/16.
 */
$(document).ready(function () {
    $('#table').bootstrapTable({
        url: ctxPath + '/user/listUser',
        queryParamsType: '',              //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
        queryParams: queryParams,
        method: "get",
        pagination: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 20, 50, 100],
        sidePagination: "server",         //分页方式：client客户端分页，server服务端分页（*）
        striped: true,                    //是否显示行间隔色
        cache: false,
        uniqueId: "userId",               //每一行的唯一标识，一般为主键列
        height: 500,
        paginationPreText: "上一页",
        paginationNextText: "下一页",
        columns: [
            {checkbox: true},
            {
                title: '序号', width: 50, align: "center", formatter: function (value, row, index) {
                return index + 1;
            }
            },
            {title: '登录名', field: 'loginAccount'},
            {title: '用户名', field: 'userName'},
            {title: '邮箱', field: 'userEmail'},
            {title: '生日', field: 'userBirthday'},
            {
                    title: '注册时间', field: 'registerTime', formatter: function (value, row, index) {
                    if (value == null)
                        return "";
                    else {
                        return value;
                    }
                }
            },
            {
                title: '操作', field: 'userId', formatter: function (value, row, index) {
                var html = '<a href="javascript:editBook(' + value + ')">编辑</a>';
                html += '　<a href="javascript:deleteBook(' + value + ')">删除</a>';
                return html;
            }
            }
        ]
    });
});

//查询条件
function queryParams(params) {
    return {
        rows: params.pageSize,
        page: params.pageNumber,
        username: $.trim($("#txtUsername").val()),
        email: $.trim($("#txtEmail").val()),
        loginAccount: $.trim($("#txtLoginAccount").val()),
    };
}

//查询事件
function searchData() {
    $('#table').bootstrapTable('refresh', {pageNumber: 1});
}

//编辑操作
function editBook(bookId) {
    alert("编辑操作，用户ID：" + bookId);
}

//删除操作
function deleteBook(userId) {
    if (confirm("确定删除用户ID：" + userId + "吗？")) {
        alert("执行删除操作");
    }
}

//批量删除
function btchDeleteBook() {
    var opts = $('#table').bootstrapTable('getSelections');
    if (opts == "") {
        alert("请选择要删除的数据");
    }
    else {
        var idArray = [];
        for (var i = 0; i < opts.length; i++) {
            idArray.push(opts[i].UserId);
        }
        if (confirm("确定删除用户ID：" + idArray + "吗？")) {
            alert("执行删除操作");
        }
    }
}

