package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Orders extends PageBase {
    ProductDetails details =  new ProductDetails();
    private By checkoutonebtn = By.xpath(".//p/a[@title='Proceed to checkout']");
    private By checkouttwobtn = By.name("processAddress");
    private By termsck = By.id("uniform-cgv");
    private By checkoutthreebtn = By.name("processCarrier");
    private By cheque = By.xpath(".//a[@class='cheque']");
    private By confirmOrderbtn = By.xpath(".//p[@id='cart_navigation']/button");

    public void goToCheckout() throws InterruptedException {
        details.goToOrders();

        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutonebtn));
        clickButton(driver.findElement(checkoutonebtn));

        wait.until(ExpectedConditions.visibilityOfElementLocated(checkouttwobtn));
        clickButton(driver.findElement(checkouttwobtn));

        wait.until(ExpectedConditions.visibilityOfElementLocated(termsck));
        clickButton(driver.findElement(termsck));

        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutthreebtn));
        clickButton(driver.findElement(checkoutthreebtn));

        wait.until(ExpectedConditions.visibilityOfElementLocated(cheque));
        clickButton(driver.findElement(cheque));

        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderbtn));
        clickButton(driver.findElement(confirmOrderbtn));


    }



}
