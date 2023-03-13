package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;


public class HomePage extends CommonMethods {

   @FindBy (xpath = "//input[@id='gh-ac']")
   public WebElement searchTextField;
   @FindBy(id = "gh-btn")
   public WebElement searchBTN;

   @FindBy(xpath = "//ul[@class='srp-results srp-list clearfix']/li[2]/div/div[2]/a")
   public WebElement selectedIphone13;
   @FindBy(xpath = "//span[text()='Add to cart']")
   public WebElement addToCartBTN;
   @FindBy (xpath = "//select[@selectboxlabel='Color']")
   public WebElement colorDD;
   @FindBy (xpath = "//span[text()='Go to cart']")
   public WebElement goToCartBTN;
   @FindBy(xpath = "//h1[@data-test-id='main-title']")
   public WebElement actualCartTitle;
   @FindBy(xpath = "//a[text()='register']")
   public WebElement registerBTN;
   @FindBy(xpath = "//a[text()='Help & Contact']")
   public WebElement helpAndContactBTN;
   @FindBy(xpath = "//span[text()='Contact us']")
   public WebElement contactUsBTN;
   @FindBy (xpath = "//span[text()='Fees & Billing']")
   public WebElement topicOfHelp;
   @FindBy (xpath = "//span[text()='Selling fees']")
   public WebElement continueTopicHelp;
   @FindBy(xpath = "//h1[text()='Help yourself']")
   public WebElement helpYourselfTitle;

   @FindBy(id = "gh-cat")
   public WebElement categoriesDD;

   @FindBy(xpath = "//span[@class='b-pageheader__text']")
   public WebElement categoryHeader;

   @FindBy (xpath = "//button[text()='More filters...']")
   public WebElement moreFiltersOption;

   @FindBy(xpath = "//div[@class='x-overlay-main-panel__aspects']/div/span")
   public List<WebElement> allAiltersOptons;



   @FindBy(xpath = "//button[@aria-label='Cancel']")
   public WebElement cancelButton;








    public HomePage(){
        PageFactory.initElements(driver, this);
    }
}
