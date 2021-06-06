package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Helper;

public class ProductDetails extends PageBase {

    MyAccount account = new MyAccount();
    private By addToCartbtn = By.xpath(".//p[@id='add_to_cart']/button");
    private By proceedaddToCartbtn = By.xpath(".//a[@title='Proceed to checkout']");

    public Orders goToOrders() throws InterruptedException {
        account.goToProductPage();

        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartbtn));
        clickButton(driver.findElement(addToCartbtn));


        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedaddToCartbtn));
        clickButton(driver.findElement(proceedaddToCartbtn));

        return new Orders();
    }


}
