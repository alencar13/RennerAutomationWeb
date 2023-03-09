package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import maps.PagamentoMap;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class PagamentoPage {
    
	public WebDriver driver;
    private PagamentoMap pagamentoMap;
	CarrinhoPage carrinhoPage;
	
    public PagamentoPage(WebDriver driver) {
        this.driver = driver;
        pagamentoMap = new PagamentoMap();
		carrinhoPage = new CarrinhoPage(driver);
        PageFactory.initElements(driver, pagamentoMap);
    }

	public void aguardaElementoTela(){
		Driver.visibilityOf(pagamentoMap.btnClosePopup1);
	}

	public void confirmaFormaDePagamento() {
		fechaGoogleAds();
		carrinhoPage.finalizaCompra();
		pagamentoMap.txtNomeCartao.sendKeys("Lucas Alencar");
		pagamentoMap.txtNumeroCartao.click();
		pagamentoMap.txtNumeroCartao.sendKeys("9999 8888 7777 6666");
		pagamentoMap.txtCvc.click();
		pagamentoMap.txtCvc.sendKeys("999");
		pagamentoMap.txtExpiracaoMes.click();
		pagamentoMap.txtExpiracaoMes.sendKeys("12");
		pagamentoMap.txtExpiracaoAno.click();
		pagamentoMap.txtExpiracaoAno.sendKeys("2028");
		pagamentoMap.btnPagarConfirmarPedido.click();

	}

	private void fechaGoogleAds() {
			Driver.getDriver().get("https://automationexercise.com/checkout");
	}

}
