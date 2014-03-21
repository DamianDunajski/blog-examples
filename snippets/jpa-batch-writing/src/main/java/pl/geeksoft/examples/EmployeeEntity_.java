package pl.geeksoft.examples;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(EmployeeEntity.class)
public class EmployeeEntity_ {

	public static volatile SingularAttribute<EmployeeEntity, Long>   id;
	public static volatile SingularAttribute<EmployeeEntity, String> name;
	public static volatile SingularAttribute<EmployeeEntity, Date>   removeTime;

}
