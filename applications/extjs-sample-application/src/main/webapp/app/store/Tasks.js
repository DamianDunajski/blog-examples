Ext.define('TaskManager.store.Tasks', {
	extend : 'Ext.data.Store',
	model : 'TaskManager.model.Task',
	proxy : {
		type : 'rest',
		url : 'service/tasks',
		reader : {
			type : 'json',
			root : 'task'
		}
	},
	autoLoad : true
});
