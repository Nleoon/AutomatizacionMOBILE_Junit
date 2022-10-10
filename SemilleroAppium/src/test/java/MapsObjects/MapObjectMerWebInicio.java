package MapsObjects;

import org.openqa.selenium.By;

import ClaseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectMerWebInicio extends ClaseBase
{

	public MapObjectMerWebInicio(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}

	// MAPEO DE ELEMENTOS
	
	protected By cerrarPestaña = By.id("com.android.chrome:id/tab_switcher_button"); // CERRAR PESTAÑA
	protected By nuevaPestaña = By.xpath("//android.widget.ImageView[@content-desc='Nueva pestaña']"); // NUEVA PESTAÑA - CHROME
	protected By busquedaGoogleChrome = By.id("com.android.chrome:id/search_box_text"); // CAJA DE BUSQUEDA GOOGLE
	protected By primerURL = By.xpath("//android.view.ViewGroup/android.widget.LinearLayout[1]"); // PRIMER URL DE BUSQUEDA
	protected By txtbuscarProducto =By.xpath("//android.widget.EditText[@resource-id='cb1-edit']"); //CAJA DE BUSQUEDA MERCADOLIBRE
	protected By btnLupa = By.xpath("//android.view.View/android.view.View[3]/android.widget.Button"); // BOTON DE LUPA PARA BUSCAR
}

