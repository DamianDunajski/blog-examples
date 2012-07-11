TaskManager = {
	name : 'TaskManager',
	title : 'Task Manager'
}

TaskManager.Renderer = {
	renderPriority : function(value) {
		if (value == 'IMPORTANT') {
			return '<img src="ext/resources/images/important.png"></img>';
		} else {
			return '<img src="ext/resources/images/normal.png"></img>';
		}
	},
	renderDueDate : function(value) {
		if (value != 'null') {
			return value;
		}
	}
}

Ext.Loader.setConfig({
	enabled : true
})

Ext.application({
	name : TaskManager.name,
	autoCreateViewport : true,
	stores : ['Tasks', 'TaskGroups'],
	controllers : ['TasksList']
})
