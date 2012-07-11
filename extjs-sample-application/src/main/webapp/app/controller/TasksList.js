Ext.define('TaskManager.controller.TasksList', {
	extend : 'Ext.app.Controller',
	views : ['TasksList'],
	init : function() {
		this.control({
			'tasks-list gridview' : {
				'taskEdit' : this.handleTaskEdit,
				'taskDelete' : this.handleTaskDelete
			}
		})
	},
	handleTaskEdit : function(name) {
		console.log('Show task editor window for task: ' + name);
		new TaskManager.view.TaskWindow().show();
	},
	handleTaskDelete : function(name) {
		console.log('Show task delete confirmation window for task: ' + name);
		Ext.Msg.show({
			title : TaskManager.title + ' - delete task?',
			msg : 'Do you want delete "' + name + '"?',
			buttons : Ext.Msg.YESNO
		});
	}
})