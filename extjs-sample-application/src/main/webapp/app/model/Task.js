Ext.define('TaskManager.model.Task', {
	extend : 'Ext.data.Model',
	fields : [{
		name : 'id',
		type : 'int'
	}, {
		name : 'name',
		type : 'string'
	}, {
		name : 'priority',
		type : 'string'
	}, {
		name : 'dueDate',
		type : 'string'
	}, {
		name : 'dueTime',
		type : 'string'
	}]
}); 