package PagesObjects;

import java.io.File;
import java.util.Properties;

import MapsObjects.MapObjectMerWebIngresar;
import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectMerWebIngresar extends MapObjectMerWebIngresar
{

	public PageObjectMerWebIngresar(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	// METODOS DE PRUEBA -->
		public void ingresarMercadolibre(ReadExcelFile leer, File rutaCarpeta, Properties propiedades) throws Exception 
		{
			try {
				
				// SELECCIONAR PRIMER RESULTADO DE BUSQUEDA
				tiempoEspera(2);
				click(btnIngresar, rutaCarpeta); 
								
				// AGREGAR AL CARRITO
				tiempoEspera(2);
				sendkey(leer.getCellValue(propiedades.getProperty("fileInputStream"), "mercadolibreWEB", 1, 2), txtEmail, rutaCarpeta);
				tiempoEspera(3);
				
 				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
			
		}
}
