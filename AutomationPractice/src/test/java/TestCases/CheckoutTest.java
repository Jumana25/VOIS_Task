package TestCases;

import Base.TestBase;
import Pages.Checkout;
import Pages.Registeration;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class CheckoutTest extends TestBase {

	@Test
	public void verifyCheckout() throws InterruptedException {

		Checkout checkout = new Checkout();
		Assert.assertEquals(checkout.verifyCheckout(), "Your order on My Store is complete.");
	}

}
