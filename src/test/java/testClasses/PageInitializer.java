package testClasses;

import pages.CreateNewAccountPage;
import pages.HomePage;

public class PageInitializer {

    public static HomePage homePage;

    public static CreateNewAccountPage createNewAccountPage;



    public static void initializePageObjects(){

        homePage =new HomePage();
        createNewAccountPage=new CreateNewAccountPage();


    }
}
