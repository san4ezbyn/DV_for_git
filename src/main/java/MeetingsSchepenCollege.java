import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MeetingsSchepenCollege {

    WebDriverWait wait;
    WebDriver driver;

    public MeetingsSchepenCollege(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 60);
        PageFactory.initElements(this.driver, this);

    }

    @FindBy(xpath = "//*[contains(text(),'07/05/2018 13:00')]")
    private WebElement scheppencollege;


    @FindBy(xpath = "//span[@class='td-content']/a[contains(text(),'New Besluit Title')]")
    private WebElement findDecision;


    @FindBy(xpath = "//li[@class='app-table-content-row']")
    private List<WebElement> listOfMeetings;
    private String NEW_BESLUIT = "New Besluit Title";

    /*@FindBy(xpath = "//li[@class='app-table-content-row']//*[contains(text(),'Bekijk')]")
    private WebElement bekijk;*/

    @FindBy(xpath = "//div[@class='bekijkHeader'][contains(text(),'Samenvatting')]")
    private WebElement samenvattingInAgendapunkt;

    @FindBy(xpath = "//div[@id='Besluit_BesluitSamenvatting']")
    private WebElement samenvattingText;

    @FindBy(xpath = "//div[@id='Besluit_AlgemeenKader']")
    private WebElement algeeenText;

    @FindBy(xpath = "//div[@id='Besluit_WettelijkKader']")
    private WebElement juridischText;

    @FindBy(xpath = "//div[@id='Besluit_FinancieelKader']")
    private WebElement financielText;

    @FindBy(xpath = "//a[@target='_blank']")
    private WebElement target;

    @FindBy(xpath = "//div[@id='Besluit_BesluitInhoudCbs']")
    private WebElement cbsText;

    @FindBy(xpath = "//nav[@class='main-nav']//a[contains(text(),'Besluiten')]")
    private WebElement goToBesluiten;

    public MeetingsVastBureau meetingSchepenCollege() {


        scheppencollege.click();
        switchWindow();

        for (WebElement college : listOfMeetings) {

            if (college.getText().contains(NEW_BESLUIT)) {
                driver.findElement(By.xpath("//span[contains(text(),'Bekijk')]")).click();
                //bekijk.click();

            }
        }

        switchWindow();

        return new MeetingsVastBureau(this.driver);
    }

    public void switchWindow() {

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
    }

    public boolean checkTextInAgendapunkt() {


        if (
                (cbsText.getText().contains("CBS")) && (samenvattingText.getText().contains("SAMENVATTING")) &&
                        (algeeenText.getText().contains("ALGEMEEN KADER textfield")) &&
                        (juridischText.getText().contains("JURIDISCH KADER textfield")) &&
                        (financielText.getText().contains("FINANCIEEL KADER textfield"))
        ) {
            return true;
        }
        return false;

    }
}


