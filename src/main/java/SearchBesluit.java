import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class SearchBesluit {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='app-table-content-row']")
    private List<WebElement> listOfBesluiten;
    @FindBy(xpath = "//span[@class='td-content']//*[contains(text(),'New Besluit Title')]")
    private WebElement newTitleBesluit;

    @FindBy(xpath = "//select[@id='selectSize']")
    private WebElement selectSize;
    @FindBy(xpath = "//select[@id='selectSize']/option[contains(text(), '100')]")
    private WebElement size100;

    private static String NEW_MEETING = "New Besluit Title";

    public SearchBesluit(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 60);
        PageFactory.initElements(this.driver, this);
    }

    public MeetingsSchepenCollege searchBesluit(String NEW_BESLUIT) {

        selectSize.click();
        size100.click();

       /* listOfBesluiten.stream()
                .filter(besluit -> besluitTitle.equals(besluit.getText())).findFirst().ifPresent(WebElement::click);*/

        for (WebElement string : listOfBesluiten) ;
        System.out.println("SIZE - " + listOfBesluiten.size());
        System.out.println("New Besluit - " + newTitleBesluit.getText());

        return new MeetingsSchepenCollege(this.driver);
    }

    public boolean verifyBesluitCreated() {
        List<WebElement> listOfBesluiten = driver.findElements(By.xpath("//div[@class='app-table-content-row']"));
        for (WebElement besluit : listOfBesluiten) {
            if (besluit.getText().contains(NEW_MEETING)) {
                return true;
            }
        }        return false;
    }

}
