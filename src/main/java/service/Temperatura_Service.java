package service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import model.Temperatura;

public interface Temperatura_Service {
	
	List<Temperatura> todas();
	Temperatura una(int temp);
	void agregarTeperatuta(Temperatura temperatura);
	
	Temperatura TemperaturaMaxima();
	Temperatura TemperaturaMinima();
	Temperatura TemperaturaMaximaDia(LocalDate fecha);
	Temperatura TemperaturaMinimaDia(LocalDate fecha);
	List<Temperatura>temperaturaEntreFechas(LocalDate fechaIni,LocalDate FechaFin);
	
	

}
