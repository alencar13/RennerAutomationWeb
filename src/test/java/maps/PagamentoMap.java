package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

public class PagamentoMap {

    @FindBy(css = "div[role='button'][class='btn skip']")
    public WebElement btnClosePopup1;
    @FindBy(css = "div[id='dismiss-button']")
    public WebElement btnClosePopup2;
    @FindBy(css = "input[data-qa='name-on-card']")
    public WebElement txtNomeCartao;
    @FindBy(css = "input[data-qa='card-number']")
    public WebElement txtNumeroCartao;
    @FindBy(css = "input[data-qa='cvc']")
    public WebElement txtCvc;
    @FindBy(css = "input[data-qa='expiry-month']")
    public WebElement txtExpiracaoMes;
    @FindBy(css = "input[data-qa='expiry-year']")
    public WebElement txtExpiracaoAno;
    @FindBy(css = "button[data-qa='pay-button']")
    public WebElement btnPagarConfirmarPedido;


}

