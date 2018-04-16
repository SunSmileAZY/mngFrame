/**
 * Created by anzy on 2018/4/13.
 */
$(document).ready(function () {
    $('#table').bootstrapTable({
        url: ctxPath + '/log/listLog',
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
        uniqueId: "id",               //每一行的唯一标识，一般为主键列
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
            {title: '系统', field: 'systemType'},
            {title: '日志级别', field: 'level',
                formatter: function (value, row, index) {
                    if (value == null)
                        return "";
                    else if (value == "ERROR" || value == "error"){
                        return "<span style='color:red' title='"+value+"'>"+value+"</span>";
                    }else{
                        return value;
                    }
                }
            },
            {title: '操作用户', field: 'operater'},
            {title: '操作信息', field: 'message',
                formatter: function (value, row, index) {
                    if (value == null || value == undefined)
                        return "";
                    else if (value.length >=  70){
                        return "<span title='"+value+"'>"+value.substring(0,70)+"······ </span>";
                    }else{
                        return value;
                    }
                }},
            {title: '操作时间', field: 'logDt'},
            {title: '操作IP', field: 'ipAddress'},
            {
                title: '打印日志类', field: 'loggerName',
                formatter: function (value, row, index) {
                    if (value == null)
                        return "";
                    else {
                        return value;
                    }
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
        operater: $.trim($("#txtOperater").val()),
        systemType: $.trim($("#txtSystemType").val())
    };
}

//查询事件
function searchData() {
    $('#table').bootstrapTable('refresh', {pageNumber: 1});
}
