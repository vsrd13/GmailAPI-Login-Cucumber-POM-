package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Kumar on 2/14/2017.
 */
public class Locators {

    @FindBy(id="email")
    public WebElement username;

    @FindBy(id="pass")
    public WebElement password;

    //@FindBy(className = "_1frb")
    public WebElement assertElement;

    @FindBy(id= "u_0_q")
    public WebElement btnLogin;

    public static String URL = "https://www.facebook.com";
}
