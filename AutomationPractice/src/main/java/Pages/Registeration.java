package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Helper;

public class Registeration extends PageBase {

	private By firstnametxt = By.id("customer_firstname");
	private By lastnametxt = By.id("customer_lastname");
	private By passwordtxt = By.id("passwd");
	private By addresstxt = By.id("address1");
	private By citytxt = By.id("city");
	private By stateselect = By.id("id_state");
	private By postcodetxt = By.id("postcode");
	private By mobiletxt = By.id("phone_mobile");
	private By aliastxt = By.id("alias");
	private By submitbtn = By.id("submitAccount");
	private By signoutlink = By.xpath(".//a[@class='logout']");

	public boolean verifyRegisteration(String firstname, String lastname, String password, String address, String city,
			String state, String postcode, String alias) {
		SignIn lg = new SignIn();
		lg.goToRegestirationPage();

		wait.until(ExpectedConditions.visibilityOfElementLocated(firstnametxt));
		setTextWebElement(driver.findElement(firstnametxt), firstname);

		wait.until(ExpectedConditions.visibilityOfElementLocated(lastnametxt));
		setTextWebElement(driver.findElement(lastnametxt), lastname);

		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordtxt));
		setTextWebElement(driver.findElement(this.passwordtxt), password);

		wait.until(ExpectedConditions.visibilityOfElementLocated(addresstxt));
		setTextWebElement(driver.findElement(this.addresstxt), address);

		wait.until(ExpectedConditions.visibilityOfElementLocated(citytxt));
		setTextWebElement(driver.findElement(this.citytxt), city);

		Helper.waitddl(driver,stateselect,state);

		setTextWebElement(driver.findElement(mobiletxt), Helper.generateRandomNumber(12));
		setTextWebElement(driver.findElement(postcodetxt), postcode);
		setTextWebElement(driver.findElement(aliastxt), alias);
		clickButton(driver.findElement(submitbtn));
		return isDisplayed(driver.findElement(signoutlink));
	}

}
