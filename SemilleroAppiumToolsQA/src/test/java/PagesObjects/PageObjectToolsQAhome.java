package PagesObjects;

import java.io.File;
import java.util.Properties;

import MapsObjects.MapObjectToolsQAhome;
import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectToolsQAhome extends MapObjectToolsQAhome
{

	public PageObjectToolsQAhome(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	// METODOS DE PRUEBA -->
	public void abrirAlertsFrameWindows(ReadExcelFile leer, File rutaCarpeta, Properties propiedades) throws Exception 
	{
		try {
			
			// SCROLL
			tiempoEspera(2);
			scrollVertical(rutaCarpeta, 500, 2250, 700, 2);
			
			// CLICK EN ALERTS FRAME Y WINDOWS
			tiempoEspera(2);
			click(btnAlertsFrameWindows, rutaCarpeta);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void abrirWidgets(ReadExcelFile leer, File rutaCarpeta, Properties propiedades) throws Exception 
	{
		try {
			
			// SCROLL
			tiempoEspera(2);
			scrollVertical(rutaCarpeta, 500, 2250, 500, 2);
			
			// CLICK EN ALERTS FRAME Y WINDOWS
			tiempoEspera(2);
			click(btnWidgets, rutaCarpeta);
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
}
