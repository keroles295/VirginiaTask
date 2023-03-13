package testClasses;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePageTests extends CommonMethods {

    //All the screenshots are in TopBlokTask\qa-code-challenge\VTAS1\screenshots

   @Test
    public void testProductSearch(){
       //Navigate to the website homepage, I have used the Methods of @BeforeMethod
       /*
       Enter a search shoes in the search bar
        */
      sendText(homePage.searchTextField, "shoes");
      /*
       Click on search Button
       */
      click(homePage.searchBTN);
      /*
      Verify that the search results page is displayed with relevant products
       */
       String titleText= driver.getTitle();

       Assert.assertTrue(titleText.contains("shoes"));

   }
   @Test
    public void textAddedItemToCart() throws InterruptedException {
       //Navigate to the website homepage, I have used the Methods of @BeforeMethod
       /*
       Enter a search iPhone13 in the search bar
        */
       sendText(homePage.searchTextField, "iPhone13");
      /*
       Click on search Button
       */
       click(homePage.searchBTN);

       String mainPageHandle=driver.getWindowHandle();

       waitForApplicability(homePage.selectedIphone13);
       /*
       Click on the specific Item
        */
       click(homePage.selectedIphone13);

       Set<String> allWindowsHandles=driver.getWindowHandles();

       Iterator<String> iterator=allWindowsHandles.iterator();

       while (iterator.hasNext()) { // start iterating through the handles (tabs)

           String handleItSelf = iterator.next();// get one handle (tab)

           if (!mainPageHandle.equals(handleItSelf)) {

               driver.switchTo().window(handleItSelf);// switch to that specific handle


                /*
                Select the color of the item
               */
               selectDdValue(homePage.colorDD, "Red");
       /*
       Click on Add To Cart Button
        */
               click(homePage.addToCartBTN);
       /*
       Go to the Cart
        */
         click(homePage.goToCartBTN);
       /*
       Verify taht the user could to reach to shopping cart page
        */
               Thread.sleep(6000);
               String expectedCartTitle= "Shopping cart";

               String actualCartTitleText=homePage.actualCartTitle.getText();
               Assert.assertEquals(expectedCartTitle, actualCartTitleText);
           }
       }


   }

   @Test()
    public void testRegistration() throws InterruptedException {
       //Navigate to the website homepage, I have used the Methods of @BeforeMethod

       /*
       click on Registrar Button
        */
       click(homePage.registerBTN);
       /*
       Enter all the information using the config file

        */
       sendText(createNewAccountPage.firstNameTextField, ConfigReader.getPropertyValue("firstName"));
       sendText(createNewAccountPage.lastNameTextField, ConfigReader.getPropertyValue("lastName"));
       sendText(createNewAccountPage.emailTextField, ConfigReader.getPropertyValue("email"));
       sendText(createNewAccountPage.passwordTextField, ConfigReader.getPropertyValue("passwordText"));
       Thread.sleep(5000);

       /*
       click on Create Account Button
        */
       click(createNewAccountPage.createAccountBTN);
       Thread.sleep(6000);
       String expectedTitle = "Register: Create a personal account";
       String actualTitle = driver.getTitle();

       Assert.assertEquals(actualTitle, expectedTitle);


   }

   @Test
    public void testHelpAndContact(){
       //Navigate to the website homepage, I have used the Methods of @BeforeMethod

       /*
       click on help&Contact Button
        */
       click(homePage.helpAndContactBTN);
       /*
       click on contact us
        */
       click(homePage.contactUsBTN);
       /*
       Choose a topic from the menu
        */
       click(homePage.topicOfHelp);
       /*
       Click on the required information in the contact form
        */
       click(homePage.continueTopicHelp);
       /*
       Enter valid email and password
        */
       sendText(createNewAccountPage.userName,"kerolesbotrosp222@gmail.com");
       click(createNewAccountPage.signContinueBTN);
       sendText(createNewAccountPage.passWordOfCurrentUser,"Popo8942#");
       click(createNewAccountPage.signBTN);
       /*
       Verify that the user is able to reach out to the Help Yourself Page
        */
       String actualTextHelp=homePage.helpYourselfTitle.getText();
       String expectedTextHelp="Help yourself";
       Assert.assertEquals(actualTextHelp,expectedTextHelp);



   }


   @Test
    public void verifyAllTheFullTestLinks(){
       //Navigate to the website homepage, I have used the Methods of @BeforeMethod

       List<WebElement> allLinks=driver.findElements(By.tagName("a"));

       for(WebElement eachLink:allLinks){
           String linkText=eachLink.getText();
           String fullLinks=eachLink.getAttribute("href");
           /*
           printing the full links and linksTexts
            */
           if(!linkText.isEmpty()) {
               System.out.println(linkText);
               System.out.println(fullLinks);
           }
       }
   }

   @Test
    public void testUserSelectfromCategoryDD(){
       //Navigate to the website homepage, I have used the Methods of @BeforeMethod

       /*
       Select Baby choice from the Categories DD
        */
       selectDdValue(homePage.categoriesDD, "Baby");
       /*
       click on search Button
        */
       click(homePage.searchBTN);
       /*
       Verify the user is in the Baby page
        */
       String expectedCategoryHeader="Baby Essentials";
       String actualCategoryHeader=homePage.categoryHeader.getText();
       Assert.assertEquals(actualCategoryHeader, expectedCategoryHeader);

   }



    @Test
    public void textMorefiltersFunctions() throws InterruptedException {
        //Navigate to the website homepage, I have used the Methods of @BeforeMethod

       /*
       search for Home Improvement
        */
        sendText(homePage.searchTextField,"Home improvement");
        click(homePage.searchBTN);
       /*
       click on more filters option
        */
        click(homePage.moreFiltersOption);
       /*
       click of price option
        */
        for (WebElement option:homePage.allAiltersOptons){
            if (option.getText().equalsIgnoreCase("Price")){
                click(option);
            }
        }

       /*
       verify that cancel button is e and click on it
        */


        if(homePage.cancelButton.isSelected()){
            Assert.assertTrue(homePage.cancelButton.isDisplayed());
            click(homePage.searchBTN);
        }
    }








}
