package PageFactoryHW;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by olena on 08.10.18.
 */
public class Tests {

    static WebDriver wd;
    static LoginPG LoginPage;
    static AccountPG AccountPage;
    static String userName;
    static String password;

    @BeforeClass
    public static void setUp(){
        wd = new ChromeDriver();
        userName = "yarmolenko.alena@gmail.com";
        password = "11111";
        wd.manage().timeouts().pageLoadTimeout(10, SECONDS);
//        wd.manage().timeouts().implicitlyWait(10, SECONDS);

        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().setSize(new Dimension(1920,1080));
        LoginPage = PageFactory.initElements(wd, LoginPG.class);
        AccountPage = PageFactory.initElements(wd, AccountPG.class);

    }

    @AfterClass
    public static void tearDown(){
        wd.quit();
    }

    @Test
    public void Login1() {

        LoginPage.login(userName, password);

        Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText(), containsString("MY ACCOUNT"));

    }
    @Test
    @Ignore
    public void Login2() {
        LoginPage.enterUsername(userName);
        LoginPage.enterPassword(password);
        LoginPage.clickSignInBtn();

        Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText(), containsString("MY ACCOUNT"));

    }
    @Test
    public void Logout(){
        AccountPage.logout();

        Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText(), containsString("AUTHENTICATION"));

    }

}
