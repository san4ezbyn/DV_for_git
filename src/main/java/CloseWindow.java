import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class CloseWindow {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//nav[@class='main-nav']//a[contains(text(),'Besluiten')]")
    private WebElement goToBesluiten;


    public CloseWindow(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60, 180);
        PageFactory.initElements(this.driver, this);
    }

    public void closeWindows() {

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
    }


}
