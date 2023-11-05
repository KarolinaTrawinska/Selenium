import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.pool.TypePool;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

//      Czekanie na elementy1
//            ImplicitlyWait - dodaje się do drivera, globalnie dla wszystkich elementów (findElement). Za każdym razem
//            będzie czekać maksymalnie 10 sekund. Jeśli element będzie gotowy wcześniej to kod pójdzie dalej.

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.automationpractice.pl/index.php");
        Assertions.assertThat(driver.getTitle()).isEqualTo("My Shop");

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
}
