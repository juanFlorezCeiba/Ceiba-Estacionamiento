package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuppressWarnings("serial")
@Entity
@EntityListeners(AuditingEntityListener.class)
@DiscriminatorValue("car")
public class Car extends Vehicle implements Serializable{

	
	@NotNull
	@Column(name = "displacement")
	private int displacement;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String plate) {
		super(plate);
		// TODO Auto-generated constructor stub
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	
	
}
