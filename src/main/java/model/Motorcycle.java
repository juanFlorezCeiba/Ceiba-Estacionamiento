package model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuppressWarnings("serial")
@Entity
@EntityListeners(AuditingEntityListener.class)
@DiscriminatorValue("motorcycle")
public class Motorcycle extends Vehicle implements Serializable{

	public Motorcycle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Motorcycle(String plate) {
		super(plate);
		// TODO Auto-generated constructor stub
	}

}
