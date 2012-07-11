Ext.define('TaskManager.store.Tasks', {
	extend : 'Ext.data.Store',
	model : 'TaskManager.model.Task',
	proxy : {
		type : 'ajax',
		url : 'service/task/list',
		reader : {
			type : 'json',
			root : 'task'
		}
	 },
	 autoLoad: true
});