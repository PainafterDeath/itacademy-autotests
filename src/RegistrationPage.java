import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by p998ncb on 2016.03.04.
 */
public class RegistrationPage {
    WebDriver driver;

    public void setDriver(WebDriver webdriver) {
        driver = webdriver;
    }

    // go to register form
    public void goToRegistrationForm() {
        WebElement registerButton = driver.findElement(By.xpath("//input[contains(@value, 'Register')]"));
        registerButton.click();
    }

    // making all values to be loaded
    public void loadFields() throws InterruptedException {
        WebElement en = driver.findElement(By.id("en"));
        WebElement lt = driver.findElement(By.id("lt"));
        // en.click();
        lt.click();
        Thread.sleep(3000);
    }


    //test fields
    public void setNameInput(String name) {
        WebElement inputName = driver.findElement(By.id("inputName"));
        inputName.clear();
        inputName.sendKeys(name);
    }

    public void setSurnameInput(String surname) {
        WebElement inputSurname = driver.findElement(By.id("inputSurname"));
        inputSurname.clear();
        inputSurname.sendKeys(surname);
    }

    public void setPhoneInput(String phone) {
        WebElement inputPhone = driver.findElement(By.id("inputPhone"));
        inputPhone.clear();
        inputPhone.sendKeys(phone);
    }

    public void setEmailInput(String email) {
        WebElement inputEmail = driver.findElement(By.id("inputEmail"));
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }

    public void setBankDivisionInput(int index) {
        Select inputBankDivision = new Select(driver.findElement(By.id("inputBankDivision")));
        inputBankDivision.selectByIndex(index);
    }

    public void setDateInput(String date) {
        WebElement inputDate = driver.findElement(By.id("inputDate"));
        inputDate.clear();
        inputDate.sendKeys(date);
    }

    public void setTopicInput(int index) {
        Select inputTopic = new Select(driver.findElement(By.id("inputTopic")));
        inputTopic.selectByIndex(index);
    }

    public void setOtherInput(String message) {
        WebElement inputOther = driver.findElement(By.id("inputOther"));
        inputOther.clear();
        inputOther.sendKeys(message);
    }

    // confim registration
    public void confirmRegistration() {
        WebElement sendButton = driver.findElement(By.xpath("//input[contains(@value, 'Siųsti')]"));
        sendButton.click();
    }
}
