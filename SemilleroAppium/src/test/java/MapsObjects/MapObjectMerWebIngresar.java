package MapsObjects;



import org.openqa.selenium.By;

import ClaseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectMerWebIngresar extends ClaseBase
{

	public MapObjectMerWebIngresar(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}

	
	//MAPEO DE ELEMENTOS
	protected By btnIngresar = By.xpath("//android.view.View[@content-desc='Ingresar']/android.widget.TextView"); // BOTON DE INGRESAR A CUENTA
	protected By txtEmail = By.xpath("//android.view.View/android.widget.EditText"); // CAJA DE TEXTO EMAIL 
	
}
