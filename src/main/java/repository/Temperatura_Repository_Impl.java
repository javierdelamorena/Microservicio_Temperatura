package repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Temperatura;

@Repository
public class Temperatura_Repository_Impl implements Temperatura_Repository {
	
	@Autowired
	Temperatura_Jpa_Repository repository;
	

	@Override
	public List<Temperatura> todasLasTemperaturas() {
		// TODO Auto-generated method stub
		return repository.recuperarLasTemperaturas();
	}

	@Override
	public Temperatura UnaTemperatura(int temp) {
		
		return repository.findById(temp).orElse(null);
	}

	@Override
	public void InsertarTemperaturas(Temperatura temperatura) {
		repository.save(temperatura);
		
	}

	@Override
	public List<Temperatura> temperaturaEntreFechas(LocalDate fechaIni, LocalDate FechaFin) {
		
		return repository.temperaturaEntreFechas(fechaIni, FechaFin);
	}

}
