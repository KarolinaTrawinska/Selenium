package Tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageTest extends BaseTest {


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
