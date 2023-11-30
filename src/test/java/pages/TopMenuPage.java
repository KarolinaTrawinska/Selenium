package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

//    Struktura PageObcjectu
//1) Konstruktor, który inicjalizuje elementy
    public TopMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

//2) Wyszukiwanie elementu
    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

// 3) Metoda która wykonuje akcję na elemencie
    public void clickOnContactUsLink() {
        contactUsLink.click();
    }
}


