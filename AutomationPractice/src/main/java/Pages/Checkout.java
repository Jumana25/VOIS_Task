package Pages;

import Base.PageBase;
import org.openqa.selenium.By;

public class Checkout extends PageBase {
    Orders order =  new Orders();
    private By paymentsuccessmsg = By.xpath(".//p[@class='alert alert-success']");

    public String verifyCheckout() throws InterruptedException {
        order.goToCheckout();
        return driver.findElement(paymentsuccessmsg).getText();
    }



}
