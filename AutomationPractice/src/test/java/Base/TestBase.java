package Base;

import org.testng.ITestResult;
import org.testng.annotations.*;

import TestUtilities.TestHelper;

public class TestBase {
	@AfterMethod
	public void screenShotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking Screenshot....");
			TestHelper.captureScreenShot(PageBase.driver, result.getName());
		}
	}

	@BeforeClass
	public void setDriver() {
		PageBase.setupDriver();
	}

	@AfterClass
  public void quitbrowser()
	{
		 PageBase.quit();
	}
}
