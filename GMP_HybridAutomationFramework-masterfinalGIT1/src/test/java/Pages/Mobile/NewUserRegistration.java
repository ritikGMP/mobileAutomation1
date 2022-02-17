package Pages.Mobile;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import CommonUtility.AutomationConfiguration;
import TestNGListeners.ApcoaListeners;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewUserRegistration {
	
	AppiumDriver<WebElement> driver;
	SoftAssert SA=new SoftAssert();
	WebDriverWait wait;
	@SuppressWarnings("rawtypes")
	TouchAction action;

	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/tv_get_started')]")
	private WebElement btnletGetStart;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/tv_next')]")
	private WebElement btnNext;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/btnNext')]")
	private WebElement btnNext2;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/tv_positive_action')]")
	private WebElement btnAllow;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/tv_sign_up_with_email')]")
	private WebElement btnSignUp;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/etEmail')]")
	private WebElement btnEnterEmail;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/btnNext')]")
	private WebElement btnNextafterEmail;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/edt_password')]")
	private WebElement btnEnterPassword;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/cb_terms_conditions')]")
	private WebElement btnCond1;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/cb_privacy_policy')]")
	private WebElement btnCond2;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/et_vehicle_number')]")
	private WebElement btnEditVehcileNumber;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[4]/android.view.View[1]/android.view.View/android.widget.EditText")
	private WebElement btnAddCardNumber;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[4]/android.view.View[2]/android.view.View/android.widget.EditText")
	private WebElement btnAddCardName;     //cardholderName
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[4]/android.view.View[3]/android.view.View/android.widget.EditText")
	private WebElement btnAddExpiryDate;  //expiryDate
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[4]/android.view.View[4]/android.view.View/android.widget.EditText")
	private WebElement btnAddCVV;  //cvv
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[4]/android.view.View[8]/android.widget.Button[1]")
	private WebElement btnAddCard;//primaryButton
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/tv_title')]")
	private WebElement btnPaymentTitle;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/txtPreferredPass')]")
	private WebElement emailconfirm;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/tv_country_name')]")
	private WebElement passwordconfirm;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/iv_menu')]")
	private WebElement btnmenu;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/tv_customer_id')]")
	private WebElement custId;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/iv_close')]")
	private WebElement btnskip;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,':id/tv_title')]")
	private WebElement addvehcnfrm;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public NewUserRegistration(AppiumDriver driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
		wait=new WebDriverWait(driver, 100);
		action=new TouchAction((PerformsTouchActions) driver);
	}
	
	public void FillDetails() throws InterruptedException
	{ApcoaListeners.logInfo("Email Registration Started");
	     System.out.println(AutomationConfiguration.Country);
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnletGetStart,15);
		btnletGetStart.click();
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnNext,20);
		btnNext.click();
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnAllow,20);
		btnAllow.click();
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnSignUp,20);
		btnSignUp.click();
		String emailid=EmailGenerator();
		ApcoaListeners.logInfo("Email id to be enter-->"+emailid);
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnEnterEmail,20);
		btnEnterEmail.sendKeys(emailid);
		
		Thread.sleep(4000);
		
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnNextafterEmail,20);
		btnNextafterEmail.click();
		Thread.sleep(6000);
		SA.assertEquals(emailconfirm.getText(),"Your preferred password");
		ApcoaListeners.logInfo("Email entered Successful");
		ApcoaListeners.logInfo("Going to enter Password");
		ApcoaListeners.logInfo("Password to be enter-->"+"testing");
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnEnterPassword,20);
		btnEnterPassword.sendKeys("testing");
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnCond1,20);
		btnCond1.click();
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnCond2,20);
		btnCond2.click();
		Thread.sleep(4000);
		//CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnNext,200);
		
		btnNext2.click();
		
		Thread.sleep(8000);
		if(AutomationConfiguration.Country.equalsIgnoreCase("Italy"))
		{
			btnNext2.click();
			Thread.sleep(4000);
		}
	
		SA.assertEquals(passwordconfirm.getText(),AutomationConfiguration.Country);
		 ApcoaListeners.logInfo("Email Registered Successfully");
		SA.assertAll();
	}
	
	public void AddVehicle() throws InterruptedException
	{   ApcoaListeners.logInfo("AddVehicle Started:");
	
		Thread.sleep(4000);
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnNext2,20);
		btnNext2.click();
		String vnum=VehicleNumberGenerator();
		ApcoaListeners.logInfo("Going to add vehicle-->"+vnum);
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnEditVehcileNumber,20);
		btnEditVehcileNumber.sendKeys(vnum);
		 Thread.sleep(4000);
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnNext2,20);
		if(!(AutomationConfiguration.Country.equalsIgnoreCase("Sweden")|| AutomationConfiguration.Country.equalsIgnoreCase("Denmark")))
		{	
		   btnNext2.click();
		
		
	//------------------------------------------	
		Thread.sleep(10000);
		SA.assertEquals(addvehcnfrm.getText(),"Setup secure credit card info");
		ApcoaListeners.logInfo("Vehicle Added successfully");
		System.out.println(addvehcnfrm.getText());
		Thread.sleep(3000);
		}
	/*	btnskip.click();
		Thread.sleep(6000);
		btnmenu.click();//Setup secure credit card info
		Thread.sleep(5000);
		SA.assertTrue(!(custId.getText().equals(null)));
	    */
     	SA.assertAll();
		
	
	}
	
	public void AddCard() throws InterruptedException
	{   ApcoaListeners.logInfo("Going to Payment_Card");
	
	    ApcoaListeners.logInfo("Payment_Card---->"+"4012000077777777");
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnAddCardNumber,20);
		btnAddCardNumber.sendKeys("4012000077777777");
		 Thread.sleep(3000);
		ApcoaListeners.logInfo("Username---->"+"Automation Test");
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnAddCardName,20);
		btnAddCardName.sendKeys("Automation Test");
		Thread.sleep(3000);
		ApcoaListeners.logInfo("ExpiryDate---->"+"06/24");
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnAddExpiryDate,20);
		btnAddExpiryDate.sendKeys("06/24");
		Thread.sleep(3000);
		ApcoaListeners.logInfo("CVV---->"+"123");
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnAddCVV,20);
		btnAddCVV.sendKeys("123");
		Thread.sleep(3000);
		CommonUtility.GenericMethods.explicitWaitForWebElementOnly(driver,btnAddCard,20);
		btnAddCard.click();
		Thread.sleep(20000);
		//System.out.println(btnPaymentTitle.getText());
		
	//	SA.assertNotEquals(btnPaymentTitle.getText(),"Payment failed");
		
		btnmenu.click();
		Thread.sleep(5000);
		System.out.println(custId.getText());
		SA.assertTrue(!(custId.getText().equals(null)));
	    
     	SA.assertAll();
	}
	
	public String EmailGenerator()
	{
		String email;
		Random rd = new Random();
		
		String s=String.valueOf(rd.nextInt(100000));     //creating random number string
		email="Automation_NewUser_"+s+"@yopmail.com";
		return email;
		
	}
	
	public String VehicleNumberGenerator()
	{
		String vehnum;
		Random rd= new Random();
		String s=String.valueOf(rd.nextInt(100000));
		if(AutomationConfiguration.Country.equalsIgnoreCase("Austria"))
		{
			vehnum="W A "+s;
		}
		else
		{
			vehnum="W A"+s;
		}
			
		
		return vehnum;
		
	}
}
