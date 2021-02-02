package com.meze.APIGeneradorSGA.controller;

import java.util.ArrayList;
import java.util.EnumSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meze.APIGeneradorSGA.dto.Elemento;
import com.meze.APIGeneradorSGA.enums.CodigosPDF;

@CrossOrigin
@RestController
public class RotulosController {
	
	
	private static Logger logger = LoggerFactory.getLogger(RotulosController.class);
	
	@GetMapping("/getTags")
	public ArrayList<Elemento> getRotulos() {
		
		logger.info("Se ingresa a /getTags");
		ArrayList<Elemento> lista = new ArrayList<Elemento>();
		
		ArrayList<CodigosPDF> listaCodigos =
                new ArrayList<CodigosPDF>(EnumSet.allOf(CodigosPDF.class));

		for (CodigosPDF elemento : listaCodigos) {
			Elemento element = new Elemento(elemento.getNombrePdf(), elemento.getElemento());
			lista.add(element);
		}
		
		logger.info("Se retornara la lista de elementos.");
		
		return lista;
	}
	
	@RequestMapping("/ejemplos")
	public String getEjemplos() {
		return "A,B,C,D,E";
	}

}
