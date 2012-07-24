Ext.define('TaskManager.store.TaskGroups', {
	extend : 'Ext.data.Store',
	model : 'TaskManager.model.TaskGroup',
	proxy : {
		type : 'rest',
		url : 'service/task/groups',
		reader : {
			type : 'json',
			root : 'taskGroup'
		}
	},
	autoLoad : true
}); 