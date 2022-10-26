package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TodaysDealsPage;

public class TodayDealsTest extends TestBase {
	
	
	public TodayDealsTest() throws IOException {
		super();
	}

	@Test
	public void userCanFilterProducts() {
		TodaysDealsPage todaysDealsObj = homePageObj.openTodaysDeals();
		todaysDealsObj.selectHeadphonesAndgroceryFromFilters();
		todaysDealsObj.selectTenPercentDiscount();
		todaysDealsObj.selectThefourthPage();
		todaysDealsObj.AddItemToCart();
		Assert.assertTrue(todaysDealsObj.getAddedToCartMessage().contains("Added to Cart")); 
	}

}
