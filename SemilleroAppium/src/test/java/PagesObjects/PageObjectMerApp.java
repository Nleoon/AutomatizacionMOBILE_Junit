package PagesObjects;

import java.io.File;
import java.util.Properties;

import MapsObjects.MapObjectMerApp;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import UtilidadesExcel.ReadExcelFile;

public class PageObjectMerApp extends MapObjectMerApp
{

	public PageObjectMerApp(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}

	
	// 1. METODO DE PRUEBA - INICIAR SESION, AGREGAR PRODUCTO Y CERRAR SESION
	
		public void pruebaCarritoMER(ReadExcelFile leer, File rutaCarpeta, Properties propiedades) throws Exception
		{		
				
			try {
			
				// CLICK EN EL LINK DE INGRESAR CUENTA
				tiempoEspera(4);
				click(linkIngresarCuenta, rutaCarpeta);
				tiempoEspera(2);
				
				// ENVIAR LA CONTRASEÑA
				sendkey(leer.getCellValue(propiedades.getProperty("fileInputStream"), "mercadolibreAPP",1,0), boxtxtClave, rutaCarpeta);
				tiempoEspera(2);
			
				// CLICK EN EL BOTON DE INGRESAR
				click(btnIngresar, rutaCarpeta);
				tiempoEspera(2);

				// CLICK EN LA CAJA DE TEXTO DE BUSQUEDA
				tiempoEspera(3);
				click(boxtxtBusqueda, rutaCarpeta);
				tiempoEspera(2);
							
				// ENVIAR EL PRODUCTO A BUSCAR
				sendkey(leer.getCellValue(propiedades.getProperty("fileInputStream"), "mercadolibreAPP",1,1), Busqueda, rutaCarpeta);			
				tiempoEspera(2);
				
				// SELECCIONAR PRIMER RESULTADO DE BUSQUEDA
				click(primerBusqueda, rutaCarpeta);
				tiempoEspera(2);
				
				// SELECCIONAR EL PRIMER PRODUCTO DE LA BUSQUEDA
				click(selectPrimerProducto, rutaCarpeta);
				tiempoEspera(2);
				
				// SCROLL
				scrollVertical(rutaCarpeta, 500, 2300, 300, 1);
				tiempoEspera(2);
				
				// AGREGAR AL CARRITO
				click(btnAgregarCarrito, rutaCarpeta);
				tiempoEspera(2);
				
				// VER CARRITO
				tiempoEspera(2);
				click(btnVerCarrito, rutaCarpeta);
				tiempoEspera(2);
				
				// ABRIR EL MENU DESPEGABLE
				click(btnMenuDespegable, rutaCarpeta);
				tiempoEspera(2);
				
				// MI CUENTA
				tocarPantalla(107, 1670, rutaCarpeta);
				tiempoEspera(2);
				
				// SCROLL
				scrollVertical(rutaCarpeta, 500, 2200, 670, 1);
				tiempoEspera(2);
				
				// CERRAR SESION
				click(btnCerrarSesion, rutaCarpeta);
				click(confirmCerrarSesion, rutaCarpeta);
				
				
				// CONFIRMACIÓN 
				System.out.println(" LA AUTOMATIZACION HA FINALIZADO CON EXITO");
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		}	
}
