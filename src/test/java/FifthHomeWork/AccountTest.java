package FifthHomeWork;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by olena on 22.09.18.
 */
public class AccountTest {

    static WebDriver wd;

    @BeforeClass
    public static void setUp() {

       wd = new ChromeDriver();
       wd.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
       wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       wd.get("http://automationpractice.com/index.php");

       wd.manage().window().maximize();

        wd.findElement(By.className("login")).click();
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).sendKeys("yarmolenko.alena@gmail.com");
        wd.findElement(By.id("passwd")).click();
        wd.findElement(By.id("passwd")).sendKeys("11111");
        WebElement submit = wd.findElement(By.id("SubmitLogin"));
        submit.click();

    }
    @AfterClass
    public static void tearDown() {
        wd.quit();

    }


    @Test
    public void OrderHistory(){

        Assert.assertTrue(wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")).getText().
                contains("ORDER HISTORY AND DETAILS"));
        wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")).click();
        wd.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a[2]")).click();
    }

    @Test
    public void CreditSlips(){

        Assert.assertTrue(wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a/span")).getText().
                contains("MY CREDIT SLIPS"));
        wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a/span")).click();
        wd.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a[2]")).click();
    }

    @Test
    public void Addresses(){

        Assert.assertTrue(wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span")).getText().
                contains("MY ADDRESSES"));
        wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span")).click();
        wd.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a[2]")).click();
    }

    @Test
    public void PersonalInfo(){

        Assert.assertTrue(wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")).getText().
                contains("MY PERSONAL INFORMATION"));
        wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")).click();
        wd.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a[2]")).click();
    }

    @Test
    public void Wishlists(){

        Assert.assertTrue(wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span")).getText().
                contains("MY WISHLISTS"));
        wd.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span")).click();
        wd.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a[2]")).click();
    }
}
