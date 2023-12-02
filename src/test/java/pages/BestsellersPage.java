package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class BestsellersPage extends BasePage {
    public BestsellersPage(WebDriver driver) {
        super(driver);  //odwołanie do konstruktora z klasy-matki
    }
    @FindBy(css = "#blockbestsellers .product-name")
    List<WebElement> productNames;

    public List<String> getProductNames() {
        List<String> collect = productNames.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
        return collect;
    }
}
