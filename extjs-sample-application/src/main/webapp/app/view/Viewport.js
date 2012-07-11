Ext.define('TaskManager.view.Viewport', {
	extend : 'Ext.container.Viewport',
	requires: [
		'TaskManager.view.TasksList'
	],
	layout : 'fit',
	items : {
		xtype : 'tasks-list'
	}
})