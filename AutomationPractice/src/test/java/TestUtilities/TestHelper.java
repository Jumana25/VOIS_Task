package TestUtilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestHelper {
	 public static void captureScreenShot(WebDriver driver, String screenshotname) {
	        Path dest = Paths.get("./Screenshots", screenshotname + ".png");
	        try {
	            Files.createDirectories(dest.getParent());
	            FileOutputStream out = new FileOutputStream(dest.toString());
	            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
	            out.close();

	        } catch (IOException e) {
	            System.out.println("Exception while taking screenshot" + e.getMessage());
	        }
	    }



}
