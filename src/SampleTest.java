import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class SampleTest {

    @Test
    public void testRegistration() throws InterruptedException {
        File file = new File("C:\\Intel\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("http://contactform-swedbank.rhcloud.com/registration.html");

        // go to register form
        WebElement registerButton = driver.findElement(By.xpath("//input[contains(@value, 'Register')]"));
        registerButton.click();

        // making all values to be loaded
        WebElement en = driver.findElement(By.id("en"));
        WebElement lt = driver.findElement(By.id("lt"));
       // en.click();
        lt.click();

        //Wait untill language changes
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        Thread.sleep(3000);

        //test fields
        WebElement inputName = driver.findElement(By.id("inputName"));
        WebElement inputSurname = driver.findElement(By.id("inputSurname"));
        WebElement inputPhone = driver.findElement(By.id("inputPhone"));
        WebElement inputEmail = driver.findElement(By.id("inputEmail"));
        Select inputBankDivision = new Select(driver.findElement(By.id("inputBankDivision")));
        WebElement inputDate = driver.findElement(By.id("inputDate"));
        Select inputTopic = new Select(driver.findElement(By.id("inputTopic")));
        WebElement inputOther = driver.findElement(By.id("inputOther"));

        // fill test fields
        inputName.clear();
        inputName.sendKeys("Vardeninis");
        inputSurname.clear();
        inputSurname.sendKeys("Pavardenis");
        inputPhone.clear();
        inputPhone.sendKeys("861231231");
        inputEmail.clear();
        inputEmail.sendKeys("vp@gmail.com");
        inputBankDivision.selectByIndex(2);
        inputDate.clear();
        inputDate.sendKeys("2016-03-20 16:20");
        inputTopic.selectByIndex(2);
        inputOther.clear();
        inputOther.sendKeys("text from auto test");

        // confim registration
        WebElement sendButton = driver.findElement(By.xpath("//input[contains(@value, 'Siųsti')]"));
        sendButton.click();

        //assert
        WebElement backButton = driver.findElement(By.xpath("//a[contains(@class, 'col-xs-offset-10 col-xs-2 btn btn-primary ng-binding')]"));
        Assert.assertEquals("http://contactform-swedbank.rhcloud.com/index.html", backButton.getAttribute("href"));
        driver.quit();
    }
}
