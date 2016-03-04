import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import java.io.File;

/**
 * Created by p998ncb on 2016.03.04.
 */
public class RegistrationPageTest {

    private static WebDriver webDriver;

    @BeforeClass
    public static void init()
    {
        File file = new File("C:\\Intel\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.get("http://contactform-swedbank.rhcloud.com/registration.html");
    }

    @Test
    public void test_registration_form_pos() throws InterruptedException {
        RegistrationPage page = new RegistrationPage();

        page.setDriver(webDriver);
        page.goToRegistrationForm();
        page.loadFields();
        page.setNameInput("Vardeninis");
        page.setSurnameInput("Pavardenis");
        page.setPhoneInput("861231231");
        page.setEmailInput("wp@gamil.com");
        page.setBankDivisionInput(2);
        page.setDateInput("2016-05-05 16:00");
        page.setTopicInput(2);
        page.setOtherInput("message from automated test");

        page.confirmRegistration();

        WebElement backButton = webDriver.findElement(By.xpath("//a[contains(@class, 'col-xs-offset-10 col-xs-2 btn btn-primary ng-binding')]"));
        Assert.assertEquals("http://contactform-swedbank.rhcloud.com/index.html", backButton.getAttribute("href"));

    }

    @AfterClass
    public static void tearDownClass() {
        webDriver.close();
    }
}
