package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.HighLightDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PageBase {
    public static Properties config = new Properties();
    public static FileInputStream fis;
    public static WebDriver driver;
    public JavascriptExecutor jse;
    public static WebDriverWait wait ;

    public PageBase() {

        }

        public static void setupDriver () {


                System.out.print("launch");
                try {
                    fis = new FileInputStream(
                            System.getProperty("user.dir") + "/src/test/resources/properities/prop.properties");
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    config.load(fis);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                }
                if (config.getProperty("browser").equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver",
                            System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
                }
                driver = new HighLightDriver();
                driver.get(config.getProperty("BaseURL"));
                wait = new WebDriverWait(driver, 20);
                driver.manage().window().maximize();

        }


    protected static void quit() {

        driver.quit();

    }

    protected static void clickButton(WebElement button) {
        button.click();
    }

    protected static void setTextWebElement(WebElement textElement, String value) {
        textElement.clear();
        textElement.sendKeys(value);

    }



    protected static boolean isDisplayed(WebElement element) {
        return (element.isDisplayed());

    }

    protected void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1500)");
    }

    protected String getEmail() {
	return(config.getProperty("email"))	;
    }

	protected String getPassword() {
		return(config.getProperty("password"))	;
	}
}
