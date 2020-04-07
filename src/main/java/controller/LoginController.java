package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class LoginController {


    public LoginController(WebDriver driver, WebDriverWait wait, String username, String password, String worldName, String url) throws InterruptedException {
        driver.navigate().to(url);
        driver.manage().window().maximize();
        waitForLoad(driver);

        WebElement elem = driver.findElement(By.xpath("//input[@type='text']"));

        elem.sendKeys(username);
        elem = driver.findElement(By.xpath("//input[@type='password']"));
        elem.sendKeys(password);
        elem.submit();


        Thread.sleep(9000);

        elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.play-form>button.button-login")));

        if (elem.isDisplayed())
            elem.click();
        Thread.sleep(5000);
        if (worldName.contains("isponibila"))
            elem = driver.findElement(By.partialLinkText(username));
        else {
            List<WebElement> worlds = driver.findElements(By.partialLinkText(worldName.trim()));
            if (worlds.size() > 0) {
                System.out.println("world Available !");

                for (WebElement world : worlds) {
                    if (world.getAttribute("innerHTML").contains(username))
                        elem = world;
                    else if (world.getAttribute("innerHTML").contains(username.toUpperCase()))
                        elem = world;
                }

            }
        }

        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();", elem);

    }

    public static void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }


}
