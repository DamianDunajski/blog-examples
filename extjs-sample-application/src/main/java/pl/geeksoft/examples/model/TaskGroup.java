package pl.geeksoft.examples.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import pl.geeksoft.examples.model.base.BaseModel;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskGroup extends BaseModel {

	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
