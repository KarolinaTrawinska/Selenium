import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageTest {
    private WebDriver driver;
    private WebElement element;

    //    Metoda uruchamiana tylko raz, przed wszystkimi testami. ustawia się, że będziemy używali ChromDrivera
    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    //    Metoda uruchamia się przed każydym testem. Aplikacja bedize się komunikowała z przeglądarką za pomocą ChromDrivera
    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    //   Metoda uruchamia się po każdym teście. Zamyka przeglądarkę i za kazdym razem nowy test jest uruchamiany na nowo otwartej przeglądarce.
    @AfterEach
    void teardown() {
        driver.quit();
    }

    //    Test
//    @Test
//    void shouldReturnCorrectPageTitle() {
////        Metoda, która uruchamia przeglądarkę i otwiera podaną w argumencie stronę internetową
//        driver.get("http://www.automationpractice.pl/index.php");
//
////        Sprawdzenie tytułu strony
//        Assertions.assertThat(driver.getTitle()).isEqualTo("My Shop");
//    }
    @Test
    public void seeBestsellersOnHomePage() {
        driver.get("http://www.automationpractice.pl/index.php");

        List<WebElement> link = driver.findElements(By.linkText("BEST SELLERS"));
        link.get(0).click();

        List<WebElement> productNamesByCssSelectors = driver.findElements(By.cssSelector("#blockbestsellers .product-name"));

        List<WebElement> productNamesByxPath = driver.findElements(By.xpath("//*[@id='blockbestsellers']//*[@class='product-name']"));

        for (WebElement productName : productNamesByCssSelectors) {
            System.out.println(productName.getText());
        }

        System.out.println();
        System.out.println();

        for (WebElement productName : productNamesByxPath) {
            System.out.println(productName.getText());
        }
    }
}
