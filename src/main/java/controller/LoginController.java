package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginController {


    public static void login(WebSetup webSetup, String username, String password, String worldName, String url) throws InterruptedException {
        webSetup.navigate(url);

        webSetup.sendKey(By.xpath("//input[@type='text']"), username);
        webSetup.sendKey(By.xpath("//input[@type='password']"), password);
        webSetup.submit(By.xpath("//input[@type='password']"));

        Thread.sleep(9000);

        webSetup.clickOn(By.cssSelector("div.play-form>button.button-login"));

        Thread.sleep(5000);


        webSetup.clickToWorld(worldName, username);

    }

    public static void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }


}
