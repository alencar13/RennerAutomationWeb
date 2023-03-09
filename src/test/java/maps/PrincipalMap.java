package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

public class PrincipalMap {

	@FindBy(xpath = "(//h2[@class='title text-center'])[1]")
    public WebElement lblFeaturesItems;

    @FindBy(css = "button[class='btn btn-success close-modal btn-block']")
    public WebElement continueShopping;

    @FindBy(xpath = "(//*[@href='/view_cart'])[1]")
    public WebElement viewCart;

    @FindBy(css = "a[href='/login']")
    public WebElement btnLogin;

    @FindBy(css = "a[href='/logout']")
    public WebElement btnLogout;

}
