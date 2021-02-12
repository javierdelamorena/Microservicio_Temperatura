package service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Temperatura;
import repository.Temperatura_Repository;

@Service
public class TemperaturaServiceImpl implements Temperatura_Service {

	@Autowired
	Temperatura_Repository service;

	@Override
	public List<Temperatura> todas() {
		if (service.todasLasTemperaturas() != null) {
			return service.todasLasTemperaturas();
		}
		return null;
	}

	@Override
	public Temperatura una(int temp) {

		return service.UnaTemperatura(temp);
	}

	@Override
	public void agregarTeperatuta(Temperatura temperatura) {
		service.InsertarTemperaturas(temperatura);

	}

	@Override
	public Temperatura TemperaturaMaximaDia(LocalDate fecha) {
		System.out.println("la fecha que viene" + fecha);
		List<Temperatura> lista = service.todasLasTemperaturas();

		return lista.stream().filter(f -> f.getFecha().equals(fecha)).max(Comparator.comparingInt(l -> l.getTemp1()))
				.orElse(null);
	}

	@Override
	public List<Temperatura> temperaturaEntreFechas(LocalDate fechaIni, LocalDate FechaFin) {

		return service.temperaturaEntreFechas(fechaIni, FechaFin);
	}

	@Override
	public Temperatura TemperaturaMaxima() {
		List<Temperatura> lista = service.todasLasTemperaturas();
		return lista.stream().max(Comparator.comparingDouble(l -> l.getTemp1())).orElse(null);
	}

	@Override
	public Temperatura TemperaturaMinima() {
		List<Temperatura> lista = service.todasLasTemperaturas();
		return lista.stream().min(Comparator.comparingDouble(t -> t.getTemp1())).orElse(null);
	}

	@Override
	public Temperatura TemperaturaMinimaDia(LocalDate fecha) {
		List<Temperatura> lista = service.todasLasTemperaturas();
		return lista.stream().filter(f -> f.getFecha().equals(fecha)).min(Comparator.comparingInt(l -> l.getTemp1()))
				.orElse(null);
	}

}
