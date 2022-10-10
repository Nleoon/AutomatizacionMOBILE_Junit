package MapsObjects;

import org.openqa.selenium.By;

import ClaseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectMerApp extends ClaseBase
{

	public MapObjectMerApp(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}
	
	
	// ELEMENTOS DE PAGINA HOME - MERCADO LIBRE
	protected By linkIngresarCuenta = By.id("com.mercadolibre:id/button_footer_secondary"); // ENLACE DE "INGRESAR A MI CUENTA"
	protected By boxtxtClave = By.id("com.mercadolibre:id/andes_textfield_edittext");  // CAJA DE TEXTO PARA INGRESAR LA CLAVE
	protected By btnIngresar = By.id("com.mercadolibre:id/login_password_btn_continue");  // CAJA DE TEXTO PARA INGRESAR LA CLAVE
	protected By boxtxtBusqueda = By.id("com.mercadolibre:id/ui_components_action_bar_search_field");  // CAJA DE TEXTO PARA BUSCAR PRODUCTO
	protected By Busqueda = By.id("com.mercadolibre:id/search_input_edittext");  // CAJA DE TEXTO PARA INGRESAR EL PRODUCTO
	protected By primerBusqueda = By.xpath("//android.widget.TextView[1]");  // CAJA DE TEXTO PARA INGRESAR EL PRODUCTO
	protected By selectPrimerProducto = By.xpath("//android.view.View[1]");  // SELECCIONAR EL PRIMER PRODUCTO DE LA BUSQUEDA
	protected By btnAgregarCarrito = By.xpath("//android.widget.Button[@content-desc='Agregar al carrito.']");  // BOTON DE AGREGAR CARRITO
	protected By btnVerCarrito = By.id("com.mercadolibre:id/cart_congrats_cart_info_main_action");  // BOTON DE VER CARRITO
	protected By btnMenuDespegable = By.xpath("//android.widget.ImageButton[@content-desc='Menú']");  // BOTON DE MENU DESPLEGABLE
	protected By btnCerrarSesion = By.id("com.mercadolibre:id/my_account_user_footer_logout_icon");  // BOTON DE CERRAR SESION
	protected By confirmCerrarSesion = By.id("android:id/button1"); // CONFIRMAR EL CIERRE DE SESION
	
	protected By scroll = By.id("com.mercadolibre:id/components_container");  // BOTON DE AGREGAR CARRITO

}
