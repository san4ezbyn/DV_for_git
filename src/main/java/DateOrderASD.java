import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateOrderASD {

    private Date dateTime;
    WebDriver driver;
    WebDriverWait wait;

    public DateOrderASD(WebDriver driver) {


        this.driver = driver;
        wait = new WebDriverWait(driver, 60, 200);
        PageFactory.initElements(this.driver, this);
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @FindBy(xpath = "//a[@class='main-nav-item'][contains(text(), 'Vergaderingen')]")
    private WebElement vergaderingenTab;

    @FindBy(xpath = "//div[@id='containerActual']//span[@data-item='Datum']//span[@class='td-content']")
    private List<WebElement> dateListActueel;

    @FindBy(xpath = "//div[@id='containerActual']//select[@id='selectSize']")
    private WebElement selectSizeActueel;
    @FindBy(xpath = "//div[@id='containerActual']//select[@id='selectSize']/option[contains(text(),'100')]")
    private WebElement size100Actueel;


    ArrayList<String> strings = new ArrayList<String>();
       ArrayList<Integer> intCollection = new ArrayList<Integer>();
    ArrayList<Integer> intCollection2 = new ArrayList<Integer>();

    public DateOrderDESC checkDateOrderASD() throws ParseException, IOException {

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));

        vergaderingenTab.click();

        selectSizeActueel.click();
        size100Actueel.click();


        for (WebElement dateElement : dateListActueel) {

            strings.add(dateElement.getText());
        }

        for (String string : strings) {
            /*String newString = string.replace("/", "");
            String shortString = newString.replace(":", "");
            StringBuffer sb = new StringBuffer(shortString);
            sb.delete(8, 13);
            int i = Integer.parseInt(sb.toString());
            DateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date date = format.parse(sb.toString());
                        dates.add(date);
            boolean order = false;*/

            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dt.parse(string);
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");

            int stringsToIntegers = Integer.parseInt(dt1.format(date));

            intCollection.add(stringsToIntegers);
            intCollection2.add(stringsToIntegers);

        }

        return new DateOrderDESC(this.driver);
    }

    public boolean compareASD() {

        intCollection2.sort(Comparator.naturalOrder());


        if (intCollection.equals(intCollection2)) {
            return true;
        }

        return false;
    }
}

