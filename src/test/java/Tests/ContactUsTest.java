package Tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsTest extends BaseTest {

    @Test
    public void shouldNotAllowToSendEmptyContactForm() {

//      Czekanie na elementy1
//            ImplicitlyWait - dodaje się do drivera, globalnie dla wszystkich elementów (findElement). Za każdym razem
//            będzie czekać maksymalnie 10 sekund. Jeśli element będzie gotowy wcześniej to kod pójdzie dalej.

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement contactUsLink = driver.findElement(By.linkText("Contact us"));
        contactUsLink.click();

        WebElement sendButton = driver.findElement(By.id("submitMessage"));
        sendButton.click();

//        Czekanie na elementy2
//          ExplicitWait - mówimy na jaki konkretnie element chcemy poczekać np. taki który się wolniej ładuje na stronie.
//          tworzymy nowy obiekt WebDriverWait. Podaje się warunek na ktory chce się czekać - widoczność elementu alertBox

        WebElement alertBox = driver.findElement(By.className("alert-danger"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(alertBox));


//        Asercja sprawdza czy element alertBox jest wyświetlany. Sprawdzamy czy to jest prawda
        Assertions.assertThat(alertBox.isDisplayed()).isTrue();
    }

    @Test
    public void shouldNotAllowToSendContactFormWithOnlyEmail() {

        WebElement contactUsLink = driver.findElement(By.linkText("Contact us"));
        contactUsLink.click();

//        Metoda sendKeys wpisuje coś w dane pole
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("test@test.com");

        WebElement sendButton = driver.findElement(By.id("submitMessage"));
        sendButton.click();

        WebElement alertBox = driver.findElement(By.className("alert-danger"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(alertBox));

        Assertions.assertThat(alertBox.isDisplayed()).isTrue();

    }
}


