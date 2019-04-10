import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VergaderingenArchief {

    WebDriver driver;
    WebDriverWait wait;

    public VergaderingenArchief(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60, 200);
        PageFactory.initElements(this.driver, this);
    }

    private String TYPE_SCHEPEN = "Schepencollege";
    private String VERSLAG = "Verslag";
    private String PUBLIEK_VERSLAG = "Publiek Verslag";

    @FindBy(xpath = "//div[@id='containerArchive']//option[@value='Schepencollege']")
    private WebElement filterBySchepencollege;
    @FindBy(xpath = "//div[@id='containerArchive']//input[@value='FILTER']")
    private WebElement buttonFilterArchief;

    @FindBy(xpath = "//div[@id='containerArchive']//select[@id='selectSize']")
    private WebElement selectSizeArchief;
    @FindBy(xpath = "//div[@id='containerArchive']//select[@id='selectSize']/option[contains(text(),'100')]")
    private WebElement size100Archief;

    @FindBy(xpath = "//div[@id='containerArchive']//div[@class='app-table-content-row']")
    private List<WebElement> typeListArchief;

    @FindBy(xpath = "//div[@id='containerArchive']//span[contains(text(),'Schepencollege')]")
    private WebElement schepenArchief;

    @FindBy(xpath = "//div[@id='containerArchive']//select[@id='filterType']")
    private WebElement filterOpArchief;

    @FindBy(xpath = "//div[@id='containerArchive']//span[contains(text(),'Verslag')]")
    private WebElement verslagArchief;
    @FindBy(xpath = "//div[@id='containerArchive']//span[contains(text(),'Publiek Verslag')]")
    private WebElement publiekVerslagArchief;

    @FindBy(xpath = "//div[@id='containerArchive']//div[@class='app-table-content-row']")
    private WebElement rowArchief;

    @FindBy(xpath = "//div[@id='containerArchive']//option[@value='OCMW-raad']")
    private WebElement filterByOCMW;


    public CreateNewBesluit filterVergaderingen() {

        filterOpArchief.click();
        filterBySchepencollege.click();

        buttonFilterArchief.click();
        selectSizeArchief.click();
        size100Archief.click();

        return new CreateNewBesluit(this.driver);
    }

    public boolean checkTypeInArchief() {

        for (WebElement schepenType : typeListArchief) {
            if (schepenType.getText().contains(TYPE_SCHEPEN) && schepenType.getText().contains(VERSLAG) && schepenType.getText().contains(PUBLIEK_VERSLAG) ) {
                return true;
            }
        }
        return false;
    }
}


