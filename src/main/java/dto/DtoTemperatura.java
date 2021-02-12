package dto;

public class DtoTemperatura {
	
	private int temp1;

	private int humedad;
	 
	private String fecha;

	public DtoTemperatura(int temp1, int humedad, String fecha) {
		super();
		this.temp1 = temp1;
		this.humedad = humedad;
		this.fecha = fecha;
	}

	public DtoTemperatura() {
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

}
