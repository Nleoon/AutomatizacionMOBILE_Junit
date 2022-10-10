package RunPruebas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ClaseBase.ClaseBase;
import PagesObjects.PageObjectCalculadora;
import PagesObjects.PageObjectMerApp;
import PagesObjects.PageObjectMerWebIngresar;
import PagesObjects.PageObjectMerWebInicio;
import PagesObjects.PageObjectMerWebProductos;
import UtilidadesExcel.MyScreenRecorder;
import UtilidadesExcel.ReadExcelFile;
import UtilidadesExcel.WriteExcelFile;
import io.appium.java_client.AppiumDriver;

public class RunPrueba {
	
	// CREAR LAS VARIABLES GLOBALES

	@SuppressWarnings("rawtypes")
	private AppiumDriver driver;
	
	// EXCEL
	ReadExcelFile leer;
	WriteExcelFile escribir;
	
	// CLASE BASE Y SCREENSHOTS
	ClaseBase claseBase;
	
	// PROPERTIES
	Properties propiedades;
	
	// CALCULADORA
	PageObjectCalculadora calculadora;
	
	// MERCADOLIBRE WEB
	PageObjectMerWebInicio inicioMercadolibre;
	PageObjectMerWebProductos productosMercadolibre;
	PageObjectMerWebIngresar loginMercadoLibre;
	
	// MERCADOLIBRE APP
	PageObjectMerApp mercadolibreAPP;
	
	
	
	// CREAR LAS ANOTACIONES JUNIT

	@Before
	public void setUp() throws IOException
	{
		
		// PROPERTIES -->
		// INSTANCIAR LA CLASE PROPIEDADES DE JAVA UTIL
		propiedades = new Properties();
		
		// EXCEL -->
		// INSTANCIAR LAS CLASES DE EXCEL Y CONVERTIRLAS EN OBJETOS		
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();

		// CREAR VARIABLE TIPO INPUTSTREAM
		InputStream entrada = null;
		
		
		// VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		try {
			entrada = new FileInputStream("./Properties/datos.properties");
			propiedades.load(entrada);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
 	
	
	// MERCADOLIBRE WEB -->
/*
	@Test
	public void pruebaMercadoLibreWEB() throws Exception 
	{
			
	if (leer.getCellValue(propiedades.getProperty("fileInputStream"), "mercadolibreWEB", 4, 0).equals("SI"))
	{
		// CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClaseBase.appiumDriverConnetion(propiedades);
		// INSTANCIA CLASE BASE
		claseBase = new ClaseBase(driver);
		// INSTANCIAS MERCADOLIBRE WEB
		inicioMercadolibre = new PageObjectMerWebInicio(driver);
		productosMercadolibre = new PageObjectMerWebProductos(driver);
		loginMercadoLibre = new PageObjectMerWebIngresar(driver); 
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
		
		// INICIAR EL PROCESO DE GRABACION
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		
		
		// LLAMADO DE METODOS -->
		inicioMercadolibre.abrirMercadoLibreWeb(leer, rutaCarpeta, propiedades);
		productosMercadolibre.seleccionarPrimerProducto(leer, rutaCarpeta, propiedades);
		loginMercadoLibre.ingresarMercadolibre(leer, rutaCarpeta, propiedades);
		
		
		// FINALIZAR EL PROCESO DE GRABACION
		MyScreenRecorder.stopRecording();
		
	} else {
		
		System.out.println("LA AUTOMATIZACION DE MERCADOLIBRE WEB NO SE EJECUTARA");
		
	}
	
		
	}
*/


	
	// CALCULADORAAA ---->

	@Test
	public void pruebaCalculadora() throws Exception 
	{
	
	if (leer.getCellValue(propiedades.getProperty("fileInputStream"), "calculadora", 4, 0).equals("SI"))
	{
		// CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClaseBase.appiumDriverConnetion(propiedades);
		// INSTANCIA CLASE BASE
		claseBase = new ClaseBase(driver);
		// INSTANCIAS MERCADOLIBRE WEB
		calculadora = new PageObjectCalculadora(driver);
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
		
		// INICIAR EL PROCESO DE GRABACION
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		
		
		// LLAMADO DE METODOS -->
		calculadora.operacionCalculadoraDinamica(leer, rutaCarpeta, propiedades);
		
		
		// FINALIZAR EL PROCESO DE GRABACION
		MyScreenRecorder.stopRecording();
		
	} else {
		
		System.out.println("LA AUTOMATIZACION DE LA CALCULADORA NO SE EJECUTARA");
		
	}
	
		 
	}


	

/*
	// MERCADOLIBRE APP ---->
		@Test
		public void pruebaCalculadora() throws Exception 
		{
		
		if (leer.getCellValue(propiedades.getProperty("fileInputStream"), "mercadolibreAPP", 4, 0).equals("SI"))
		{
			// CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
			driver = ClaseBase.appiumDriverConnetion(propiedades);
			// INSTANCIA CLASE BASE
			claseBase = new ClaseBase(driver);
			// INSTANCIAS MERCADOLIBRE WEB
			mercadolibreAPP = new PageObjectMerApp(driver); 
			
			//OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
			
			// LLAMADO DE METODOS -->
			mercadolibreAPP.pruebaCarritoMER(leer, rutaCarpeta, propiedades);
			
		} else {
			
			System.out.println("LA AUTOMATIZACION DE MERCADOLIBRE APP NO SE EJECUTARA");
			
		}
		
			
		}
*/
	
@After
	public void cerrar()
	{
		// CERRAR PROCESO
		driver.quit();
	}
	
}

