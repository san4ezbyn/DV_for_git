import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public class RunTest {
    private static WebDriver driver;
    private static String URL = "https://stadmaaseik.sharepoint.com/sites/acc-digitaal-vergaderen";
    private static String STARTPAGE_TITLE = "Digitaal vergaderen";
    private static String IN_APP_PAGE_TITLE = "Overzicht besluiten - Digitaal Vergaderen Maaseik";
    private static String NEW_BESLUIT = "New Besluit Title";

    private Start start;
    private CreateNewBesluit createNewBesluit;
    private SearchBesluit searchBesluit;
    private DeleteNewBesluit deleteNewBesluit;
    private DeleteCopyBesluit deleteCopyBesluit;
    private Vergaderingen vergaderingen;
    private VergaderingenArchief vergaderingenArchief;
    private MakeCopy makeCopy;
    private Reacties reacties;
    private Search search;
    private DateOrderASD datumOrderASD;
    private DateOrderDESC dateOrderDESC;
    private MeetingsSchepenCollege meetingsSchepenCollege;
    private MeetingsVastBureau meetingsVastBureau;
    private MeetingsGemeenteraad meetingsGemeenteraad;
    private MeetingsOCMW meetingsOCMW;
    private MeetingsBCSD meetingsBCSD;
    private MeetingsAGBMdir meetingsAGBMdir;
    private MeetingsAGBIdir meetingsAGBIdir;
    private MeetingsAGBMraad meetingsAGBMraad;
    private MeetingsAGBIraad meetingsAGBIraad;
    private Home home;

    @BeforeClass
    private void init() throws InterruptedException {
        setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        start = new Start(driver);
    }

    @Test(testName = "START")
    private void clickStartApp() throws ParseException, IOException {
        Start.testStatic();
        datumOrderASD = start.startApp();
        Assert.assertEquals(STARTPAGE_TITLE, start.getStartPageTitel());
    }

    @Test(dependsOnMethods = "clickStartApp")
    private void orderOfMeetingsASD() throws IOException, ParseException {
        dateOrderDESC = datumOrderASD.checkDateOrderASD();
        Assert.assertTrue(datumOrderASD.compareASD());
    }

    @Test(dependsOnMethods = "orderOfMeetingsASD")
    private void orderOfMeetingsDESC() throws IOException, ParseException {
        vergaderingen = dateOrderDESC.checkDateOrderDESC();
        Assert.assertTrue(dateOrderDESC.compareDESC());
    }

    @Test(dependsOnMethods = "orderOfMeetingsDESC")
    private void vergaderingenSortActuel() throws IOException, ParseException {
        vergaderingenArchief = vergaderingen.filterVergaderingen();
        Assert.assertTrue(vergaderingen.checkTypeInActueel());
        Assert.assertFalse(vergaderingen.checkVerslagInActueel());
    }

    @Test(dependsOnMethods = "vergaderingenSortActuel")
    private void vergaderingenSortArchief() throws IOException, ParseException {
        createNewBesluit = vergaderingenArchief.filterVergaderingen();
        Assert.assertTrue(vergaderingenArchief.checkTypeInArchief());
    }

    @Test(dependsOnMethods = "vergaderingenSortArchief")
    private void createNewDecision() throws InterruptedException {
        Search.testenStatic();
        searchBesluit = createNewBesluit.createNewBesluit();
        Assert.assertEquals(IN_APP_PAGE_TITLE, createNewBesluit.getCNBPageTitel());
    }

    @Test(dependsOnMethods = "createNewDecision")
    private void searchNewDecision() throws InterruptedException {
        meetingsSchepenCollege = searchBesluit.searchBesluit(NEW_BESLUIT);
        Assert.assertTrue(searchBesluit.verifyBesluitCreated());
    }

    @Test(dependsOnMethods = "searchNewDecision")
    private void openMeetingSchepenCollege() {
        meetingsVastBureau = meetingsSchepenCollege.meetingSchepenCollege();
        // Assert.assertTrue(meetingsSchepenCollege.checkTextInAgendapunkt());
    }

    @Test(dependsOnMethods = "openMeetingSchepenCollege")
    private void openMeetingVastBureau() {
        meetingsGemeenteraad = meetingsVastBureau.meetingVastBureau();
       // Assert.assertTrue(meetingsVastBureau.checkTextInAgendapunkt());
    }

    @Test(dependsOnMethods = "openMeetingVastBureau")
    private void openMeetingGemeenteraad() {
        meetingsOCMW = meetingsGemeenteraad.meetingGemeenteraad();
       // Assert.assertTrue(meetingsGemeenteraad.checkTextInAgendapunkt());
    }

    @Test(dependsOnMethods = "openMeetingGemeenteraad")
    private void openMeetingOCMW() {
        meetingsBCSD = meetingsOCMW.meetingOCMW();
       // Assert.assertTrue(meetingsOCMW.checkTextInAgendapunkt());
    }

    @Test(dependsOnMethods = "openMeetingOCMW")
    private void openMeetingBCSD() {
        meetingsAGBMdir = meetingsBCSD.meetingBCSD();
       // Assert.assertTrue(meetingsBCSD.checkTextInAgendapunkt());
    }

    @Test(dependsOnMethods = "openMeetingBCSD")
    private void openMeetingAGBMdir() {
        meetingsAGBIdir = meetingsAGBMdir.meetingAGBMdir();
       // Assert.assertTrue(meetingsAGBMdir.checkTextInAgendapunkt());
    }

    @Test(dependsOnMethods = "openMeetingAGBMdir")
    private void openMeetingAGBIdir() {
        meetingsAGBMraad = meetingsAGBIdir.meetingAGBIdir();
       // Assert.assertTrue(meetingsAGBIdir.checkTextInAgendapunkt());
    }

    @Test(dependsOnMethods = "openMeetingAGBIdir")
    private void openMeetingAGBMraad() {
        meetingsAGBIraad = meetingsAGBMraad.meetingsAGBMraad();
       // Assert.assertTrue(meetingsAGBMraad.checkTextInAgendapunkt());
    }

    @Test(dependsOnMethods = "openMeetingAGBMraad")
    private void openMeetingAGBIraad() {
        search = meetingsAGBIraad.meetingsAGBIraad();
       // Assert.assertTrue(meetingsAGBIraad.checkTextInAgendapunkt());
    }

    @Test(dependsOnMethods = "openMeetingAGBIraad")
    private void zoekenSearch() {
        reacties = search.testZoeken();
        Assert.assertTrue(search.searchIsCorrect());
    }

    @Test(dependsOnMethods = "zoekenSearch")
    private void reactions() throws InterruptedException {
        makeCopy = reacties.reaction();
        //Assert test checks are inside Class method (TODO:make asserts HERE!! )
    }

    @Test(dependsOnMethods = "reactions")
    private void makeDecisionCopy() throws InterruptedException {
        deleteCopyBesluit = makeCopy.makeCopy();
        Assert.assertFalse(makeCopy.findCopyOfBesluit());
    }

    @Test(dependsOnMethods = "makeDecisionCopy")
    private void deleteCopyDecision() throws InterruptedException {
        deleteNewBesluit = deleteCopyBesluit.deleteCopyBesluit();
        Assert.assertTrue(deleteCopyBesluit.verifyCopyBesluitDeleted());
    }

    @Test(dependsOnMethods = "deleteCopyDecision")
    private void deleteNewDecision() throws InterruptedException {
        driver.navigate().refresh();
        home = deleteNewBesluit.deleteBesluit();
        Assert.assertTrue(deleteCopyBesluit.verifyCopyBesluitDeleted());
    }

    @AfterClass
    public void tearDown() {
      /*  if (driver.getWindowHandles().size() > 1) {
            driver.close();
        } else {
            driver.quit();
        }*/
       // driver.quit();
    }
}
