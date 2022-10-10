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
import PagesObjects.PageObjectGoogleChrome;
import PagesObjects.PageObjectToolsQAalerts;
import PagesObjects.PageObjectToolsQAhome;
import PagesObjects.PageObjectToolsQAwidgets;
import UtilidadesExcel.GenerarReportePdf;
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
		
	// GOOGLE CHROME
	PageObjectGoogleChrome inicioGoogle;
	
	// TOOLS QA
	PageObjectToolsQAhome toolsQA;
	PageObjectToolsQAalerts alerts;
	PageObjectToolsQAwidgets widgets;
	
	// REPORTES PDF
	GenerarReportePdf generarReportePdf;
	
	
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

		// REPORTES PDF -->
		generarReportePdf = new GenerarReportePdf();
		
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
 	

	
	// TOOLS QA WEB -->
	
	// TOOLS QA - ALERT'S
	@Test
	public void pruebaAlertsFrameWindows() throws Exception 
	{
			
	if (leer.getCellValue(propiedades.getProperty("fileInputStream"), "toolsQA", 4, 0).equals("SI"))
	{
		// CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClaseBase.appiumDriverConnetion(propiedades);
		// INSTANCIA CLASE BASE
		claseBase = new ClaseBase(driver);
		// INSTANCIAS MERCADOLIBRE WEB
		inicioGoogle = new PageObjectGoogleChrome(driver);
		toolsQA = new PageObjectToolsQAhome(driver);
		alerts = new PageObjectToolsQAalerts(driver); 
		
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
		
		
		// INICIAR EL PROCESO DE GRABACION
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		
		// LLAMADO DE METODOS -->
		// INICIO DE GOOGLE Y BUSCAR PAGINA
		inicioGoogle.abrirToolsQA(leer, rutaCarpeta, propiedades);
		//  PAGINA HOME DE TOOLS QA Y ABRIR ALERTS
		toolsQA.abrirAlertsFrameWindows(leer, rutaCarpeta, propiedades);
		// PASO A PASO DE PRUEBA ALERTS
		alerts.pruebaAlerts(leer, rutaCarpeta, propiedades); 
		
		// FINALIZAR EL PROCESO DE GRABACION
		MyScreenRecorder.stopRecording();
		
	} else {
		
		System.out.println("LA AUTOMATIZACION DE TOOLS QA ALERTS, FRAME Y WINDOWS WEB NO SE EJECUTARA");
		
	}
	
		
	}

	
	// TOOLS QA - WIDGETS
		@Test
		public void pruebaWidgets() throws Exception 
		{
				
			if (leer.getCellValue(propiedades.getProperty("fileInputStream"), "toolsQA", 4, 0).equals("SI"))
			{
				// CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
				driver = ClaseBase.appiumDriverConnetion(propiedades);
				// INSTANCIA CLASE BASE
				claseBase = new ClaseBase(driver);
				// INSTANCIAS TOOLS QA
				inicioGoogle = new PageObjectGoogleChrome(driver);
				toolsQA = new PageObjectToolsQAhome(driver);
				widgets = new PageObjectToolsQAwidgets(driver);
				
				
				// GENERAR PDF -->
				// IMAGEN DE ENCABEZADO
				generarReportePdf.setRutaImagen(propiedades.getProperty("rutaImagenReporteToolsQA"));
				// INICIAR CREACION DEL PDF
// ***				generarReportePdf.crearPlantilla(null, null);
			
			
				//OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
			
				
				// INICIAR EL PROCESO DE GRABACION
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				
				
				// LLAMADO DE METODOS -->
				// INICIAR GOOGLE Y BUSCAR PAGINA
				inicioGoogle.abrirToolsQA(leer, rutaCarpeta, propiedades);
				// PAGINA HOME DE TOOLS QA Y ABRIR WIDGETS
				toolsQA.abrirWidgets(leer, rutaCarpeta, propiedades);
				// PASO A PASO DE PRUEBA WIDGETS
				widgets.pruebaWidgets(leer, rutaCarpeta, propiedades);
				
				
				// FINALIZAR EL PROCESO DE GRABACION
				MyScreenRecorder.stopRecording();
				
			
			} else {
			
				System.out.println("LA AUTOMATIZACION DE TOOLS QA WIDGETS WEB NO SE EJECUTARA");
			
			}
		
			
		}
	
	
		@After
		public void cerrar()
			{
				// CERRAR PROCESO
				driver.quit();
			}
	
}

