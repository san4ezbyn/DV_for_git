import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DeleteCopyBesluit {


        WebDriver driver;
        WebDriverWait wait;

        public DeleteCopyBesluit(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, 30, 60);
            PageFactory.initElements(this.driver, this);
        }

              private String COPY_DECISION = "Kopie van New Besluit Title";

        @FindBy(xpath = "//div[@class='app-table-content-row']")
        private List<WebElement> listOfBesluiten;

        @FindBy(xpath = "//i[@class='material-icons'][contains(text(),'delete')]")
        private WebElement deleteIcon;

        @FindBy (xpath = "//span[@class='td-content']//*[contains(text(),'Kopie van New Besluit Title')]")
        private WebElement copyDecision;


        public DeleteNewBesluit deleteCopyBesluit() throws InterruptedException {

            for (WebElement besluit : listOfBesluiten) {

             if (besluit.getText().matches(COPY_DECISION)) {

                    Actions action = new Actions(driver);
                    action.moveToElement(besluit).perform();
                    driver.findElements(By.xpath("//i[@class='material-icons'][contains(text(),'delete')]"));
                  //  Thread.sleep(4000);
                    deleteIcon.click();
                    driver.switchTo().alert().accept();
                    Thread.sleep(4000);
                    break;
                }
            }

          Actions action = new Actions(driver);
          action.moveToElement(copyDecision).perform();
          deleteIcon.click();
          driver.switchTo().alert().accept();

            return new DeleteNewBesluit(this.driver);
        }

       public boolean verifyCopyBesluitDeleted() {
            List<WebElement> listOfBesluiten;
            listOfBesluiten = driver.findElements(By.xpath("//div[@class='app-table-content-row']"));
            for (WebElement besluit : listOfBesluiten) {
               if (besluit.getText().matches(COPY_DECISION)) {

                    return false;
                }
            }
            return true;
        }
    }


