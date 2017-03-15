package steps;

import Base.BaseUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.DataTable;
import org.openqa.selenium.By;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.Locators;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Kumar on 2/10/2017.
 */
public class LoginStep extends BaseUtil {



    private  BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    Locators LC = PageFactory.initElements(driver,Locators.class);
    LoginPage LP = new LoginPage(driver);

    @Given("^I navigate to the login page$")
    public void i_navigate_to_the_login_page() throws Throwable {
            System.out.println("Navigate to Login page");

            base.driver.manage().window().maximize();
            base.driver.navigate().to(LC.URL);
    }

    @And("^I enter the following for Login$")
    public void i_enter_the_following_for_Login(DataTable table) throws Throwable {




        // Create an ArrayList
        List<User> users = new ArrayList<User>();
        //Store all the users
        users = table.asList(User.class);

        for(User user:users) {
            //LP.Login(user.username,user.password);
            //base.driver.findElement(By.id("email")).sendKeys(user.username);
            //base.driver.findElement(By.id("pass")).sendKeys(user.password);

            type(LC.username,user.username);
            type(LC.password,user.password);
            Thread.sleep(2000);
        }

    }
    @And("^I click login button$")
    public void i_click_login_button() throws Throwable {
        click(LC.btnLogin);
        /*
        if(VerfiyObject(LC.btnLogin)){
            click(LP.btnLogin);
        } else {
            System.out.println("Login button is not found..!");
        }

        //LP.ClickLogin();
        //base.driver.findElement(By.id("u_0_p")).click();
        //base.driver.findElement(By.xpath(".//*[@id='u_0_t']")).click();
    }


    @Then("^I should see the userform page$")
    public void i_should_see_the_userform_page() throws Throwable {

       /* base.driver.findElement(By.className("_1frb")).isDisplayed();
        Assert.assertEquals("It's not found",  base.driver.findElement(By.className("_1frb")).isDisplayed(), true);
        Assert.a */

     // Assert.assertTrue(base.driver.findElement(By.className("_1frb")).isDisplayed());

    }

    @Then("^I should close the browser$")
    public void i_should_close_the_browser() throws Throwable {
        //base.driver.quit();
    }


    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username= userName;
            password = passWord;
        }
    }
}
