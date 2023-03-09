package pages;

import core.Driver;
import maps.PagamentoEfetuadoMap;
import maps.PagamentoMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class PagamentoEfetuadoPage {

	public WebDriver driver;
	private PagamentoEfetuadoMap pagamentoEfetuadoMap;
	CarrinhoPage carrinhoPage;

    public PagamentoEfetuadoPage(WebDriver driver) {
        this.driver = driver;
		pagamentoEfetuadoMap = new PagamentoEfetuadoMap();
		carrinhoPage = new CarrinhoPage(driver);
        PageFactory.initElements(driver, pagamentoEfetuadoMap);
    }

	public void validaMensagemSucesso() {
		assertEquals(pagamentoEfetuadoMap.lblCompraEfetuadoSucesso.getText(), "Congratulations! Your order has been confirmed!");
		driver.close();
	}
}
