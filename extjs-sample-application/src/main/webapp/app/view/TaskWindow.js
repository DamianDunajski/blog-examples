Ext.define('TaskManager.view.TaskWindow', {
	extend : 'Ext.window.Window',
	alias : 'widget.task-window',
	title : TaskManager.title + ' - task',
	modal : true,
	width : 400,
	minWidth : 400,
	layout : 'fit',
	items : {
		xtype : 'form',
		url : 'service',
		fieldDefaults : {
			labelAlign : 'left',
			labelWidth : 75
		},
		items : [{
			xtype : 'textfield',
			name : 'name',
			fieldLabel : 'Name',
			anchor : '100%',
			allowBlank : false
		}, {
			xtype : 'combobox',
			name : 'group',
			fieldLabel : 'Group',
			anchor : '100%',
			store : 'TaskGroups',
			queryMode : 'local',
			displayField : 'name',
			valueField : 'id',
			allowBlank : false
		}, {
			xtype : 'datefield',
			name : 'due-date',
			fieldLabel : 'Due date',
			anchor : '100%',
			format : 'Y-m-d'
		}, {
			xtype : 'timefield',
			name : 'reminder',
			fieldLabel : 'Reminder',
			anchor : '100%',
			increment : 15
		}, {
			xtype : 'checkbox',
			name : 'starred',
			fieldLabel : 'Starred',
		}],
		buttons : [{
			text : 'Save',
			formBind : true,
			disabled : true,
			handler : handleSave
		}, {
			text : 'Cancel',
			handler : handleCancel
		}],
		margin : 5
	}
})

function handleSave() {
	var form = this.up('form').getForm();
	if (form.isValid()) {
		form.submit({
			success : function(form, action) {
				this.up('window').close();
			},
			failure : function(form, action) {
				this.up('window').close();
			}
		});
	}
}

function handleCancel() {
	this.up('window').close();
}