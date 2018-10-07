package PageFactoryHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by olena on 07.10.18.
 */
public class AccountPG {

    public WebDriver wd;

    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    public WebElement SignOut;

    public void logout(){

        SignOut.click();
    }
}
