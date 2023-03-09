package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import core.Driver;
import maps.LoginMap;

public class LoginPage {
    
	public WebDriver driver;
    private LoginMap loginMap;
	
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        loginMap = new LoginMap();
        PageFactory.initElements(driver, loginMap);
    }


	public void fazLogin() {
        aguardaElementosLogin();
		loginMap.txtEmail.sendKeys("lucasalencarlino@hotmail.com");
		loginMap.txtSenha.sendKeys("RennerAutomation10#");
		loginMap.btnEntrar.click();
	}

	public void aguardaElementosLogin(){
        Driver.visibilityOf(loginMap.txtEmail);
        Driver.visibilityOf(loginMap.txtSenha);
        Driver.visibilityOf(loginMap.btnEntrar);
    }

}
