package FifthHomeWork;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

/**
 * Created by olena on 26.09.18.
 */
public class SearchTest {

    static WebDriver wd;

    @BeforeClass
    public static void setUp() {

        wd = new ChromeDriver();
        wd.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        wd.get("http://automationpractice.com/index.php");

        wd.manage().window().maximize();

    }
    @AfterClass
    public static void tearDown() {
        wd.quit();

    }

@Test

    public void verifySearchResult(){

        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).sendKeys("Printed Summer Dress");
        wd.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();

    Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).
            getText(), containsString("3"));

    Assert.assertThat(wd.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]")).
            getText(), containsString("Printed Summer Dress"));
}

}
