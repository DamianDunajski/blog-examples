Ext.define('TaskManager.view.TasksList', {
	extend : 'Ext.form.Panel',
	alias : 'widget.tasks-list',
	requires : ['TaskManager.view.TaskWindow'],
	title : TaskManager.title + ' - tasks list',
	items : [{
		xtype : 'textfield',
		anchor : '100%',
		margin : 5,
		emptyText : 'Enter task name'
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
			items : [{
				icon : 'ext/resources/images/edit.png',
				handler : function(grid, rowIndex, colIndex) {
					var record = grid.getStore().getAt(rowIndex);
					grid.fireEvent('taskEdit', record.get('name'));
				},
				margin : 2
			}, {
				icon : 'ext/resources/images/delete.png',
				handler : function(grid, rowIndex, colIndex) {
					var record = grid.getStore().getAt(rowIndex);
					grid.fireEvent('taskDelete', record.get('name'));
				},
				margin : 2
			}],
			width : 55
		}],
		hideHeaders : true,
		anchor : '100%',
		margin : 5
	}]
});
