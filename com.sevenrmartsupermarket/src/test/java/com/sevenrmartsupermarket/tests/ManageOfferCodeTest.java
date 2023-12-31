package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageOfferCodePage;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageOfferCodeTest extends Base
{
	  LoginPage loginpage;
	  ManageOfferCodePage addoffercodepage;
	  PageUtility pageutility;
	  
	  @Test
	  public void verifyaddNewOffer() 
	  {
	   loginpage = new LoginPage(driver);
	   loginpage.login("admin", "admin");
	   addoffercodepage=new ManageOfferCodePage(driver);
	   pageutility=new PageUtility(driver);
		
		addoffercodepage.ClickOnMoreInfo();
	    addoffercodepage.ClickNew();
	    addoffercodepage.enter_Offer("Discount!");
	    addoffercodepage.enter_Percentage("25%");
	    addoffercodepage.enter_Amount("250");
	    addoffercodepage.enter_Description("FLAT 25% OFF ON MAMAEARTH PRODUCT");
	    addoffercodepage.imageUpload();
	    addoffercodepage.clickonSaveButton();
	    
	    boolean actualResult=addoffercodepage.OfferCreatedAlert("Offer Created Successfully");
		Assert.assertTrue(actualResult);
	    
	  }
	  
	  @Test
		public void verifySearchButtonFeatures()
		{
		  loginpage = new LoginPage(driver);
		   loginpage.login("admin", "admin");
		   addoffercodepage=new ManageOfferCodePage(driver);
		   addoffercodepage.ClickOnMoreInfo();
		   addoffercodepage.ClickSearchButton("TestOfferCD656");
		   
		    String expectedText="List Offercodes";
			String actualText=addoffercodepage.getTextOfHeadingSearchListOfferCode();
			Assert.assertEquals(actualText, expectedText);
		}
		
		@Test
		public void verifyResetInsideSearch()
		{
			   loginpage = new LoginPage(driver);
			   loginpage.login("admin", "admin");
			   addoffercodepage=new ManageOfferCodePage(driver);
			   addoffercodepage.ClickOnMoreInfo();
			   addoffercodepage.ClickSearchButton("TestOfferCD484");
			   addoffercodepage.clickReset();
			   
			    String expectedText="List Offercodes";
				String actualText=addoffercodepage.getTextOfHeadingSearchListOfferCode();
				Assert.assertEquals(actualText, expectedText);
		}
		
}
