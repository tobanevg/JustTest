package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;

public class Purchase extends Page {


    public Purchase(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://podariudivi.com.ua/shop");
    }

    public Purchase search() {
        driver.findElement(By.cssSelector("input.first-input-form")).sendKeys("Блокнот" + Keys.RETURN);
        return this;
    }

    public Purchase openProduct() {
        driver.findElement(By.xpath("//div[2]/div[2]/div[5]/a/div[1]/img")).click();
        return this;
    }

    public Purchase changingAmount() {
        actions.doubleClick(driver.findElement(By.xpath("//div[3]/div[1]/input[2]"))).build().perform();
        return this;
    }

    public Purchase buyPr() {
        driver.findElement(By.xpath("//div[1]/button[1]")).click();
        return this;
    }

    public Purchase openCart() {
        driver.findElement(By.id("openCart")).click();
        return this;
    }

    public Purchase mkOrder() {
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("#msCart > a")))).click();
        return this;
    }


}
