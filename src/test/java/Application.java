package tests;

import odel.User;
import pages.InOutRegWindow;
import pages.Purchase;
import org.junit.Assert;
import org.apache.commons.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Application {
    private WebDriver driver;
    private InOutRegWindow inOutRegWindow;
    protected WebDriverWait wait;
    private Purchase purchase;
    private String loggedUserLogin;
    private String loggedUserPass;
    private JavascriptExecutor js;


    public Application() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        inOutRegWindow = new InOutRegWindow(driver);
        wait = new WebDriverWait(driver, 10);
        purchase = new Purchase(driver);
        js = (JavascriptExecutor) driver;
    }

    public void registration(User user) {
        inOutRegWindow.open();
        inOutRegWindow.accIconInput.click();
        inOutRegWindow.goToReg.click();
        inOutRegWindow.RegLoginInput.sendKeys(user.getEmail());
        loggedUserLogin = user.getEmail();
        inOutRegWindow.passConf(user.getPassword());
        loggedUserPass = user.getPassword();
        inOutRegWindow.fistnameInput.sendKeys(user.getFirstName());
        inOutRegWindow.lastName(user.getLastName());
        inOutRegWindow.registerBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(inOutRegWindow.logoutBtn));
        Assert.assertEquals(driver.getCurrentUrl(), "https://podariudivi.com.ua/personal-area");

    }

    public void purchuasing() {
        purchase.open();
        purchase.search().openProduct().changingAmount().buyPr().openCart().mkOrder();
        try {
            takeSnapShot(driver, "/home/berion/imScreenshot.png");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void logout() {
        inOutRegWindow.logoutPage();
        inOutRegWindow.logoutBtn.click();
    }

    public void login() {
        inOutRegWindow.accIconInput.click();
        inOutRegWindow.LogLoginInput.sendKeys(loggedUserLogin);
        inOutRegWindow.LogPassInput.sendKeys(loggedUserPass);
        inOutRegWindow.loginBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(inOutRegWindow.logoutBtn));
        Assert.assertEquals(driver.getCurrentUrl(), "https://podariudivi.com.ua/personal-area");
        js.executeScript("alert(\"Done!^_^\")");
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);

    }

    public void quit() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
