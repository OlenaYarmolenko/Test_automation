package PageFactoryHW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by olena on 07.10.18.
 */
public class LoginPG {

    public WebDriver wd;

    @FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    public WebElement SignIn;

    @FindBy(how = How.NAME, using = "email")
    public WebElement txtbx_Email;

    //@FindBy(how = How.XPATH, using = "//*[@id=\"passwd\"]")//using = "//*[@id=\"passwd\"]")
    @FindBy(how = How.NAME,using = "passwd")
    public WebElement txtbx_Password;

    @FindBy (how = How.ID, using = "SubmitLogin")
    public WebElement btn_SignIn;

        void enterUsername(String userName){
            txtbx_Email.sendKeys(userName);
        }

        void enterPassword(String password){
            txtbx_Password.sendKeys(password);
        }
       void clickSignInBtn(){
            btn_SignIn.click();
       }
    public void login(String userName, String password){

           enterUsername(userName);
           enterPassword(password);
           clickSignInBtn();
    }


}
