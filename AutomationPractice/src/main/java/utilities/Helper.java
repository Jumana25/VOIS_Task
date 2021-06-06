package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Helper {

	public static String getRandomMail() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr + "@gmail.com";

	}
	 //Method to generate random Number.
    public static String generateRandomNumber(int length) {
        char[] chars = "0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randomString = sb.toString();
        return randomString;
    }
	// wait until drop down list options loaded
	public static void waitddl(WebDriver driver, final By by, String visibleText) {

		try {
			// Waits for 20 seconds
			WebDriverWait wait = new WebDriverWait(driver, 20);
			// Wait until expected condition size of the dropdown increases and becomes more
			// than 1
			wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					Select select = new Select(driver.findElement(by));
					return select.getOptions().size() > 1;
				}
			});

			// To select the first option
			Select select = new Select(driver.findElement(by));
			getAllOptions(by, driver);
			select.selectByVisibleText(visibleText);

			System.out.println("The " + visibleText + " was selected");
		} catch (Throwable e) {
			System.out.println("Error found: " + e.getMessage());
		}
	}
	// Get all the drop down list options text
	public static List<String> getAllOptions(By by, WebDriver driver) {
		List<String> options = new ArrayList<String>();
		for (WebElement option : new Select(driver.findElement(by)).getOptions()) {
			String txt = option.getText();
			if (option.getAttribute("value") != "")
				options.add(option.getText());
		}
		return options;
	}

	// press elemnet using javascript
	/**
	 * This function click on an element
	 * @param driver
	 * @param btn_ID
	 * @param ctrlName
	 */
	public static void pressElement(WebDriver driver, By btn_ID, String ctrlName) {

		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("scroll(0, 250)");
			executor.executeScript("arguments[0].click();", driver.findElement(btn_ID));

			System.out.println("The " + ctrlName + " was pressed successfully");
		} catch (Exception e) {

			System.out.println("The " + ctrlName + " wasn't pressed as " + e.getMessage());
		}
	}

	// remove element
	public static void removeElement(WebDriver driver, String elementName) {
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript("return document.getElementsByClassName('" + elementName + "')[0].remove();");

	}

}
