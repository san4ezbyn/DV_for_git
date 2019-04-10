import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CreateNewBesluit {

    private WebDriver driver;
    private WebDriverWait wait;

    int numberOfBesluiten;
    int numberOfBesluiten2;

    @FindBy(xpath = "//input[@value= 'Maak besluit']")
    private WebElement maakBesluitButton;
    @FindBy(xpath = "//input[@id='Titel']")
    private WebElement titelField;
    @FindBy(xpath = "//select[@id='Dienst_value']")
    private WebElement dienstField;
    @FindBy(xpath = "//select[@id='Soort_value']")
    private WebElement soortField;
    @FindBy(xpath = "//option[@value='13'][@schepen='11']")
    private WebElement aankoopDienstField;
    @FindBy(xpath = "//option[@value='3'][contains(text(), 'Algemeen')]")
    private WebElement algemeenSoortField;
    @FindBy(xpath = " //h3[@class='sub-steps-tabs-title'][contains(text(),'Data')]")
    private WebElement dataTab;
    @FindBy(xpath = "//select[@id='DatumCbs_value']")
    private WebElement datumCBS;
    @FindBy(xpath = "//option[@value='30'][contains(text(), '07/05/2018 13:00')]")
    private WebElement cbsDate;
    @FindBy(xpath = "//span[@class='next'][contains(text(), 'Volgende')]")
    private WebElement buttonVolgende;

    //  @FindBy(xpath = "//h4[@class='js-title-inner'][contains(text(), 'Documenten')]")
    @FindBy(xpath = "//h4[contains(text(), 'Documenten')]")
    private WebElement goTo7Documenten;
    @FindBy(xpath = "//span[@class=\"finish action-button\"][contains(text(), 'Voltooien')]")
    private WebElement buttonVoltooien;


    @FindBy(xpath = "//select[@id='selectSize']")
    private WebElement selectSize;
    @FindBy(xpath = "//select[@id='selectSize']/option[contains(text(), '100')]")
    private WebElement size100;


    @FindBy(xpath = "//select[@id='DatumVastBureau_value']")
    private WebElement datumVastBereau;
    @FindBy(xpath = "//select[@id='DatumVastBureau_value']/option[contains (text(),'08/01/2019 20:00')]")
    private WebElement vastBereauDate;

    @FindBy(xpath = "//select[@id='DatumGemeenteraad_value']")
    private WebElement datumGemeenteraad;
    @FindBy(xpath = "//select[@id='DatumGemeenteraad_value']/option[contains (text(),'26/11/2018 20:00')]")
    private WebElement gemeentraadDate;

    @FindBy(xpath = "//select[@id='DatumOcmwRaad_value']")
    private WebElement datumOCMWraad;
    @FindBy(xpath = "//select[@id='DatumOcmwRaad_value']/option[contains (text(),'01/03/2019 00:00')]")
    private WebElement OCMWraadDate;

    @FindBy(xpath = "//select[@id='DatumBcsd_value']")
    private WebElement datumBCSD;
    @FindBy(xpath = "//select[@id='DatumBcsd_value']/option[contains (text(),'27/12/2018 00:00')]")
    private WebElement BCSDdate;

    @FindBy(xpath = "//select[@id='DatumAgbmDirectieraad_value']")
    private WebElement datumDirAGBM;
    @FindBy(xpath = "//select[@id='DatumAgbmDirectieraad_value']/option[contains (text(),'31/12/2018 00:00')]")
    private WebElement AGBMdate;

    @FindBy(xpath = "//select[@id='DatumAgbiDirectieraad_value']")
    private WebElement datumDirAGBI;
    @FindBy(xpath = "//select[@id='DatumAgbiDirectieraad_value']/option[contains (text(),'01/01/2019 10:30')]")
    private WebElement AGBIdate;

    @FindBy(xpath = "//select[@id='DatumAgbmRaadVanBeheer_value']")
    private WebElement datumAGBMraad;
    @FindBy(xpath = "//select[@id='DatumAgbmRaadVanBeheer_value']/option[contains (text(),'04/01/2019 00:00')]")
    private WebElement AGBMraadDate;

    @FindBy(xpath = "//select[@id='DatumAgbiRaadVanBeheer_value']")
    private WebElement datumAGBIraad;
    @FindBy(xpath = "//select[@id='DatumAgbiRaadVanBeheer_value']/option[contains (text(),'25/07/2019 00:00')]")
    private WebElement AGBIraadDate;


    @FindBy(xpath = "//a[@id='create-besluit-t-4']//span[contains(text(),'5')]")
    private WebElement gotToBesluit5;

    @FindBy(xpath = "//h4[@class='sub-steps-inhoud-tabs-title'][contains(text(),'CBS')]")
    private WebElement besluitCBS;

    @FindBy(xpath = "//div[@id='besluitInhoudCBS']//div[@data-placeholder='Typ hier het besluit...']")
    private WebElement textFieldCBS;

    @FindBy(xpath = "//div[@id='besluitInhoudGemeenteraad']//div[@data-placeholder='Typ hier het besluit...']")
    private WebElement textGemeenteraad;


    @FindBy(xpath = "//div[@id='besluitInhoudVastbureau']//div[@data-placeholder='Typ hier het besluit...']")
    private WebElement textVastBureau;

    @FindBy(xpath = "//h4[@class='sub-steps-inhoud-tabs-title'][contains(text(),'Vast bureau')]")
    private WebElement besluitVastBereau;

    @FindBy(xpath = "//h4[@class='sub-steps-inhoud-tabs-title'][contains(text(),'Gemeenteraad')]")
    private WebElement besluitGemeenteraad;


    @FindBy(xpath = "//h4[@class='sub-steps-inhoud-tabs-title'][contains(text(),'OCMW-Raad')]")
    private WebElement besluitOCMWraad;
    @FindBy(xpath = "//div[@id='besluitInhoudOcmwraad']//div[@data-placeholder='Typ hier het besluit...']")
    private WebElement textFieldOCMWraad;

    @FindBy(xpath = "//h4[@class='sub-steps-inhoud-tabs-title'][contains(text(),'BCSD')]")
    private WebElement besluitBCSD;
    @FindBy(xpath = "//div[@id='besluitInhoudBcsd']//div[@data-placeholder='Typ hier het besluit...']")
    private WebElement textFieldBCSD;

    @FindBy(xpath = "//h4[@class='sub-steps-inhoud-tabs-title'][contains(text(),'Directiecomité AGBM')]")
    private WebElement besluitAGBMdir;
    @FindBy(xpath = "//div[@id='besluitInhoudDirectieComiteAGBM']//div[@data-placeholder='Typ hier het besluit...']")
    private WebElement textFieldAGBMdir;

    @FindBy(xpath = "//h4[@class='sub-steps-inhoud-tabs-title'][contains(text(),'Directiecomité AGBI')]")
    private WebElement besluitAGBIdir;
    @FindBy(xpath = "//div[@id='besluitInhoudDirectieComiteAGBI']//div[@data-placeholder='Typ hier het besluit...']")
    private WebElement textFieldAGBIdir;

    @FindBy(xpath = "//h4[@class='sub-steps-inhoud-tabs-title'][contains(text(),'Raad van bestuur AGBM')]")
    private WebElement besluitAGBMraad;
    @FindBy(xpath = "//div[@id='besluitInhoudRaadVanBestuurAGBM']//div[@data-placeholder='Typ hier het besluit...']")
    private WebElement textFieldAGBMraad;

    @FindBy(xpath = "//h4[@class='sub-steps-inhoud-tabs-title'][contains(text(),'Raad van bestuur AGBI')]")
    private WebElement besluitAGBIraad;
    @FindBy(xpath = "//div[@id='besluitInhoudRaadVanBestuurAGBI']//div[@data-placeholder='Typ hier het besluit...']")
    private WebElement textFieldAGBIraad;

    @FindBy(xpath = "//h4[contains(text(), 'Algemeen Kader')]")
    private WebElement goTo2AlgemeenKader;
    @FindBy(xpath = "//div[@data-placeholder=\'Typ hier het algemeen kader...\']")
    private WebElement textFieldAlgemeenKader;

    @FindBy(xpath = "//h4[contains(text(), 'Juridisch Kader')]")
    private WebElement goTo3JuridischKader;
    @FindBy(xpath = "//div[@data-placeholder=\'Typ hier het juridisch kader...\']")
    private WebElement textFieldJuridischKader;

    @FindBy(xpath = "//h4[contains(text(), 'Financieel Kader')]")
    private WebElement goTo4FinancieelKader;
    @FindBy(xpath = "//div[@data-placeholder=\'Typ hier het financieel kader...\']")
    private WebElement textFieldFinancieelKader;
    @FindBy(xpath = "//input[@id='Budget']")
    private WebElement budgetField;

    @FindBy(xpath = "//h4[contains(text(), 'Samenvatting')]")
    private WebElement goTo6Samenvatting;
    @FindBy(xpath = "//div[@data-placeholder=\'Typ hier de samenvatting van het besluit...\']")
    private WebElement textFieldSamenvatting;

    @FindBy(xpath = "//div[@class='note-editable']")
    private WebElement summerNoteField;

    @FindBy(xpath = "//nav[@class='main-nav']//a[contains(text(),'Besluiten')]")
    private WebElement getGotToBesluiten;

    private static String newBesluitTitle = "New Besluit Title";

    public CreateNewBesluit(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 40, 200);
        PageFactory.initElements(this.driver, this);
    }


    public SearchBesluit createNewBesluit() throws InterruptedException {

        /*ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));

        selectSize.click();
        size100.click();
        int numberOfBesluiten = driver.findElements(By.xpath("//div[@class='app-table-content-row']")).size();
        System.out.println("count - " + numberOfBesluiten);*/

        getGotToBesluiten.click();
        maakBesluitButton.click();
        titelField.sendKeys(newBesluitTitle);
        dienstField.click();
        aankoopDienstField.click();
        soortField.click();
        algemeenSoortField.click();
        dataTab.click();
        datumCBS.click();
        cbsDate.click();

        datumVastBereau.click();
        vastBereauDate.click();

        datumGemeenteraad.click();
        gemeentraadDate.click();

        datumOCMWraad.click();
        OCMWraadDate.click();

        datumBCSD.click();
        BCSDdate.click();

        datumDirAGBM.click();
        AGBMdate.click();

        datumDirAGBI.click();
        AGBIdate.click();

        datumAGBMraad.click();
        AGBMraadDate.click();

        datumAGBIraad.click();
        AGBIraadDate.click();

        goTo2AlgemeenKader.click();

        Thread.sleep(200);
        wait.until(ExpectedConditions.visibilityOf(summerNoteField)).click();
        // summerNoteField.click();
        summerNoteField.sendKeys("ALGEMEEN KADER textfield\n\nLOREM IPSUM TEST TEXT", Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(goTo3JuridischKader));
        wait.until(ExpectedConditions.elementToBeClickable(buttonVolgende)).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='next'][contains(text(), 'Volgende')]"), "Volgende"));
        wait.until(ExpectedConditions.visibilityOf(textFieldJuridischKader));
        wait.until(ExpectedConditions.visibilityOf(textFieldJuridischKader));
        textFieldJuridischKader.click();
        textFieldJuridischKader.sendKeys("\n\nJURIDISCH KADER textfield\n\nLOREM IPSUM TEST TEXT", Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(goTo4FinancieelKader));
        wait.until(ExpectedConditions.elementToBeClickable(buttonVolgende)).click();

        wait.until(ExpectedConditions.visibilityOf(textFieldFinancieelKader));
Thread.sleep(200);
        budgetField.click();
        budgetField.sendKeys("1.000.000.000.009,88");

        textFieldFinancieelKader.click();
        textFieldFinancieelKader.sendKeys("\n\nFINANCIEEL KADER textfield\n\nLOREM IPSUM TEST TEXT", Keys.ENTER);


        wait.until(ExpectedConditions.elementToBeClickable(gotToBesluit5));
        wait.until(ExpectedConditions.elementToBeClickable(buttonVolgende)).click();

        textFieldCBS.sendKeys("\n\nCBS text (Besluit)\n\nLOREM IPSUM TEST TEXT");

        besluitVastBereau.click();
        textVastBureau.click();
        textVastBureau.sendKeys("Vast Bureau text (Besluit)\n\nLOREM IPSUM TEST TEXT");

        besluitGemeenteraad.click();
        textGemeenteraad.click();
        textGemeenteraad.sendKeys("Gemeenteraad text (Besluit)\n\nLOREM IPSUM TEST TEXT");

        besluitOCMWraad.click();
        textFieldOCMWraad.click();
        textFieldOCMWraad.sendKeys("OCMW raad text (Besluit)\n\nLOREM IPSUM TEST TEXT");

        besluitBCSD.click();
        textFieldBCSD.click();
        textFieldBCSD.sendKeys("BCSD text (Besluit)\n\nLOREM IPSUM TEST TEXT");

        besluitAGBMdir.click();
        textFieldAGBMdir.click();
        textFieldAGBMdir.sendKeys("directiecomite AGBM (Besluit)\n\nLOREM IPSUM TEST TEXT");

        besluitAGBIdir.click();
        textFieldAGBIdir.click();
        textFieldAGBIdir.sendKeys("directiecomite AGBI (Besluit)\n\nLOREM IPSUM TEST TEXT");

        besluitAGBMraad.click();
        textFieldAGBMraad.click();
        textFieldAGBMraad.sendKeys("AGBM raad bestuur (Besluit)\n\nLOREM IPSUM TEST TEXT");

        besluitAGBIraad.click();
        textFieldAGBIraad.click();
        textFieldAGBIraad.sendKeys("AGBI raad bestuur (Besluit)\n\nLOREM IPSUM TEST TEXT");

        wait.until(ExpectedConditions.elementToBeClickable(goTo6Samenvatting));
        wait.until(ExpectedConditions.elementToBeClickable(buttonVolgende)).click();


        wait.until(ExpectedConditions.visibilityOf(textFieldSamenvatting)).click();
        Thread.sleep(200);
        textFieldSamenvatting.sendKeys("\nSAMENVATTING textfield\n\nLOREM IPSUM TEST TEXT", Keys.ENTER);

        // Thread.sleep(5000);

       /* wait.until(ExpectedConditions.elementToBeClickable(goTo7Documenten));
        goTo7Documenten.click();*/
        wait.until(ExpectedConditions.elementToBeClickable(buttonVolgende)).click();

        //  Thread.sleep(500);

        wait.until(ExpectedConditions.elementToBeClickable(buttonVoltooien));
        Thread.sleep(200);
        buttonVoltooien.click();


        selectSize.click();
        size100.click();
        int numberOfBesluiten2 = driver.findElements(By.xpath("//div[@class='app-table-content-row']")).size();
        System.out.println("count2 - " + numberOfBesluiten2);
        return new SearchBesluit(this.driver);
    }

    public boolean checkBesluitCreated() {
        List<WebElement> listOfBesluiten = driver.findElements(By.xpath("//div[@class='app-table-content-row']"));
        for (WebElement besluit : listOfBesluiten) {

            if (numberOfBesluiten2 > numberOfBesluiten) {
                return true;
            }
        }
        return false;
    }


    public String getCNBPageTitel() {
        return this.driver.getTitle();
    }


}
