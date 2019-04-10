import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class DateOrderDESC {


    private Date dateTime;
    WebDriver driver;
    WebDriverWait wait;

    public DateOrderDESC(WebDriver driver) {


        this.driver = driver;
        wait = new WebDriverWait(driver, 60, 200);
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "//div[@id='containerArchive']//span[@data-item='Datum']//span[@class='td-content']")
    private List<WebElement> dateListArchive;


    ArrayList<String> strings = new ArrayList<String>();
    ArrayList<Integer> intCollection = new ArrayList<Integer>();
    ArrayList<Integer> intCollection2 = new ArrayList<Integer>();

    public Vergaderingen checkDateOrderDESC() throws ParseException {

        for (WebElement dateElement : dateListArchive) {

            strings.add(dateElement.getText());
        }

        for (String string : strings) {

            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date date = dt.parse(string);
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");

            int stringsToIntegers = Integer.parseInt(dt1.format(date));

            intCollection.add(stringsToIntegers);
            intCollection2.add(stringsToIntegers);

        }

        return new

                Vergaderingen(this.driver);
    }

    public boolean compareDESC() {

        intCollection2.sort(Comparator.reverseOrder());


        if (intCollection.equals(intCollection2)) {
            return true;
        }

        return false;
    }
}






