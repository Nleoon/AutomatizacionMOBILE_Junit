package PagesObjects;

import java.io.File;
import java.util.Properties;

import MapsObjects.MapObjectMerWebProductos;
import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectMerWebProductos extends MapObjectMerWebProductos
{

	public PageObjectMerWebProductos(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	// METODOS DE PRUEBA -->
		public void seleccionarPrimerProducto(ReadExcelFile leer, File rutaCarpeta, Properties propiedades) throws Exception 
		{
			try {
				
				// SELECCIONAR PRIMER RESULTADO DE BUSQUEDA
				tiempoEspera(2);
				click(selectPrimerProducto, rutaCarpeta);
				
				// SCROLL
				scrollVertical(rutaCarpeta, 500, 2150, 450, 1);
				tiempoEspera(1);
				
				// AGREGAR AL CARRITO
				tiempoEspera(2);
				click(btnAgregarCarrito, rutaCarpeta);
				
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
			
		}
}
