package steps.Hook;

import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Kumar on 2/10/2017.
 */
public class Hook extends BaseUtil {

    public Hook(BaseUtil base) {
        this.base = base;
    }

    private BaseUtil base;


    @Before
    public void InitializeTest() {
        System.out.println("Opening the browser : Chrome  \n ");

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Kumar\\IdeaProjects\\Cucumber\\BrowserDrivers\\chromedriver.exe");

       // base.driver = new FirefoxDriver();
        base.driver = new ChromeDriver();
    }


}
