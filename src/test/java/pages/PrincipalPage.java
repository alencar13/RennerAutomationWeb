package pages;

import maps.LoginMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.Driver;
import maps.PrincipalMap;

public class PrincipalPage {
    
    public WebDriver driver;
    private PrincipalMap principalMap;
	
    public PrincipalPage(WebDriver driver) {
        this.driver = driver;
        principalMap = new PrincipalMap();
        PageFactory.initElements(driver, principalMap);
    }

	public void clicarBtnLogin(){
		principalMap.btnLogin.click();
	}

	public void validaTelaLogada(){
		Driver.visibilityOf(principalMap.btnLogout);
	}

	public void descerAteElementoDesejado(int referencia, int numeroItem) {
		WebDriverWait wait = new WebDriverWait(driver, 300);
		Actions builder = new Actions(driver);
		WebElement elementRef = wait.until(ExpectedConditions
		            .elementToBeClickable(By.xpath(("(//*[@data-product-id='"+ referencia + "'])[1]"))));
		Action action = builder.moveToElement(elementRef).build();
		action.perform();
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("(//*[@data-product-id='"+ numeroItem + "'])[1]"))));
		element.click();
	}
	
	public void aguardaElementoCatalog(){
        Driver.visibilityOf(principalMap.lblFeaturesItems);
    }

	public void continueComprando() {
		Driver.visibilityOf(principalMap.continueShopping);
		principalMap.continueShopping.click();
	}

	public void irParaCarrinho() {
		Driver.visibilityOf(principalMap.viewCart);
		principalMap.viewCart.click();
	}

	public void comprarStylish() {
		descerAteElementoDesejado(7,4);
		continueComprando();
		descerAteElementoDesejado(7,4);
		continueComprando();
		descerAteElementoDesejado(7,4);
		continueComprando();

	}

	public void comprarBeautiful() {
		descerAteElementoDesejado(43,41);
		continueComprando();
		descerAteElementoDesejado(43,41);
		continueComprando();
	}

	public void comprarMenTshirt() {
		descerAteElementoDesejado(5, 2);
	}
}
