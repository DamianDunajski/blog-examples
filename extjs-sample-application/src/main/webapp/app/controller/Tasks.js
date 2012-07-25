Ext.define('TaskManager.controller.Tasks', {
	extend : 'Ext.app.Controller',
	views : ['TasksList', 'TaskWindow'],
	stores : ['Tasks'],
	init : function() {
		this.control({
			'tasks-list textfield' : {
				'keyup' : this.handleTaskCreate,
			},
			'tasks-list actioncolumn#edit-action' : {
				'click' : this.handleTaskEdit
			},
			'tasks-list actioncolumn#remove-action' : {
				'click' : this.handleTaskRemove
			},
			'task-window button[action = save]' : {
				'click' : this.handleTaskEditSave
			},
			'task-window button[action = cancel]' : {
				'click' : this.handleTaskEditCancel
			}
		})
	},
	handleTaskCreate : function(field, event) {
		if (event.getKey() != event.ENTER) {
			return;
		}
		var taskName = field.getValue();
		if (taskName.trim() != '') {
			// create task
			var task = Ext.create('TaskManager.model.Task', {
				name : taskName,
			});
			task.save();
			// reset field
			field.reset();
			// reload store
			this.getTasksStore().load();
		}
	},
	handleTaskEdit : function(grid, cell, rowIndex, colIndex, event) {
		// get task
		var record = grid.getStore().getAt(rowIndex);
		Ext.ModelManager.getModel('TaskManager.model.Task').load(record.get('id'), {
			success : function(task) {
				// show window
				var widget = Ext.widget('task-window');
				widget.down('form').loadRecord(task);
				widget.show();
			}
		});
	},
	handleTaskRemove : function(grid, cell, rowIndex, colIndex, event) {
		// ask for confirmation
		var record = grid.getStore().getAt(rowIndex);
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
	},
	handleTaskEditSave : function(button, event) {
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
	handleTaskEditCancel : function(button, event) {
		// close window
		button.up('window').close();
	}
})
