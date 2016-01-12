var m_datagrid;
var m_form;
var m_dlg;

function initDataGrid(datagrid,dlg,form,data){ 
	m_datagrid=datagrid;
	m_dlg=dlg;
	m_form=form;
	datagrid.datagrid({
		loadFilter:pagerFilter,
		toolbar:"#toolbar",
		rownumbers:true,
		singleSelect:true,
		autoRowHeight:false,
		pagination:true,
		pageSize:10,
		fitColumns:true,
	});
	datagrid.datagrid({loadFilter:pagerFilter}).datagrid('loadData', getData());
	var p = datagrid.datagrid('getPager'); 
	$(p).pagination({ 
	    pageSize: 10,// 每页显示的记录条数，默认为10
		pageList: [5,10,15],// 可以设置每页记录条数的列表
		beforePageText: '第',// 页数文本框前显示的汉字
		afterPageText: '页    共 {pages} 页', 
		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
	});  
}

function newData(){
	m_dlg.dialog('open').dialog('setTitle','编辑信息');
	m_form.form('clear');
}
function saveData(url,success){
	$.ajax({
		"url":url,
		"dataType":"text",
		"type":"post",
		"data":m_form.serialize(),
		"success":success
	});
}
function editData(){
	var row = m_datagrid.datagrid('getSelected');
	if(row){
		newData();
		m_form.form('load',row);
	}
}
function destroyData(url,id){
	var row = m_datagrid.datagrid('getSelected');
	if (row){
		$.messager.confirm('确认','确认删除吗？',function(r){
			if (r){
				var param=eval("({'"+id+"':"+row[id]+"})");
				$.post(url,param,function(result){
					if(result!=''){
						$.messager.alert("提示","删除失败，信息被占用");
					}else{
						location.href=location.href;
					}
				},'text');
			}
		});
	}
}

function pagerFilter(data){
	if (typeof data.length == 'number' && typeof data.splice == 'function'){ 
		data = {
			total: data.length,
			rows: data
		}
	}
	var dg = $(this);
	var opts = dg.datagrid('options');
	var pager = dg.datagrid('getPager');
	pager.pagination({
		onSelectPage:function(pageNum, pageSize){
			opts.pageNumber = pageNum;
			opts.pageSize = pageSize;
			pager.pagination('refresh',{
				pageNumber:pageNum,
				pageSize:pageSize
			});
			dg.datagrid('loadData',data);
		}
	});
	if (!data.originalRows){
		data.originalRows = (data.rows);
	}
	var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
	var end = start + parseInt(opts.pageSize);
	data.rows = (data.originalRows.slice(start, end));
	return data;
}

function myformatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
function myparser(s){
	if (!s) 
		return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0],10);
	var m = parseInt(ss[1],10);
	var d = parseInt(ss[2],10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d);
	} else {
		return new Date();
	}
}