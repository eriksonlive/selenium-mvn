package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComicsPage extends BasePage {

    public ComicsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "page-title")
    private WebElement titulo;
    private String titlePage = "Category: comics";

    public boolean isTitleComicDisplay() throws Exception {
        return this.isDisplayed(titulo) && this.getText(titulo).equals(titlePage);
    }
}
