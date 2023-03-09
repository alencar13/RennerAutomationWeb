package steps;

import core.Driver;
import enums.Browser;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import maps.*;
import pages.*;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class AutomationPracticeSteps {

    PagamentoEfetuadoPage pagamentoEfetuadoPage;
    PagamentoEfetuadoMap  pagamentoEfetuadoMap;
    PagamentoPage pagamentoPage;
    PagamentoMap pagamentoMap;
    PrincipalPage principalPage;
    PrincipalMap principalMap;
    CarrinhoPage carrinhoPage;
    CarrinhoMap carrinhoMap;
	LoginPage loginPage;
	LoginMap loginMap;
    WebDriver driver;
    Driver driverWeb;

    @Before
    public void iniciaNavegador(){
        new Driver(Browser.CHROME);
    }
    
	@SuppressWarnings({ "unused", "static-access" })
	@Dado("que o site e-commerce esteja sendo exibido")
    public void queOSiteECommerceEstejaSendoExibido() throws IOException {
        driverWeb = new Driver(Browser.CHROME);
        driver = driverWeb.getDriver();
		Driver.getDriver().get("https://automationexercise.com/");

        loginPage = new LoginPage(driver);
        principalPage = new PrincipalPage(driver);
        carrinhoPage = new CarrinhoPage(driver);
        pagamentoPage = new PagamentoPage(driver);
        pagamentoEfetuadoPage = new PagamentoEfetuadoPage(driver);
    }

    @Quando("realizo login")
    public void realizo_login() {
    	loginPage.fazLogin();
    }

    @Quando("finalizo a compra")
    public void finalizo_a_compra() throws InterruptedException {
        pagamentoPage.confirmaFormaDePagamento();
    }

    @E("que o cliente esteja logado")
    public void queOClienteEstáLogado() {
        principalPage.clicarBtnLogin();
        loginPage.fazLogin();
        principalPage.validaTelaLogada();
    }

    @Quando("adicionar os produtos desejados")
    public void adicionarOsProdutosDesejados() throws InterruptedException {
        principalPage.aguardaElementoCatalog();
        principalPage.comprarStylish();
        principalPage.comprarBeautiful();
        principalPage.comprarMenTshirt();
        principalPage.irParaCarrinho();
    }

    @E("validar que os produtos foram para o carrinho")
    public void validarQueOsProdutosForamParaOCarrinho() {
        carrinhoPage.validaItensNoCarrinho("Stylish Dress", "4", "3");
        carrinhoPage.validaItensNoCarrinho("Beautiful Peacock Blue Cotton Linen Saree", "41", "2");
        carrinhoPage.validaItensNoCarrinho("Men Tshirt", "2", "1");
    }

    @Entao("efetuo a compra dos itens")
    public void efetuoACompraDosItens() {
        carrinhoPage.prossegueCompra();
        carrinhoPage.finalizaCompra();
        pagamentoPage.confirmaFormaDePagamento();
    }

    @E("valido a compra efetuada com sucesso")
    public void validoACompraEfetuadaComSucesso() {
        pagamentoEfetuadoPage.validaMensagemSucesso();
    }
}
