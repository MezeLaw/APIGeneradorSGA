package com.meze.APIGeneradorSGA.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.EnumSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meze.APIGeneradorSGA.dto.Elemento;
import com.meze.APIGeneradorSGA.enums.CodigosPDF;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class RotulosController {

	private static Logger logger = LoggerFactory.getLogger(RotulosController.class);

	@GetMapping("/getTags")
	public ArrayList<Elemento> getRotulos() {

		logger.info("Se ingresa a /getTags");
		ArrayList<Elemento> lista = new ArrayList<Elemento>();

		ArrayList<CodigosPDF> listaCodigos = new ArrayList<CodigosPDF>(EnumSet.allOf(CodigosPDF.class));

		for (CodigosPDF elemento : listaCodigos) {
			Elemento element = new Elemento(elemento.getNombrePdf(), elemento.getElemento());
			lista.add(element);
		}

		logger.info("Se retornara la lista de elementos.");

		return lista;
	}

	@GetMapping("/getTagByCode/{fileCode}")
	public void getEjemplos(@PathVariable String fileCode, HttpServletResponse response, HttpServletRequest request) throws IOException {
		logger.info("El codigo requerido es el : "+ fileCode);
		
		
		 String pdfFileName = CodigosPDF.valueOf(fileCode).getNombrePdf();
		 
		 String basePath = "src/main/resources/static/reports/";
		
	    String fileLocation= basePath + pdfFileName + ".pdf";
	    		
	    File downloadFile= new File(fileLocation);
	
	    byte[] isr = Files.readAllBytes(downloadFile.toPath());
	    ByteArrayOutputStream out = new ByteArrayOutputStream(isr.length);
	    out.write(isr, 0, isr.length);
	
	    response.setContentType("application/pdf");
	    // Use 'inline' for preview and 'attachement' for download in browser.
	    response.addHeader("Content-Disposition", "attachement; filename=" + pdfFileName);
	
	    OutputStream os;
	    try {
	        os = response.getOutputStream();
	        out.writeTo(os);
	        os.flush();
	        os.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	        logger.info("Se produjo un error al intentar recuperar el pdf de codigo: "+fileCode);
	    }
	
//	    HttpHeaders respHeaders = new HttpHeaders();
//	    respHeaders.setContentLength(isr.length);
//	    respHeaders.setContentType(new MediaType("text", "json"));
//	    respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//	    respHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
//	    return new ResponseEntity<byte[]>(isr, respHeaders, HttpStatus.OK);
		
		
		
//		return "Codigo requerido -->"+fileCode;
	}

}
