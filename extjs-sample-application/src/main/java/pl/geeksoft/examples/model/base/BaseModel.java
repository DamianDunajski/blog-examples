package pl.geeksoft.examples.model.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseModel implements Serializable {

	@Id
	@Column(name = "id", nullable = false)
	protected Long id;
	@Version
	@Column(name = "version", nullable = false)
	protected Long version;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
}
