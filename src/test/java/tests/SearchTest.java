package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.ItemDetailsPage;
import pages.SearchResultsPage;

public class SearchTest extends TestBase {
	
	public SearchTest() throws IOException {
		super();
	}

	@Test
	public void userCanAddItemToCart() {
	 SearchResultsPage searchPageObj = homePageObj.typeTextInSearchBox(prop.getProperty("ProductName"));
	 String firstItemName = searchPageObj.getfirstItemName();
	 ItemDetailsPage itemDetailsObj = searchPageObj.selectFirstItem();
	 itemDetailsObj.addItemToCart();
	 CartPage cartPageObj = itemDetailsObj.goToCart();
	 String verifyItemName = cartPageObj.getItemName();
	 Assert.assertTrue(firstItemName.contains(verifyItemName.subSequence(0, 10).toString()));
	}
	
	

}
