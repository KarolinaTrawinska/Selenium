package tests;

import enums.MessageSubject;
import model.Message;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactUsFormPage;
import pages.TopMenuPage;

import static org.assertj.core.api.Assertions.*;

public class ContactUsTest extends BaseTest {

    private TopMenuPage topMenuPage;
    private ContactUsFormPage contactUsFormPage;


    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        Assertions.assertThat(driver.getTitle()).isEqualTo("My Shop");

        topMenuPage = new TopMenuPage(driver);
        contactUsFormPage = new ContactUsFormPage(driver);
    }

    @Test
    public void shouldNotAllowToSendEmptyContactForm() {

        topMenuPage.clickOnContactUsLink();

        contactUsFormPage.clickSendButton();

        assertThat(contactUsFormPage.isAlertBoxDisplayed()).isTrue();
    }


    @Test
    public void shouldNotAllowToSendContactFormWithOnlyEmail() {

        topMenuPage.clickOnContactUsLink();

        contactUsFormPage.enterEmail("test@gmail.com");

        contactUsFormPage.clickSendButton();

        assertThat(contactUsFormPage.isAlertBoxDisplayed()).isTrue();

    }

    @Test
    public void shouldSendContactUsFormWithValidData() {
        topMenuPage.clickOnContactUsLink();

        Message message = new Message();
        message.setSubject(MessageSubject.WEBMASTER);
        message.setEmail("test@test.com");
        message.setOrderReference("1a2b");
        message.setMessage("Wiadomość");

        contactUsFormPage.sendContactUsForm(message);

        assertThat(contactUsFormPage.isGreenAlertBoxDisplayed()).isTrue();
    }
}


