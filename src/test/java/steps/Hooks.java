package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;
import utilities.CapturaEvidencia;

import java.io.IOException;

public class Hooks extends BasePage {
    String nombreDocumento = "XReports_Evidence\\EvidenceTest[IMG]\\Evidence.docx";
    String dirEvidencias = "XReports_Evidence\\EvidenceTest[IMG]\\";
    public Hooks() {
        super(driver);
    }
    @After
    public void tearDown(Scenario scenario) throws IOException, InvalidFormatException, InterruptedException {
        String scenryName = scenario.getName();
        CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "ScreenShoot.png", nombreDocumento, "Seleccion de 'qa automation trainee' de la lista desplegada");

        if(scenario.isFailed()){
           final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot, "image/png", scenryName);
        }
    }
}
