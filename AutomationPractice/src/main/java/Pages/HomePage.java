package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.PageBase;

public class HomePage extends PageBase {
	private By signIn = By.xpath(".//a[@class='login']");

	public SignIn goTosignInPage() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(signIn));
		System.out.println("go to sign in page");
		clickButton(driver.findElement(signIn));
		return new SignIn();
	}


	
}
