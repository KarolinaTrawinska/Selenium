import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ContactUsTest {
    private WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldNotAllowToSendEmptyContactForm() {
        driver.get("http://www.automationpractice.pl/index.php");
        Assertions.assertThat(driver.getTitle()).isEqualTo("My Shop");

        WebElement contactUsLink = driver.findElement(By.linkText("Contact us"));
        contactUsLink.click();

        WebElement sendButton = driver.findElement(By.id("submitMessage"));
        sendButton.click();

//        Asercja sprawdza czy element alertBox jest wyświetlany. Sprawdzamy czy to jest prawda
        WebElement alertBox = driver.findElement(By.className("alert-danger"));
        Assertions.assertThat(alertBox.isDisplayed()).isTrue();

    }
}
