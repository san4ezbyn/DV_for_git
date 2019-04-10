import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Vergaderingen {

    WebDriver driver;
    WebDriverWait wait;

    public Vergaderingen(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60, 200);
        PageFactory.initElements(this.driver, this);
    }

    private String TYPE_SCHEPEN = "Schepencollege";
    private String VERSLAG = "Verslag";
    private String PUBLIEK_VERSLAG = "Publiek Verslag";


    @FindBy(xpath = "//a[@class='main-nav-item'][contains(text(), 'Vergaderingen')]")
    private WebElement vergaderingenTab;

    @FindBy(xpath = "//div[@id='containerActual']//select[@id='filterType']")
    private WebElement filterOpActueel;
    @FindBy(xpath = "//div[@id='containerActual']//option[@value='Schepencollege']")
    private WebElement filterBySchepencollege;
    @FindBy(xpath = "//div[@id='containerActual']//input[@value='FILTER']")
    private WebElement buttonFilterActueel;

    @FindBy(xpath = "//div[@id='containerActual']//select[@id='selectSize']")
    private WebElement selectSizeActueel;
    @FindBy(xpath = "//div[@id='containerActual']//select[@id='selectSize']/option[contains(text(),'100')]")
    private WebElement size100Actueel;

    @FindBy(xpath = "//div[@id='containerActual']//div[@class='app-table-content-row']")
    private List<WebElement> typeListActueel;

    @FindBy(xpath = "//div[@id='containerActual']//span[contains(text(),'Schepencollege')]")
    private WebElement schepenActueel;

    @FindBy(xpath = "//div[@id='containerActual']//option[@value='OCMW-raad']")
    private WebElement filterByOCMW;

    public VergaderingenArchief filterVergaderingen() {

       /* ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));

        vergaderingenTab.click();*/
        filterOpActueel.click();
        filterBySchepencollege.click();
        buttonFilterActueel.click();
        selectSizeActueel.click();
        size100Actueel.click();

        return new VergaderingenArchief(this.driver);
    }

    public boolean checkTypeInActueel() {

        for (WebElement schepenType : typeListActueel) {
            if (schepenType.getText().contains(TYPE_SCHEPEN)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkVerslagInActueel() {

        for (WebElement schepenType : typeListActueel) {
            if (schepenType.getText().contains(VERSLAG) || schepenType.getText().contains(PUBLIEK_VERSLAG)){
                return true;
            }
        }
        return false;
    }
}
