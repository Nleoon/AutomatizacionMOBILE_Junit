package PagesObjects;

import java.io.File;
import java.util.Properties;

import MapsObjects.MapObjectCalculadora;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import UtilidadesExcel.ReadExcelFile;

public class PageObjectCalculadora extends MapObjectCalculadora
{

	public PageObjectCalculadora(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	
	
	// 1. METODO DE PRUEBA - XPATH DINAMICO Y EXCEL
		public void operacionCalculadoraDinamica(ReadExcelFile leer, File rutaCarpeta, Properties propiedades) throws Exception
		{
			try {
				
				// CLICK EN EL PRIMER NUMERO DE LA OPERACION
				separarNumeros(leer.getCellValue(propiedades.getProperty("fileInputStream"), "calculadora",1,1), btnNumeros, rutaCarpeta);			
//				click(localizadorVariable(btnNumeros,leer.getCellValue(propiedades.getProperty("fileInputStream"), "operacionesCalculadora",1,1)), rutaCarpeta); 
				
				// CLICK EN EL OPERADOR ARITMETICO
				click(localizadorVariable(btnOperadoresAritmeticos,leer.getCellValue(propiedades.getProperty("fileInputStream"), "calculadora",1,0)), rutaCarpeta);
				
				// CLICK EN EL SEGUNDO NUMERO DE LA OPERACION
				separarNumeros(leer.getCellValue(propiedades.getProperty("fileInputStream"), "calculadora",1,2), btnNumeros, rutaCarpeta);
//				click(localizadorVariable(btnOperadoresAritmeticos,leer.getCellValue(propiedades.getProperty("fileInputStream"), "operacionesCalculadora",1,2)), rutaCarpeta);
				
				// CLICK EN IGUAL PARA EL RESULTADO DE LA OPERACION
				click(igual, rutaCarpeta);
				tiempoEspera(2);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		}	
}
