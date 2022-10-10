package MapsObjects;



import org.openqa.selenium.By;

import ClaseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectMerWebProductos extends ClaseBase
{

	public MapObjectMerWebProductos(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}

	//MAPEO DE ELEMENTOS
	
	protected By selectPrimerProducto = By.xpath("//android.view.View[@resource-id='root-app']/android.widget.ListView[2]/android.view.View[1]"); // PRIMER PRODUCTO DEL RESULTADO DE BUSQUEDA   
	protected By btnAgregarCarrito = By.xpath("//android.widget.Button[@text='Agregar al carrito']"); // AGREGAR AL CARRITO
	
}
