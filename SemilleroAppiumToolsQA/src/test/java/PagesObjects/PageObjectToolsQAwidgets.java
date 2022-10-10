package PagesObjects;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.Properties;

import MapsObjects.MapObjectToolsQAalerts;
import MapsObjects.MapObjectToolsQAhome;
import MapsObjects.MapObjectToolsQAwidgets;
import UtilidadesExcel.ReadExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectToolsQAwidgets extends MapObjectToolsQAwidgets
{

	public PageObjectToolsQAwidgets(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	// METODOS DE PRUEBA -->
	public void pruebaWidgets(ReadExcelFile leer, File rutaCarpeta, Properties propiedades) throws Exception 
	{
		try {
			
			// SCROLL
//			tiempoEspera(2);
//			scrollVertical(rutaCarpeta, 500, 1900, 1300, 1);
			
			// CLICK EN DATE PICKER
			tiempoEspera(2);
			click(btnDatePicker, rutaCarpeta);
			
			// SELECT DATE -->
			// SE ALMACENA LA NUEVAFECHA
			String fechaFinal = widgetsPruebaFecha(1, 1, 1, rutaCarpeta);
			tiempoEspera(1);
//		System.out.println(fechaFinal);
		
			// SE ENVIA LA NUEVA FECHA 
			sendkey(fechaFinal, selectDate, rutaCarpeta);
			// "ENTER" 
//			click(localizadorVariable(selectDate, fechaFinal), rutaCarpeta);
			tocarPantalla(720, 1180, rutaCarpeta);

			// DATE AND TIME -->
			tiempoEspera(2);
			// SE ALMACENA EL MES EN LETRA
			Month mesLetra= LocalDate.now().minusMonths(1).getMonth();
//		System.out.println(mesLetra);
					
			// SE ALMACENA EL DIA Y EL AÑO DE LA HORA LOCAL 
			String fechaDiaAño = widgetsPruebaFechaSinMes(1, 1, rutaCarpeta);
			// SE ALAMACENA LA HORA ACTUAL
			String horaActual = HoraSistema();
			// SE CONCADENA EL MES DE LETRA MAS EL DIA Y EL AÑO
			String fechaFinal2 = mesLetra + fechaDiaAño + " " + horaActual;
			tiempoEspera(1);
						
			// SE ENVIA LA FECHA CONCADENADA AL BOX DE LA SEGUNDA FECHA
			sendkey(fechaFinal2, dateAndTime, rutaCarpeta);
			tiempoEspera(1);
			tocarPantalla(720, 1180, rutaCarpeta);
			
			// ESPERA PARA VISUALIZAR
			tiempoEspera(3);
			System.out.println("HA FINALIZADO LA AUTOMATIZACION DE WIDGETS CON EXITO");

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
}
