import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Search {

    WebDriver driver;
    WebDriverWait wait;

    private static String SEARCH_TITLE = "New Besluit Title";

    @FindBy(xpath = "//a[contains(text(),'New Besluit Title')]")
    private WebElement searchByTitle;
    @FindBy(xpath = "//input[@id=\"SearchQuery_Titel\"]")
    private WebElement searchByTitleField;

    @FindBy(xpath = "//input[@id=\"SearchQuery_Inhoud\"]")
    private WebElement searchByInhoudField;

    @FindBy(xpath = "//input[@value=\"ZOEKEN *\"]")
    private WebElement zoekenButton;
    @FindBy(xpath = "//div[@id=\"soortDiv\"]")
    private WebElement searchBySoort;

    @FindBy(xpath = "//input[@value='3']")
    private WebElement soortAlgemeen;

    @FindBy(xpath = "//select[@id='ddDienst']")
    private WebElement dienst;
    @FindBy(xpath = "//option[@value='13'][contains(text(),'aankoopdienst')]")
    private WebElement aankoopdienst;

    @FindBy(xpath = "//select[@id='ddSoort']")
    private WebElement listSoort;

    @FindBy(xpath = "//nav[@class='main-nav']//a[contains(text(),'Besluiten')]")
    private WebElement goToBesluiten;

    public Search(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 60);
        PageFactory.initElements(this.driver, this);
    }

    public Reacties testZoeken() {

        goToBesluiten.click();
        //searchByTitleField.click();
        searchByTitleField.sendKeys("New Besluit Title");
        //searchByInhoudField.sendKeys("Gemeenteraad text (Besluit)");
        searchBySoort.click();

        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='ddSoort']")));
        soortAlgemeen.click();
        dienst.click();
        aankoopdienst.click();
        zoekenButton.click();

        return new Reacties(this.driver);
    }

    public boolean searchIsCorrect() {
        List<WebElement> besluitenList;
        besluitenList = driver.findElements(By.xpath("//div[@class='app-table-content-row']"));
        for (WebElement myBesluit : besluitenList) {
            if (myBesluit.getText().contains(SEARCH_TITLE)) {
                System.out.println("I found BESLUIT");
                return true;
            }
        }
        System.out.println("SEARCH (ZOEKEN): I have not found BESLUIT");
        return false;
    }


    public static void testenStatic() {
        System.out.println("I am STATIC from SEARCH tab");
    }


}
