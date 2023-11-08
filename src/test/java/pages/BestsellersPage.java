package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class BestsellersPage {
//    Żeby mieć gwarację że WebElementy nie będą nullami trzeba użyć PageFactory. Trzeba utworzyć konstruktor

    public BestsellersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

//    Findby - jest to adnotacja do divera findElements, używa się tych samych css. W każdym teście jak będziemy
//    chcieli skorzystać z productNames to używas się własnie tego.
    @FindBy(css = "#blockbestsellers .product-name")
    List<WebElement> productNames;

//    Metoda która zwraca tekst z productNames. Trim czyści białe spacje z przodu i na końcu streama. // Określony
//    został WebElement oraz metoda która wyciąga tekst z WebElementu i zwraca nową listę z tekstami
    public List<String> getProductNames() {
        List<String> collect = productNames.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
        return collect;
    }
}


// Jeżeli używamy wzoraca projektowego PageObject który będzie reprezentował jakiś element na stronie, w tej klasie
//podajemy elementy które znajdują się w tym komponencie. Żeby stworzone metody nie były nullami, trzeba użyć
// PageFactory, na którym używamy metody initElements w której przekazujemy driver i stronę dla ktorej chcemy to
// zainicjalizować (this)