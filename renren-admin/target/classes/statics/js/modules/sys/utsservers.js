$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/utsservers/list',
        datatype: "json",
        colModel: [
            { label: '工单服务编号', name: 'serverCode', index: 'server_code', width: 80 },
            { label: '服务名称', name: 'serverName', index: 'server_name', width: 80 },
            { label: '单位', name: 'unit', index: 'unit', width: 80 },
            { label: '单价（元）', name: 'price', index: 'price', width: 80 },
            { label: '备注', name: 'remark', index: 'remark', width: 80 },
            { label: '所属项目ID', name: 'projectId', index: 'project_id', width: 80 },
			{ label: '添加时间', name: 'createTime', index: 'create_time', width: 80 },
            { label: '操作', width: 80},
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
            console.log("123")
        	//$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
        q:{
            projectId: null,
            serverName: null,
            serverCode: null
        },
		showList: true,
		title: null,
		utsServers: {
        }
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.utsServers = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.utsServers.id == null ? "sys/utsservers/save" : "sys/utsservers/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.utsServers),
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
                             vm.reload();
                             $('#btnSaveOrUpdate').button('reset');
                             $('#btnSaveOrUpdate').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "sys/utsservers/delete",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(id){
			$.get(baseURL + "sys/utsservers/info/"+id, function(r){
                vm.utsServers = r.utsServers;
            });
		},
		reload: function () {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
			    postData:{
			        'projectId': vm.q.projectId ,
                    'serverName': vm.q.serverName ,
                    'serverCode': vm.q.serverCode
                },
                page:page
            }).trigger("reloadGrid");
		}
	}
});