Ext.define('TaskManager.controller.TasksList', {
	extend : 'Ext.app.Controller',
	views : ['TasksList'],
	stores : ['Tasks'],
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
		var task = Ext.create('TaskManager.model.Task', {
			name : name,
		});
		task.save();
		this.getTasksStore().load();
	},
	handleTaskEdit : function(record) {
		Ext.ModelManager.getModel('TaskManager.model.Task').load(record.get('id'), {
			success : function(task) {
				console.log(task);
				var widget = Ext.widget('task-window');
				widget.down('form').loadRecord(task);
				widget.show();
			}
		});
	},
	handleTaskDelete : function(record) {
		Ext.Msg.show({
			title : TaskManager.title + ' - delete task?',
			msg : 'Do you want delete "' + record.get('name') + '"?',
			buttons : Ext.Msg.YESNO,
			fn : function(btn) {
				if (btn == 'yes') {
					record.destroy();
				}
			}
		});
	}
})
