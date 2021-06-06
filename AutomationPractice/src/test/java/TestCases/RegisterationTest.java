package TestCases;

import Base.TestBase;
import Pages.Registeration;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class RegisterationTest extends TestBase {
    CSVReader reader;

    @Test
    public void verifyRegisteration() throws CsvValidationException, IOException {
        // get path of CSV file
        String CSV_file = System.getProperty("user.dir") + "/src/test/java/testData/Registeration.csv";
        reader = new CSVReader(new FileReader(CSV_file));
        Registeration register = new Registeration();
        String[] csvCell;
        // while loop will be executed till the lastvalue in CSV file .
        while ((csvCell = reader.readNext()) != null) {
            String firstname = csvCell[0];
            String lastname = csvCell[1];
            String password = csvCell[2];
            String address = csvCell[3];
            String city = csvCell[4];
            String state = csvCell[5];
            String postcode = csvCell[6];
            String alias = csvCell[6];

            boolean issignoutdisplayed = register.verifyRegisteration(firstname, lastname, password, address, city, state, postcode, alias);

            Assert.assertTrue(issignoutdisplayed);
        }

    }
}
