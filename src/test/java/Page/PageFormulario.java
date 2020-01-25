package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import Bean.BeanFormulario;
import ConfiguracionBase.ConfigBase;
import Utilitarios.GetScreenShot;
import Utilitarios.UtilitariosButton;
import Utilitarios.UtilitariosTextField;

public class PageFormulario  extends ConfigBase {
	@FindBy(name="entry.2005620554")
	WebElement inputnombreApellido;
	//entry.1140037502
	@FindBy(name="entry.1140037502")
	WebElement inputCorreo;
	//WebElement botonEnviar=  driver.findElement(By.xpath("//p/input[@value='Enviar']"));
	@FindBy(xpath="//span[contains(text(),'Siguiente')]")
	WebElement botonEnviar;
	
	@FindBy(xpath="//span[contains(text(),'Enviar')]")
	WebElement botonEnviarFinal;
	
	
	public PageFormulario()
	{
	String baseUrl = "https://docs.google.com/forms/d/e/1FAIpQLSfzLAD7DNf6fz1tu_gtbuyDZVbpSbeR_PNS3zOtlj416VZ1jA/viewform";
	PageFactory.initElements(driver, this); // si no se inicializan los WebElement da error de null pointer exception
	driver.get(baseUrl);
	}
	public void registrarFormulario( ITestResult testResult,BeanFormulario beanFormulario) throws Exception {
		UtilitariosTextField.txtField_putString(beanFormulario.getNombreApellido(), inputnombreApellido, driver, testResult);
		UtilitariosTextField.txtField_putString(beanFormulario.getCorreo(), inputCorreo, driver, testResult);
		
		GetScreenShot.capturarPantallaFile(driver, "-IngresoNombreYCorreo.png");
		Thread.sleep(5000);
		UtilitariosButton.btn_clic(botonEnviar, driver, testResult);
		UtilitariosButton.btn_clic(botonEnviarFinal, driver, testResult);
		
	}

}
