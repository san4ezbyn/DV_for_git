import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MeetingsAGBIraad {

        WebDriverWait wait;
        WebDriver driver;

        public MeetingsAGBIraad(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, 30, 60);
            PageFactory.initElements(this.driver, this);
        }

        @FindBy(xpath = "//a[contains(text(),'25/07/2019 00:00')]")
        private WebElement agbiRaad;

        @FindBy(xpath = "//span[@class='td-content']/a[contains(text(),'New Besluit Title')]")
        private WebElement findDecision;

        @FindBy(xpath = "//li[@class='app-table-content-row']")
        private List<WebElement> listOfMeetings;
        private String NEW_BESLUIT = "New Besluit Title";

        @FindBy(xpath = "//li[@class='app-table-content-row']//*[contains(text(),'Bekijk')]")
        private WebElement bekijk;

        @FindBy(xpath = "//a[@target='_blank']")
        private WebElement target;

        @FindBy(xpath = "//div[@id='Besluit_BesluitInhoudRaadVanBestuurAGBI']")
        private WebElement agbiRaadText;

        @FindBy(xpath = "//nav[@class='main-nav']//a[contains(text(),'Besluiten')]")
        private WebElement goToBesluiten;

        public Search meetingsAGBIraad() {

            goToBesluiten.click();
            agbiRaad.click();
            switchWindow();

            for (WebElement college : listOfMeetings) {

                if (college.getText().contains(NEW_BESLUIT)) {
                    //driver.findElement(By.xpath("//span[contains(text(),'Bekijk')]")).click();
                    bekijk.click();
                }
            }
            switchWindow();

            return new Search(this.driver);
        }

        public void switchWindow() {

            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(0));
            driver.close();
            driver.switchTo().window(tabs2.get(1));
        }

        public boolean checkTextInAgendapunkt() {

            if
            (agbiRaadText.getText().contains("AGBI raad"))
            {
                return true;
            }
            return false;
        }
    }













