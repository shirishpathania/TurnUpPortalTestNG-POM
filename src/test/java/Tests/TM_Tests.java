

package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TM_Page;
//import Utilities.CommonDriver;
import Utilities.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TM_Tests extends CommonDriver
    {

        WebDriver driver = new ChromeDriver();
        LoginPage loginPageObj = new LoginPage();
        HomePage homePageObj = new HomePage();
        TM_Page tmPageObj = new TM_Page(driver);

        @BeforeTest
        public void TM_SetUp() throws InterruptedException {
            Thread.sleep(1000);

            // Login page object initialization and definition

            loginPageObj.LoginSteps(driver);

            // Home page object intialization and definition
            
            homePageObj.GoToTMPage(driver);
        }

        @Test(priority = 0, description = "This test checks if a user is able to create a new time record")
        public void CreateTime_Test()
        {
            // TM page object initialization and definition
            
            tmPageObj.CreateTimeRecord(driver, "Keyboard", "M","Unknown Material","500");
            tmPageObj.CreateTMAssertion(driver, "Keyboard", "M","Unknown Material","$500.00");
        }

        @Test(priority = 1, description = "This test checks if a user is able to edit an existing time record")
        public void EditTime_Test()
        {
            tmPageObj.EditTimeRecord(driver, "Mouse", "M","Known Material","100");
            tmPageObj.EditTMAssertion(driver,"Mouse", "M","Known Material","100");
        }

        @Test(priority = 2, description = "This test checks if a user is able to delete an existing time record")
        public void DeleteTime_Test()
        {
            tmPageObj.DeleteTimeRecord(driver);
            tmPageObj.DeleteTMAssertion(driver,"M","Know Material","100");
        }

        @AfterTest
        public void ClosingSteps()
        {
            driver.quit();
        }
    }
