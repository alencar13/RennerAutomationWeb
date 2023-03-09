package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

public class CarrinhoMap {

	@FindBy(css = "a[class='btn btn-default check_out']")
    public WebElement btnProsseguirCompra;
    @FindBy(xpath = "//*[@class='btn btn-default check_out']")
    public WebElement btnFinalizaCompra;
    @FindBy(css = "textarea[class='form-control']")
    public WebElement txtComentarioCompra;
}
