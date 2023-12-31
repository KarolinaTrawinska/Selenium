package pages;

import model.Message;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ContactUsFormPage extends BasePage {

    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitMessage")
    WebElement sendButton;

    @FindBy(className = "alert-danger")
    WebElement alertBox;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "id_contact")
    WebElement subjectSelect;

    @FindBy(id = "id_order")
    WebElement orderReferenceInput;

    @FindBy(id = "message")
    WebElement messageArea;

    @FindBy(className = "alert-success")
    WebElement greenAlertBox;

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

    public void sendContactUsForm(Message message) {
        Select subject = new Select(subjectSelect);
        subject.selectByVisibleText(message.getSubject().getValue());
        emailInput.sendKeys(message.getEmail());
        orderReferenceInput.sendKeys(message.getOrderReference());
        messageArea.sendKeys(message.getMessage());

        sendButton.click();

    }
    public boolean isGreenAlertBoxDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(greenAlertBox));
        boolean isDisplayed = false;
        try {
            isDisplayed = greenAlertBox.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        return isDisplayed;
    }
}
