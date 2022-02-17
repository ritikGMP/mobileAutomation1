package Mobile;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import CommonUtility.AutomationConfiguration;
import CommonUtility.CreateSession;
import DataDriven.ExcelDriven;
import Mobile.Utils.SessionUtils;
import MobileObjectMapper.LoginMapper;
import MobileObjectMapper.ParkingMapper;
import MobileObjectMapper.VehicleMapper;
import Pages.Mobile.PageAddVehicle;
import Pages.Mobile.PageHomeApcoa;
import Pages.Mobile.PageLogin;
import Pages.Mobile.PageSelectCountry;
import Pages.Mobile.SessionCreationPage;
import com.fasterxml.jackson.databind.ObjectMapper;


import Pages.Mobile.NewUserRegistration;
import Pages.Mobile.PageSelectCountry;

public class NewUserReg {
	
   WebDriver driver;
   @Parameters({ "Environment", "Country","Tenant","Platform" })
	@BeforeSuite
	public void initializeDriver(String ennv, String country,String tenant, String platform) throws IOException{
		AutomationConfiguration.Tenant = tenant;
		AutomationConfiguration.Environment = ennv;
		AutomationConfiguration.Country = country;
		AutomationConfiguration.Platform = platform;
		CreateSession.readConfigFile("/src/test/java/resources/"+platform+tenant+".properties");
	}
   @Test(priority=1)
   public void selectCountry() throws Exception
   {
	   Thread.sleep(2000);
		PageSelectCountry selectcountry = new PageSelectCountry(AutomationConfiguration.AppiumDriver);
		SoftAssert softAssert = new SoftAssert();
		if(AutomationConfiguration.Tenant.equalsIgnoreCase("Apcoa")) {
			Thread.sleep(10000);
			selectcountry.selectCountryClick();
			Thread.sleep(2000);
			selectcountry.selectCountry(AutomationConfiguration.Country);
			softAssert.assertEquals(AutomationConfiguration.Country.toUpperCase(), selectcountry.CountrySelected.toUpperCase(),"Country not selected" );		
		}
   }
   
   @Test(priority=2)
   public void EmailRegistration() throws InterruptedException
   {
	   NewUserRegistration  NewUsr= new NewUserRegistration(AutomationConfiguration.AppiumDriver);
	   NewUsr.FillDetails();
	   
   }
   @Test(priority=3)
   public void AddVehicle() throws InterruptedException
   {
	   NewUserRegistration  NewUsr= new NewUserRegistration(AutomationConfiguration.AppiumDriver);
       NewUsr.AddVehicle();
	   
   }
   
  @Test(priority=4)
   public void AddPaymentCard() throws InterruptedException
   {
	   NewUserRegistration  NewUsr= new NewUserRegistration(AutomationConfiguration.AppiumDriver);
       NewUsr.AddCard();
	   
   }
   
   
}
      