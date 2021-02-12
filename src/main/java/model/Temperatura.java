package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the temperatura database table.
 * 
 */
@Entity
@Table(name="temperatura")

public class Temperatura  {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTemp;
	
	private int temp1;

	private int humedad;
	
	
	private LocalDate fecha;
	

	public Temperatura(int temp1, int humedad, LocalDate fecha) {
		super();
		this.temp1 = temp1;
		this.humedad = humedad;
		this.fecha = fecha;
	}
	

	public Temperatura() {
		super();
	}

	public int getTemp1() {
		return temp1;
	}

	public void setTemp1(int temp1) {
		this.temp1 = temp1;
	}

	public int getHumedad() {
		return humedad;
	}

	public void setHumedad(int humedad) {
		this.humedad = humedad;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	
}