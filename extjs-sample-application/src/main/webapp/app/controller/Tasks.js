Ext.define('TaskManager.controller.Tasks', {
	extend : 'Ext.app.Controller',
	views : ['TasksList', 'TaskWindow'],
	stores : ['Tasks'],
	init : function() {
		this.control({
			'tasks-list textfield' : {
				'taskCreate' : this.handleTaskCreate,
			},
			'tasks-list gridview' : {
				'taskEdit' : this.handleTaskEdit,
				'taskDelete' : this.handleTaskDelete
			},
			'task-window button[action = save]' : {
				'click' : this.handleTaskEditSave
			},
			'task-window button[action = cancel]' : {
				'click' : this.handleTaskEditCancel
			}
		})
	},
	handleTaskCreate : function(name) {
		// create task
		var task = Ext.create('TaskManager.model.Task', {
			name : name,
		});
		task.save();
		// reload store
		this.getTasksStore().load();
	},
	handleTaskEdit : function(record) {
		// get task
		Ext.ModelManager.getModel('TaskManager.model.Task').load(record.get('id'), {
			success : function(task) {
				// show window
				var widget = Ext.widget('task-window');
				widget.down('form').loadRecord(task);
				widget.show();
			}
		});
	},
	handleTaskEditSave : function(button) {
		var form = button.up('form').getForm();
		if (form.isValid()) {
			// save task
			var record = form.getRecord();
			record.set(form.getValues());
			record.save();
			// close window
			button.up('window').close();
			// reload store
			this.getTasksStore().load();
		}
	},
	handleTaskEditCancel : function(button) {
		// close window
		button.up('window').close();
	},
	handleTaskDelete : function(record) {
		// ask for confirmation
		Ext.Msg.show({
			title : TaskManager.title + ' - delete task?',
			msg : 'Do you want delete "' + record.get('name') + '"?',
			buttons : Ext.Msg.YESNO,
			fn : function(btn) {
				if (btn == 'yes') {
					// remove task
					record.destroy();
					// reload store
					this.getTasksStore().load();
				}
			}
		});
	}
})
