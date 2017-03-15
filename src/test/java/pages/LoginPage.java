package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kumar on 2/11/2017.
 */
public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "email")
    public WebElement fuserName;

    @FindBy(how = How.ID, using = "pass")
    public WebElement fpassword;

    @FindBy(how = How.ID, using = "u_0_p")
    public WebElement btnLogin;

    public void Login(String userName, String password) {
        fuserName.sendKeys(userName);
        fpassword.sendKeys(password);
    }

    public void ClickLogin() {
        btnLogin.click();
    }
}
