package PagesObjects;

import java.io.File;
import java.util.Properties;

import MapsObjects.MapObjectGoogleChrome;
import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectGoogleChrome extends MapObjectGoogleChrome
{

	public PageObjectGoogleChrome(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	// METODOS DE PRUEBA -->
	public void abrirToolsQA(ReadExcelFile leer, File rutaCarpeta, Properties propiedades) throws Exception 
	{
		try {
			
			// CERRAR LA PESTAÑA DE GOOGLE 
			tiempoEspera(2);
			click(cerrarPestaña, rutaCarpeta);
			
			// NUEVA PESTAÑA
			tiempoEspera(2);
			click(nuevaPestaña, rutaCarpeta);
			
			// ABRIR MERCADOLIBRE
			tiempoEspera(2);
			sendkey(leer.getCellValue(propiedades.getProperty("fileInputStream"), "toolsQA", 1, 0), busquedaGoogleChrome, rutaCarpeta);
			
			// CLICK EN EL PRIMER LINK DE BUSQUEDA
			tiempoEspera(2);
			click(primerURL, rutaCarpeta);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
}
