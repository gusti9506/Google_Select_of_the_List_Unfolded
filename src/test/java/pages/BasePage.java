package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class
BasePage {
    public static WebDriver driver;
    private static WebDriverWait wait;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
    public static void closeDriver() {
        driver.quit();
    }

    // ********** Metodo para ubicar el objeto del HTML.
    private WebElement Element(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }



    // ********************** Metodos para busqueda en "Google" ****************************
    public void wordsToSearch(String locator, String textToSearch) {
        Element(locator).clear();
        Element(locator).sendKeys(textToSearch);
    }

    public void clickElement(String locator) {
        Element(locator).click();
    }
    public String textFromElement(String  locator) {
        return Element(locator).getText();
    }


    //******************* Metodo para cerrar los Pops Alert. ***************************
    public void dissmisAlert() {
        driver.switchTo().alert().dismiss();
    }

}
