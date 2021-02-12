package repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Temperatura;

public interface Temperatura_Jpa_Repository extends JpaRepository<Temperatura, Integer>{
	
	@Query("SELECT t FROM Temperatura t")
	List<Temperatura> recuperarLasTemperaturas();
	
	@Query("SELECT t FROM Temperatura t WHERE t.fecha between ?1 and ?2")
	List<Temperatura>temperaturaEntreFechas(LocalDate fechaIni,LocalDate FechaFin);

}
