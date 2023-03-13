package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class CreateNewAccountPage extends CommonMethods {

    @FindBy (id = "firstname")
    public WebElement firstNameTextField;
    @FindBy (id = "lastname")
    public WebElement lastNameTextField;
    @FindBy (id = "Email")
    public WebElement emailTextField;
    @FindBy(id = "password")
    public WebElement passwordTextField;
    @FindBy(id="EMAIL_REG_FORM_SUBMIT")
    public WebElement createAccountBTN;

    @FindBy(id = "userid")
    public WebElement userName;
    @FindBy (id="signin-continue-btn")
    public WebElement signContinueBTN;
    @FindBy(id = "sgnBt")
    public WebElement signBTN;
    @FindBy(id="pass")
    public WebElement passWordOfCurrentUser;




    public CreateNewAccountPage(){
        PageFactory.initElements(driver, this);
    }
}
