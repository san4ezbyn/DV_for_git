import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DeleteNewBesluit {

    WebDriver driver;
    WebDriverWait wait;

    public DeleteNewBesluit(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 60);
        PageFactory.initElements(this.driver, this);
    }

    private String NEW_DECISION = "New Besluit Title";

    @FindBy(xpath = "//span[@class='td-content']//*[contains(text(),'New Besluit Title')]")
    private WebElement titleOfBesluit;

    @FindBy(xpath = "//div[@class='app-table-content-row']")
    private List<WebElement> listOfBesluitens;

    @FindBy(xpath = "//i[@class='material-icons'][contains(text(),'delete')]")
    private WebElement deleteIcon;

    @FindBy (xpath = "//span[@class='td-content']//*[contains(text(),'New Besluit Title')]")
    private WebElement decision;

    public Home deleteBesluit() throws InterruptedException {

        for (WebElement besluit : listOfBesluitens) {
            if (besluit.getText().matches(NEW_DECISION)) {
                Actions action = new Actions(driver);
                action.moveToElement(besluit).perform();
                driver.findElements(By.xpath("//i[@class='material-icons'][contains(text(),'delete')]"));
                deleteIcon.click();
                driver.switchTo().alert().accept();
                Thread.sleep(1000);
            }
        }

        Actions action = new Actions(driver);
        action.moveToElement(decision).perform();
        deleteIcon.click();
        driver.switchTo().alert().accept();

        return new Home(this.driver);
    }


    public boolean verifyBesluitDeleted() {
        driver.navigate().refresh();
        List<WebElement> listOfBesluiten;
        listOfBesluiten = driver.findElements(By.xpath("//div[@class='app-table-content-row']"));
        for (WebElement besluit : listOfBesluiten) {
            if (besluit.getText().matches(NEW_DECISION)) {
                return false;
            }
        }
        return true;
    }
}
