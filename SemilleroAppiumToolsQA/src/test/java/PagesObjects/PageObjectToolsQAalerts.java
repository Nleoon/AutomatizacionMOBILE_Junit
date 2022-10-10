package PagesObjects;

import java.io.File;
import java.util.Properties;

import MapsObjects.MapObjectToolsQAalerts;
import MapsObjects.MapObjectToolsQAhome;
import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectToolsQAalerts extends MapObjectToolsQAalerts
{

	public PageObjectToolsQAalerts(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	// METODOS DE PRUEBA -->
	public void pruebaAlerts(ReadExcelFile leer, File rutaCarpeta, Properties propiedades) throws Exception 
	{
		try {
			// CLICK EN ALERTS 
			tiempoEspera(2);
			click(btnAlerts, rutaCarpeta);
			
			// CLICK EN EL PRIMER BOTON
			tiempoEspera(2);
			click(btnAlert1, rutaCarpeta);
			tiempoEspera(1);
			click(popUpAceptar, rutaCarpeta);
			
			// CLICK EN EL SEGUNDO BOTON
			tiempoEspera(2);
			click(btnAlert2, rutaCarpeta);
			tiempoEspera(6);
			click(popUpAceptar, rutaCarpeta);
			
			// CLICK EN EL TERCER BOTON - ACEPTAR
			tiempoEspera(2);
			click(btnAlert3, rutaCarpeta);
			tiempoEspera(1);
			click(popUpAceptar, rutaCarpeta);
			
			// CLICK EN EL TERCER BOTON - CANCELAR
			tiempoEspera(2);
			click(btnAlert3, rutaCarpeta);
			tiempoEspera(1);
			click(popUpCancelar, rutaCarpeta);
			
			// CLICK EN EL CUARTO BOTON
			tiempoEspera(2);
			click(btnAlert4, rutaCarpeta);
			tiempoEspera(1);
			sendkey(leer.getCellValue(propiedades.getProperty("fileInputStream"), "toolsQA", 1, 1), popUptext, rutaCarpeta);
			tiempoEspera(1);
			click(popUpAceptar, rutaCarpeta);
			
			// ESPERA PARA VISUALIZAR
			tiempoEspera(3);
			System.out.println("HA FINALIZADO LA AUTOMATIZACION DE ALERTS CON EXITO");

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
}
