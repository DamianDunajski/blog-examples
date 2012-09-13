Ext.define('TaskManager.model.TaskGroup', {
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
	}],
	proxy : {
		type : 'rest',
		url : 'service/task/groups',
		reader : {
			type : 'json',
		}
	}
});
