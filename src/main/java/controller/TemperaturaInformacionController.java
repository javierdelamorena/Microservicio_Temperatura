package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoTemperatura;
import service.Temperatura_Service;
import util.Utilidades;

@CrossOrigin(origins="*")
@RestController
public class TemperaturaInformacionController {

	@Autowired
	Temperatura_Service service;

	@GetMapping(value = "TemperaturaMaxima", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody DtoTemperatura maxima() {

		DtoTemperatura tempMax=Utilidades.convertirADtoTempraratura(service.TemperaturaMaxima());
		 
		 return tempMax;

	}
	@GetMapping(value = "TemperaturaMinima", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody DtoTemperatura minima() {

		DtoTemperatura tempMin=Utilidades.convertirADtoTempraratura(service.TemperaturaMinima());
		 
		 return tempMin;

	}


	@GetMapping(value = "TemperaturaMaximaDia/{fecha}", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody DtoTemperatura maximaTemperaturaDia(@PathVariable("fecha")String fecha)  {
		
		System.out.println("esta es lo que llega al micro"+fecha);
		
		
		
		
		LocalDate nfecha=LocalDate.parse(fecha);
		
		 return Utilidades.convertirADtoTempraratura(service.TemperaturaMaximaDia(nfecha));

	}
	@GetMapping(value = "TemperaturaMinimaDia/{fecha}", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody DtoTemperatura minimaTemperatura(@PathVariable("fecha")String fecha) {
		
		
		
		LocalDate nfecha=LocalDate.parse(fecha);
		
		 return Utilidades.convertirADtoTempraratura(service.TemperaturaMinimaDia(nfecha));


	}
	

}
