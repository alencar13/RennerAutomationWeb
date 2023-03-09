package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {

	@FindBy(css = "input[data-qa='login-email']")
    public WebElement txtEmail;
	@FindBy(css = "input[data-qa='login-password']")
    public WebElement txtSenha;
	@FindBy(css = "button[data-qa='login-button']")
    public WebElement btnEntrar;

}
