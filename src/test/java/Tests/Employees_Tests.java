package Tests;

import Pages.EmployeesPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.CommonDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Employees_Tests extends CommonDriver
{
    LoginPage loginPageObj = new LoginPage();
    HomePage homePageObj = new HomePage();
    EmployeesPage employeePageObj = new EmployeesPage();

    @BeforeTest
    public void EmployeeSetUp()
    {
        driver = new ChromeDriver();


        loginPageObj.LoginSteps(driver);


        homePageObj.GoToEmployeePage(driver);
    }

    @Test
    public void CreateEmployeeTest()
    {

        employeePageObj.CreateEmployee();
    }

    @Test
    public void EditEmployeeTest()
    {
        employeePageObj.EditEmployee();
    }

    @Test
    public void DeleteEmployeeTest()
    {
        employeePageObj.DeleteEmployee();
    }

   @AfterTest
    public void TearDown()
    {
        driver.quit();
    }

}
