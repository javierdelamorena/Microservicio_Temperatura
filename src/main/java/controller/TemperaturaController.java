package controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoTemperatura;
import model.Temperatura;
import service.Temperatura_Service;
import util.Utilidades;

@CrossOrigin(origins="*")
@RestController
public class TemperaturaController {

	@Autowired
	Temperatura_Service service;

	@GetMapping(value = "Temperaturas", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DtoTemperatura> temperaturas() {

		List<Temperatura> listas = service.todas();

		List<DtoTemperatura> lista = new ArrayList<>();

		for (Temperatura e : listas) {

			lista.add(new DtoTemperatura(e.getTemp1(), e.getHumedad(), e.getFecha().toString()));

		}

		return lista;
	}

	@PostMapping(value = "TemperaturasAgregar/{temp}/{humedad}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String agregar(@PathVariable("temp") String temp, @PathVariable("humedad") String humedad,
			HttpSession sesion) {
		LocalDate fecha = LocalDate.now();

		Temperatura temperatura = new Temperatura(Integer.parseInt(temp), Integer.parseInt(humedad), fecha);
		sesion.setAttribute("temp", temperatura);
		service.agregarTeperatuta(temperatura);

		return "respuestaMicro.html";

	}

	@GetMapping(value = "Temperatura", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<DtoTemperatura> temperatura() {

		List<Temperatura> listas = service.todas();

		List<DtoTemperatura> listaString = new ArrayList<>();

		for (Temperatura e : listas) {

			listaString.add(new DtoTemperatura(e.getTemp1(), e.getHumedad(), e.getFecha().toString()));

		}

		return listaString;
	}

	@GetMapping(value = "TemperaturaEntreFechas/{fecha1}/{fecha2}", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<DtoTemperatura> tempEntreFechas(@PathVariable("fecha1")String fecha1,@PathVariable("fecha2")String fecha2, HttpSession sesion) {
		System.out.println(fecha1+"    "+fecha2);
		
		LocalDate fech1=LocalDate.parse(fecha1);
		LocalDate fech2=LocalDate.parse(fecha2);
		
		List<Temperatura> listas = service.temperaturaEntreFechas(fech1, fech2);

		List<DtoTemperatura> listaString = new ArrayList<>();

		for (Temperatura e : listas) {

			listaString.add(new DtoTemperatura(e.getTemp1(), e.getHumedad(), e.getFecha().toString()));

		}
		listaString.forEach(l -> System.out.println(l.getFecha()));

		return listaString;
	}

	

}
