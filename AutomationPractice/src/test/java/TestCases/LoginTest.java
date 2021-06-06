package TestCases;

import Base.TestBase;
import Pages.Registeration;
import Pages.SignIn;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginTest extends TestBase {
  CSVReader reader;
  static SignIn  sign ;

  @Test(priority = 0)
  public void verifyLoginwithinvalidcredentials() throws IOException, CsvValidationException {
   sign =  new SignIn();
    // get path of CSV file
    String CSV_file = System.getProperty("user.dir") + "/src/test/java/testData/Login.csv";
    reader = new CSVReader(new FileReader(CSV_file));
    Registeration register = new Registeration();
    String[] csvCell;
    sign.goTosignInPage();
    // while loop will be executed till the lastvalue in CSV file .
    while ((csvCell = reader.readNext()) != null) {
      String email = csvCell[0];
      String passw0rd = csvCell[1];
      String validation = csvCell[2];
      Assert.assertTrue(sign.verifyLoginwithinvalidcredentials(email, passw0rd, validation));
    }
  }
  @Test(priority = 1)
  public void verifyLoginwithvalidcredentials()  {
      Assert.assertTrue(sign.verifyLoginwithvalidcredentials());
    }


}
