Ext.define('TaskManager.view.TasksList', {
	extend : 'Ext.form.Panel',
	alias : 'widget.tasks-list',
	requires : ['TaskManager.view.TaskWindow'],
	title : TaskManager.title + ' - tasks list',
	items : [{
		xtype : 'textfield',
		anchor : '100%',
		margin : 5,
		emptyText : 'Enter task name',
		enableKeyEvents : true
	}, {
		xtype : 'grid',
		store : 'Tasks',
		layout : 'fit',
		columns : [{
			dataIndex : 'priority',
			renderer : TaskManager.Renderer.renderPriority,
			width : 28
		}, {
			dataIndex : 'name',
			flex : 1
		}, {
			dataIndex : 'dueDate',
			renderer : TaskManager.Renderer.renderDueDate,
			width : 75
		}, {
			xtype : 'actioncolumn',
			id : 'edit-action',
			items : [{
				icon : 'ext/resources/images/edit.png',
			}],
			width : 22
		}, {
			xtype : 'actioncolumn',
			id : 'remove-action',
			items : [{
				icon : 'ext/resources/images/delete.png',
			}],
			width : 22
		}],
		hideHeaders : true,
		anchor : '100% 100%',
		margin : 5
	}]
});
