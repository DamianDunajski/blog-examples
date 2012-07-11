Ext.define('TaskManager.store.TaskGroups', {
	extend : 'Ext.data.Store',
	model : 'TaskManager.model.TaskGroup',
	proxy : {
		type : 'ajax',
		url : 'service/task-group/list',
		reader : {
			type : 'json',
			root : 'taskGroup'
		}
	 },
	 autoLoad: true
});