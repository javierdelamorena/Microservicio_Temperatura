package repository;

import java.time.LocalDate;
import java.util.List;

import model.Temperatura;

public interface Temperatura_Repository {
	
	List<Temperatura> todasLasTemperaturas();
	Temperatura UnaTemperatura(int temp);
	void InsertarTemperaturas(Temperatura temperatura);
	List<Temperatura>temperaturaEntreFechas(LocalDate fechaIni,LocalDate FechaFin);

}
