package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_type")
@Table(name = "vehicles")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
public class Vehicle implements Serializable{

	@Id
	@Column(name = "plate")
	private String plate;

	public Vehicle() {
		super();
	}

	public Vehicle(String plate) {
		super();
		this.plate = plate;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}
	
}
