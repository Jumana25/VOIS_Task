package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Helper;

import java.util.List;

public class MyAccount extends PageBase {
   SignIn sign = new SignIn();
   private By womenlink = By.xpath(".//a[@title='Women']");
   private By productsul = By.xpath(".//a[@class='product_img_link']");

   public void goToWomenShopping()
   {

      sign.doLogin();
      wait.until(ExpectedConditions.visibilityOfElementLocated(womenlink));
      clickButton(driver.findElement(womenlink));

   }

   public ProductDetails goToProductPage() throws InterruptedException {
      goToWomenShopping();
      wait.until(ExpectedConditions.visibilityOfElementLocated(productsul));
      List<WebElement> elements = driver.findElements(productsul);
      if(elements.size()>0) {
         Actions action = new Actions(driver);

         Helper.removeElement(driver, "quick-view-wrapper-mobile");
         Helper.removeElement(driver, "quick-view");
         action.moveToElement(elements.get(0)).click().build().perform();

         // clickButton(elements.get(1));
      }
      return new ProductDetails();
   }


}
