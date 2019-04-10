import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {

    private WebDriver driver;

    WebDriverWait wait;

    public Home(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60, 1000);
        PageFactory.initElements(this.driver, this);
    }

    public Home home() {

        return new Home(this.driver);
    }
}
