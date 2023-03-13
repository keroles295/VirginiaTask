package testClasses;

import org.junit.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;

public class TextD extends CommonMethods {
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
}
