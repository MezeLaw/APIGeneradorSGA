package com.meze.APIGeneradorSGA.enums;
public enum CodigosPDF {


	diluyenteIsoprint("diluyenteIsoprint","Diluyente Isoprint"),
	cleanAlPlus("cleanAlPlus", "Clean Al Plus"),
	gomaArabigaNatural("gomaArabigaNatural","Goma Arabiga Natural"),
	limpiadorProfundoDeMantillasRevividor("limpiadorProfundoDeMantillasRevividor", "Limpiador Profundo de Mantillas - Revividor"),
	limpiadorProfundoPlusDescristalizador("limpiadorProfundoPlusDescristalizador", "Limpiador Profundo Plus - Descristalizador"),
	reveladorPositivo("reveladorPositivo", "Revelador Positivo"),
	fountGreenSF("fountGreenSF", "Fount Green SF"),
	oSSoyPlus("oSSoyPlus", "Os Soy Plus"),
	universalElectroestaticEtch("universalElectroestaticEtch", "Universal Electroestatic Etch");
	

	private final String nombrePDF;
	private final String elemento;

	CodigosPDF(String nombrePdf, String elemento) {
		this.nombrePDF = nombrePdf;
		this.elemento = elemento;
	}

	public String getNombrePdf() {
		return this.nombrePDF;
	}

	public String getElemento() {
		return this.elemento;
	}
}