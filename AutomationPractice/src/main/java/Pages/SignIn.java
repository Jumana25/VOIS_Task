package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Helper;

public class SignIn extends PageBase {
    WebDriverWait wait = new WebDriverWait(driver, 50);
    HomePage hp = new HomePage();
    private By createAccountbtn = By.id("SubmitCreate");
    private By regEmailtxt = By.id("email_create");
    private By LoginEmailtxt = By.id("email");
    private By LoginPasswordtxt = By.id("passwd");
    private By submitbtn = By.id("SubmitLogin");
    public By validationError = By.xpath(".//div[@class='alert alert-danger']//p");
    private By logout = By.xpath(".//div//a[@class='logout']");

    public Registeration goToRegestirationPage() {
        hp.goTosignInPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(regEmailtxt));
        setTextWebElement(driver.findElement(regEmailtxt), Helper.getRandomMail());

        clickButton(driver.findElement(createAccountbtn));
        return new Registeration();
    }

    public MyAccount doLogin() {
        hp.goTosignInPage();
        fillLoginFields();
        return new MyAccount();

    }

    public void fillLoginFields() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginEmailtxt));
        setTextWebElement(driver.findElement(LoginEmailtxt), getEmail());

        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPasswordtxt));
        setTextWebElement(driver.findElement(LoginPasswordtxt), getPassword());

        wait.until(ExpectedConditions.visibilityOfElementLocated(submitbtn));
        clickButton(driver.findElement(submitbtn));
    }

    public boolean verifyLoginwithinvalidcredentials(String email, String password, String validationError) {
        boolean valid = false;
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginEmailtxt));
        setTextWebElement(driver.findElement(LoginEmailtxt), email);

        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPasswordtxt));
        setTextWebElement(driver.findElement(LoginPasswordtxt), password);

        wait.until(ExpectedConditions.visibilityOfElementLocated(submitbtn));
        clickButton(driver.findElement(submitbtn));

        if (validationError.equalsIgnoreCase(driver.findElement(this.validationError).getText())) {
            valid = true;
        }

        return valid;

    }

    public void goTosignInPage() {
        hp.goTosignInPage();
    }

    public boolean verifyLoginwithvalidcredentials() {
        fillLoginFields();
        return (isDisplayed(driver.findElement(logout)));
    }


}
