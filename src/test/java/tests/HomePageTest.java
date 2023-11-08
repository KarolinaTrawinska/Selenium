package tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BestsellersPage;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageTest extends BaseTest {

    private BestsellersPage bestsellersPage;
    @ BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        Assertions.assertThat(driver.getTitle()).isEqualTo("My Shop");

//  Inicjalizacja PageObject. Można go już używać w teście
        bestsellersPage = new BestsellersPage(driver);

    }

    @Test
    void shouldReturnCorrectPageTitle() {
//        Metoda, która uruchamia przeglądarkę i otwiera podaną w argumencie stronę internetową
        driver.get("http://www.automationpractice.pl/index.php");

//        Sprawdzenie tytułu strony
        Assertions.assertThat(driver.getTitle()).isEqualTo("My Shop");
    }

    @Test
    public void seeBestsellersOnHomePage() {

        List<WebElement> link = driver.findElements(By.linkText("BEST SELLERS"));
        link.get(0).click();

//      Można użyć tej metody bo mamy już PageObject. Metoda zwróci listę stringów ProductNames
        List<String> productNames = bestsellersPage.getProductNames();

        List<String> productsWithEmptyNames = productNames.stream()
                .filter(el->el.isEmpty())
                .collect(Collectors.toList());

        Assertions.assertThat(productsWithEmptyNames).isEmpty();

        }
    }
