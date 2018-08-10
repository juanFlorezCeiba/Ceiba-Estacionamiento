package model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "registros")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
public class Register implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "entry_date", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	 private Calendar entryDate;
	
	@Column(name = "exit_date", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	 private Calendar exitDate;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="plate_vehicle")
	private Vehicle vehicle;
	
	public Register(){
		
	}
	
	public Register(int id, Calendar entryDate, Vehicle vehicle){
		super();
		this.id = id;
		this.entryDate = entryDate;
		this.vehicle = vehicle;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Calendar entryDate) {
		this.entryDate = entryDate;
	}

	public Calendar getExitDate() {
		return exitDate;
	}

	public void setExitDate(Calendar exitDate) {
		this.exitDate = exitDate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
		 
}
