package pages;

import maps.CarrinhoMap;
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

import static org.junit.Assert.assertEquals;

public class CarrinhoPage {
    
    public WebDriver driver;
    private CarrinhoMap carrinhoMap;
	
    public CarrinhoPage(WebDriver driver) {
        this.driver = driver;
        carrinhoMap = new CarrinhoMap();
        PageFactory.initElements(driver, carrinhoMap);
    }


    public void validaItensNoCarrinho(String nomeItem) {
        WebDriverWait wait = new WebDriverWait(driver, 300);
        WebElement element = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath(("//*[text()='"+ nomeItem +"']"))));
        Driver.visibilityOf(element);
        assertEquals(element.getText(), nomeItem);
    }

    public void prossegueCompra() {
        carrinhoMap.btnProsseguirCompra.click();
    }

    public void finalizaCompra() {
        adicionaComentarioCompra();
        carrinhoMap.btnFinalizaCompra.click();

    }
    public void adicionaComentarioCompra() {
        carrinhoMap.txtComentarioCompra.sendKeys("Comprando três itens conforme requisito");
    }
}
