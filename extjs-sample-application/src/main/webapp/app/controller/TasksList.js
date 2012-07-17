Ext.define('TaskManager.controller.TasksList', {
	extend : 'Ext.app.Controller',
	views : ['TasksList'],
	init : function() {
		this.control({
			'tasks-list textfield' : {
				'taskCreate' : this.handleTaskCreate,
			},
			'tasks-list gridview' : {
				'taskEdit' : this.handleTaskEdit,
				'taskDelete' : this.handleTaskDelete
			}
		})
	},
	handleTaskCreate : function(name) {
		console.log('Create task with name: ' + name);
	},
	handleTaskEdit : function(record) {
		var widget = Ext.widget('task-window');
		widget.down('form').loadRecord(record);
		widget.show();
	},
	handleTaskDelete : function(record) {
		Ext.Msg.show({
			title : TaskManager.title + ' - delete task?',
			msg : 'Do you want delete "' + record.get('name') + '"?',
			buttons : Ext.Msg.YESNO
		});
	}
})
