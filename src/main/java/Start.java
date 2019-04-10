import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Start {

private WebDriver driver;
private WebDriverWait wait;

@FindBy (xpath = "//div[contains (text(), 'Start applicatie')]")
private static WebElement buttonStartApp;
    @FindBy (xpath = "//input[@type='email']")
    private static WebElement appEmail;
    @FindBy (xpath = "//input[@id='idSIButton9'][@value = 'Next']")
    private static WebElement nextToPass;
    @FindBy (xpath = "//input[@name = 'passwd']")
    private static WebElement appPassword;
    @FindBy (xpath = "//input[@value = 'Sign in']")
    private static WebElement appSignIn;
    @FindBy (xpath = "//input[@value = 'Yes']")
    private static WebElement stayInApp;

private static String email = "jefke@maaseik.be";
private static String password = "Maaseik2018";

public Start(WebDriver driver)  {
    this.driver=driver;
    wait=new WebDriverWait(driver, 60, 180);
    PageFactory.initElements(this.driver,this);
}


public DateOrderASD startApp()  {
        appEmail.sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(nextToPass)).click();
        appPassword.sendKeys(password);
        appSignIn.click();
        stayInApp.click();
        buttonStartApp.click();
                 return new DateOrderASD(this.driver);
    }


public static void testStatic(){
    System.out.println("START method: It does not mean anything. I just test that a STATIC method can be called by a Class name: it can be seen in RunTest");
}

public String getStartPageTitel(){
    return this.driver.getTitle();
}

}
