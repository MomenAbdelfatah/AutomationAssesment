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
	 System.out.println(firstItemName);
	 ItemDetailsPage itemDetailsObj = searchPageObj.selectFirstItem();
	 itemDetailsObj.addItemToCart();
	 CartPage cartPageObj = itemDetailsObj.goToCart();
	 String verifyItemName = cartPageObj.getItemName();
	 System.out.println(verifyItemName);
	 Assert.assertTrue(firstItemName.startsWith(verifyItemName.subSequence(0, 10).toString()));
	}
	
	

}
