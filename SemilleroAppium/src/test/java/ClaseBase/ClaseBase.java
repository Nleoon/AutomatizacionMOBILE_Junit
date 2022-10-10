package ClaseBase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import UtilidadesExcel.ReadExcelFile;

public class ClaseBase {

	
	protected AppiumDriver<MobileElement> driver;

	//CONSTRUCTOR DE CLASE
	public ClaseBase(WebDriver driver) 
	{
		super();
	}
	
	//METODO DE NAVEGADOR
	
		@SuppressWarnings("rawtypes")
		public static AppiumDriver appiumDriverConnetion(Properties propiedades) 
		{
			AppiumDriver driver = null; 
			try
			{
				// CREARLAS CAPABILITYS DEL MOVIL
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("platformName", propiedades.getProperty("platformName"));
				caps.setCapability("deviceName", propiedades.getProperty("deviceName"));
				caps.setCapability("platformVersion", propiedades.getProperty("platformVersion"));
				caps.setCapability("appPackage", propiedades.getProperty("appPackage"));
				caps.setCapability("appActivity", propiedades.getProperty("appActivity"));
//				caps.setCapability("appPackage",leer.getCellValue(propiedades.getProperty("fileInputStream"), ""+HojaExcel+"", Fila, Columna));
//				caps.setCapability("appActivity",leer.getCellValue(propiedades.getProperty("fileInputStream"), ""+HojaExcel+"", Fila, Columna+1));
				caps.setCapability("noReset", propiedades.getProperty("noReset"));
				caps.setCapability("autoGrantPermissions", propiedades.getProperty("autoGrantPermissions"));
				
				caps.setCapability("unicodeKeyboard", "true");                                     
				caps.setCapability("resetKeyboard", "true");
				
				//INSTANCIAR APPIUM DRIVER
				try 
				{
					System.out.println("cargando capability de appium, favor esperar ....");
					driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);					
					
				} 
				catch (MalformedURLException e) 
				{
					System.out.println(e.getMessage());
				}
			return driver;
			}
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
			return driver;
		}
		
		
		// METODOS -->
		
		// XPATH DINAMICO -->
	    public By localizadorVariable(By locator, String valor) throws Exception 
	    {
	    	String jj = locator.toString().replace("{0}", valor);
	    	String kk = jj.replace("By.xpath:", "");
	    	By localizador = By.xpath(kk);
	    	
	    	return localizador;
	    }
	    

		// SCREENSHOT -->
		
		// METODOD PARA GUARDAR LA FECHA DEL SISTEMA
		public String fechaHora() {
			// TOMAMOS LA FECHA DEL SISTEMA
			LocalDateTime fechaSistema = LocalDateTime.now();
			// DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
			// DAR FORMATO A LA FECHA DEL SISTEMA
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
		}
			
		// METODO PARA GUARDAR LA HORA DEL SISTEMA
		public String HoraSistema() {
			// TOMAMOS LA HORA DEL SISTEMA
			LocalTime horaSistema = LocalTime.now();
			// DEFINIR FORMATO DE HORA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
			// DAR FORMATO A LA HORA DEL SISTEMA
			String hora = fecha.format(horaSistema);
			return hora;
		}
		
		
		// METODO PARA TOMAR LA CAPTURA DE PANTALLA
		public void ScreenShot(File rutaCarpeta) throws Exception {
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
		}
		
		
		// METODO PARA CREAR LA CARPETA DONDE SE ALMACENAN LOS SCREEN'S
		public File crearCarpeta(Properties propiedades, String nomTest) {
			// ALMACENAMOS LA FECHA DEL SISTEMA
			String fecha = fechaHora();
			// CREAMOS EL NOMBRE DE LA CARPETA
			String nomCarpeta = nomTest+"-"+fecha;
			// OBTENEMOS LA RETA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
			File directorio = new File("./output/"+nomCarpeta);
			// CREAMOS LA CARPETA
			directorio.mkdir();
			return directorio;
		}
		
		
			
		// METODOS BASE -->
		
		// METODO CLICK
		public void click(By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).click();
			tiempoEspera(3);
			ScreenShot(rutaCarpeta);
		}
		
		
		
		// METODO BORRAR
		public void borrar(By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).clear();
			tiempoEspera(2);
			ScreenShot(rutaCarpeta);
		}
		
		
		
		// METODO ENVIAR-TEXTO (SENDKEY))
		public void sendkey(String inputText, By locator, File rutaCarpeta) throws Exception
		{
			try {
				driver.findElement(locator).sendKeys(inputText);
				tiempoEspera(2);
				ScreenShot(rutaCarpeta);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
		// METODO ENTER (SUBMIT)
		public void submit(By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).submit();
			tiempoEspera(2);
			ScreenShot(rutaCarpeta);
		}
		
		
		// METODO ENTER
		public void enter(By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).sendKeys(Keys.chord(Keys.ENTER));
			//driver.findElement(locator).clear();
			tiempoEspera(2);
			ScreenShot(rutaCarpeta);
		}

		
		// METODO TIEMPO DE ESPERA
		public void tiempoEspera(long tiempo) throws InterruptedException
		{
			Thread.sleep(tiempo*1000);
		}
		
		
		
		// METODO DE SELECCIONAR NUMEROS DE MAS DE 1 CIFRA
		public void separarNumeros(String numeros, By locator, File rutaCarpeta) throws Exception
		{    
			String[] num = new String[numeros.length()];
			
			for (int i=0; i<numeros.length(); i++) {
				num[i]= String.valueOf(numeros.charAt(i));
				click(localizadorVariable(locator,num[i]), rutaCarpeta);
			}
		}
			
		
		// SCROLL
		public void scrollVertical(File rutaCarpeta, int xini,int yini, int yfinal, int iteraciones) throws Exception
	    {
	        
	        for (int i = 1 ;i<=iteraciones;i++)
	        {
	            @SuppressWarnings("rawtypes")
	            TouchAction touch = new TouchAction(driver);
	            touch.press(PointOption.point(xini,yini))
	            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
	            .moveTo(PointOption.point(xini,yfinal))
	            .release().perform();
	            ScreenShot(rutaCarpeta);
	        }
	    }
		
		
		// TOCAR PANTALLA
		public void tocarPantalla(int x, int y, File rutaCarpeta) throws Exception
	    {
	        @SuppressWarnings("rawtypes")
	        TouchAction touch = new TouchAction(driver);
	        touch.press(PointOption.point(x,y)).release().perform();
	        ScreenShot(rutaCarpeta);
	        
	    }
		
		public void submit2(By locator, File rutaCarpeta) throws Exception 
		{
	        String cmd = "adb shell input keyevent 66";
	        Runtime.getRuntime().exec(cmd);
	        tiempoEspera(1);
	        ScreenShot(rutaCarpeta);
	    }
}
