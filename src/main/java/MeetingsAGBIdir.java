import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class MeetingsAGBIdir {

        WebDriverWait wait;
        WebDriver driver;

        public MeetingsAGBIdir(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, 30, 60);
            PageFactory.initElements(this.driver, this);
        }

        @FindBy(xpath = "//a[contains(text(),'01/01/2019 10:30')]")
        private WebElement agbiDir;

        @FindBy(xpath = "//span[@class='td-content']/a[contains(text(),'New Besluit Title')]")
        private WebElement findDecision;

        @FindBy(xpath = "//li[@class='app-table-content-row']")
        private List<WebElement> listOfMeetings;
        private String NEW_BESLUIT = "New Besluit Title";

        @FindBy(xpath = "//li[@class='app-table-content-row']//*[contains(text(),'Bekijk')]")
        private WebElement bekijk;

        @FindBy(xpath = "//a[@target='_blank']")
        private WebElement target;

        @FindBy(xpath = "//div[@id='Besluit_BesluitInhoudDirectieComiteAGBI']")
        private WebElement agbiDirText;

        @FindBy(xpath = "//nav[@class='main-nav']//a[contains(text(),'Besluiten')]")
        private WebElement goToBesluiten;

        public MeetingsAGBMraad meetingAGBIdir() {

            goToBesluiten.click();
            agbiDir.click();
            switchWindow();

            for (WebElement college : listOfMeetings) {

                if (college.getText().contains(NEW_BESLUIT)) {
                   // driver.findElement(By.xpath("//span[contains(text(),'Bekijk')]")).click();
                    bekijk.click();
                }
            }
            switchWindow();

            return new MeetingsAGBMraad(this.driver);
        }

        public void switchWindow() {

            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(0));
            driver.close();
            driver.switchTo().window(tabs2.get(1));
        }

        public boolean checkTextInAgendapunkt() {

            if
            (agbiDirText.getText().contains("directiecomite AGBI"))
            {
                return true;
            }
            return false;
        }
    }










