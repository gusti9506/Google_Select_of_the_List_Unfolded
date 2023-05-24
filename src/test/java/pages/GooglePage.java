package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class GooglePage extends BasePage {

    private String writeBar = "//textarea[@id='APjFqb']";
    private String buttonSearch = "//input[@value='Buscar con Google']";
    private String textElement = "//textarea[@value='qa automation trainee']";
    private String listBox = "//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']";

    public GooglePage() { 
        super(driver);    
    }

    public void navigateToGoogle() {
        navigateTo("https://www.google.com//");
    }
    
    public void searchInBar(String textToSearch) {
        wordsToSearch(writeBar, textToSearch);
    }

    public void clickButtonSearch() {
        List<WebElement> list = driver.findElements(By.xpath(listBox));
        System.out.println("\nContenido total de la lista desplegada:  " + list.size() + " Elementos\n");
        for (int j=0; j<list.size(); j++){
            String listAll = list.get(j).getText();
            System.out.println("Elemento de la lista desplegada:  " + listAll);
            if(listAll.contains("qa automation trainee")) {
                System.out.println("\nElemento SELECCIONADO de la lista desplegada:  " + listAll);
                list.get(j).click();
                break;
            }
        }
    }
    public String validateresults() {
        return textFromElement(textElement);

    }
}

