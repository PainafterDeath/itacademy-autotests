import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import java.io.File;

/**
 * Created by p998ncb on 2016.03.04.
 */
public class RegistrationPageTest {

    private static WebDriver webDriver;
    private static RegistrationPage page;

    @BeforeClass
    public static void init() throws InterruptedException {
        File file = new File("C:\\Intel\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.get("http://contactform-swedbank.rhcloud.com/registration.html");
        page = new RegistrationPage();
        page.setDriver(webDriver);

        page.goToRegistrationForm();
        page.loadFields();
    }

    @Test
    public void test_registration_form_neg() throws InterruptedException {
        page.setNameInput("V");
        page.setSurnameInput("P");
        page.setPhoneInput("861");
        page.setEmailInput("wpgamil.com");
        page.setBankDivisionInput(2);
        page.setDateInput("2016-05-05 16:00");
        page.setTopicInput(2);
        page.setOtherInput("message from automated test");

        Assert.assertEquals("true", page.getConfirmButton().getAttribute("disabled"));
    }

    @Test
    public void test_registration_form_pos() throws InterruptedException {
        page.setNameInput("Vardeninis");
        page.setSurnameInput("Pavardenis");
        page.setPhoneInput("861231231");
        page.setEmailInput("wp@gamil.com");
        page.setBankDivisionInput(2);
        page.setDateInput("2016-05-05 16:00");
        page.setTopicInput(2);
        page.setOtherInput("message from automated test");

        page.confirmRegistration();

        Assert.assertEquals("http://contactform-swedbank.rhcloud.com/index.html", page.getBackButton().getAttribute("href"));

    }

    @AfterClass
    public static void tearDownClass() {
        webDriver.close();
    }
}
