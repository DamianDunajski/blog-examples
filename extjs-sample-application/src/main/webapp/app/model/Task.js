Ext.define('TaskManager.model.Task', {
	extend : 'Ext.data.Model',
	fields : [{
		name : 'id',
		type : 'int'
	}, {
		name : 'version',
		type : 'int'
	}, {
		name : 'name',
		type : 'string'
	}, {
		name : 'priority',
		type : 'string'
	}, {
		name : 'dueDate',
		type : 'date'
	}, {
		name : 'reminder',
		type : 'date'
	}],
	associations : [{
		type : 'belongsTo',
		model : 'TaskManager.model.TaskGroup',
		getterName : 'getGroup',
		setterName : 'setGroup',
		associationKey : 'group'
	}],
	proxy : {
		type : 'rest',
		url : 'service/tasks',
		reader : {
			type : 'json',
		}
	}
});
