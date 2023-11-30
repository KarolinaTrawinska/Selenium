package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsFormPage {

    private WebDriverWait wait;

    public ContactUsFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @FindBy(id = "submitMessage")
    WebElement sendButton;

    @FindBy(className = "alert-danger")
    WebElement alertBox;

    @FindBy(id = "email")
    WebElement emailInput;

    public void clickSendButton() {
        sendButton.click();
    }

    public boolean isAlertBoxDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(alertBox));
        boolean isDisplayed = false;
        try {
            isDisplayed = alertBox.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }
}
