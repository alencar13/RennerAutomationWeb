package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import enums.Browser;

import java.io.File;
import java.io.IOException;

public class Driver {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String nomeCenario;
    private static File diretorio;
    private static int numPrint;

    public static File getDiretorio() {
        return diretorio;
    }

    public static String getNomeCenario() {
        return nomeCenario;
    }

    public static void setNomeCenario(String nomeCenario) {
        Driver.nomeCenario = nomeCenario;
    }

    public Driver(Browser navegador){
        switch (navegador){
            case CHROME:
                startChrome();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                startChrome();
                break;
        }
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    private void startChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);

        boolean headless = Boolean.parseBoolean(System.getProperty("headless"));

        chromeOptions.setHeadless(headless);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1280, 720));

    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void visibilityOf(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void criaDiretorio(){
        String caminho = "src/test/resources/evidencias";
        diretorio = new File(caminho+"/"+nomeCenario);
        diretorio.mkdir();
        numPrint = 0;
    }

}
