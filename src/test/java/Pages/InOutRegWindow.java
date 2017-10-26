package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InOutRegWindow extends Page {

    public InOutRegWindow(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://podariudivi.com.ua");
    }

    public void passConf(String pass) {
        RegPassInput.sendKeys(pass);
        RegPassCInput.sendKeys(pass);
    }

    public void logoutPage() {
        driver.get("https://podariudivi.com.ua/personal-area");
    }

    @FindBy(css = ".img-acc")
    public WebElement accIconInput;

    @FindBy(id = "login")
    public WebElement LogLoginInput;

    @FindBy(id = "passLogin")
    public WebElement LogPassInput;

    @FindBy(id = "email")
    public WebElement RegLoginInput;

    @FindBy(id = "password")
    public WebElement RegPassInput;

    @FindBy(id = "password_confirm")
    public WebElement RegPassCInput;

    @FindBy(xpath = "id(\"register_form\")/div[5]/label/input")
    public WebElement fistnameInput;

//    it doesn't work. Don't know why
//    @FindBy(name = "//*[@id=\"register_form\"]/div[6]/label/input")
//    public WebElement lastnameInput;

    public InOutRegWindow lastName(String str) {
        driver.findElement(By.xpath("//*[@id=\"register_form\"]/div[6]/label/input")).sendKeys(str);
        return this;
    }

    @FindBy(name = "Login")
    public WebElement loginBtn;

    @FindBy(name = "registerbtn")
    public WebElement registerBtn;

    @FindBy(xpath = "//span[@id = \"paddLogBottom\"]/span")
    public WebElement goToReg;


    @FindBy(id = "logout")
    public WebElement logoutBtn;


}
