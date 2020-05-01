package com.tw2.controller;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.tw2.controller.LoginController.waitForLoad;


public class WebSetup {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSetup.class);

    private static final WebSetup instance = new WebSetup();

    public static WebSetup getInstance() {
        return instance;
    }


    private WebDriver driver = null;
    private Robot robot = null;
    private WebDriverWait wait = null;

    private WebSetup() {
        String os = System.getProperty("os.name").toUpperCase();
        if (os.contains("LINUX")) {
            LOGGER.info("NOT headless Linux");
            InputStream res = WebSetup.class.getResourceAsStream("/resources/chromedriver");


            File target = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "chromedriver");

            if (!target.exists())
                try {
                    Files.copy(res, target.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    Set<PosixFilePermission> perms = new HashSet<>();
                    perms.add(PosixFilePermission.OWNER_READ);
                    perms.add(PosixFilePermission.OWNER_WRITE);
                    perms.add(PosixFilePermission.OWNER_EXECUTE);

                    Files.setPosixFilePermissions(target.toPath(), perms);
                } catch (IOException e1) {
                    LOGGER.error(e1.getMessage());
                }

            if (!target.canExecute())
                try {
                    throw new FileNotFoundException("chrome(linux) copy did not work!");
                } catch (FileNotFoundException e1) {
                    LOGGER.error(e1.getMessage());
                }
            try {
                System.setProperty("webdriver.chrome.driver", target.getCanonicalPath());
            } catch (IOException e1) {
                LOGGER.error(e1.getMessage());
            }
        }
        if (os.contains("WIN")) {
            LOGGER.info("NOT headless Windows");
            InputStream res = WebSetup.class.getResourceAsStream("/chromedriver.exe");

            File target = new File(System.getProperty("java.io.tmpdir") + "chromedriver.exe");

            if (!target.exists())
                try {
                    Files.copy(res, target.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e1) {
                    LOGGER.error(e1.getMessage());
                }
            if (!target.canExecute())
                try {
                    throw new FileNotFoundException("chrome.exe(win) copy did not work!");
                } catch (FileNotFoundException e1) {
                    LOGGER.error(e1.getMessage());
                }
            try {
                System.setProperty("webdriver.chrome.driver", target.getCanonicalPath());
            } catch (IOException e1) {
                LOGGER.error(e1.getMessage());
            }

        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        LOGGER.info("Chrome driver instance");
        wait = new WebDriverWait(driver, 100);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void quitWithDelay() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(6000);
            driver.quit();
        }
    }

    public void navigate(String url) {
        this.driver.navigate().to(url);
        this.driver.manage().window().maximize();
        waitForLoad(driver);
    }

    public void moveAndClickOn(By by) {
        this.moveAndClickOn(by, 5);
    }

    public void moveAndClickOn(By by, int seconds) {
        this.moveTo(by);
        this.clickOn(by, seconds);
    }

    public void moveAndSendKey(By by, String key) {
        this.moveTo(by);
        this.sendKey(by, key);
    }

    public void clickOn(By by) {
        this.clickOn(by, 5);
    }

    public void clickOn(By by, int seconds) {
        WebElement element = this.wait.withTimeout(seconds, TimeUnit.SECONDS).until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }

    public void sendKey(By by, String key) {
        this.sendKey(by, key, 10);
    }

    public void sendKey(By by, String key, int seconds) {
        WebElement element = this.wait.withTimeout(seconds, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear();
        element.sendKeys(key);
    }

    public Integer readInteger(By by) {
        return this.readInteger(by, 5);
    }

    public Integer readInteger(By by, int seconds) {
        return Integer.parseInt(this.readValue(by, seconds).replace(" ", ""));
    }

    public String readValue(By by) {
        return this.readValue(by, 10);
    }

    public String readValue(By by, int seconds) {
        WebElement element = this.wait.withTimeout(seconds, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getText();
    }

    public void submit(By by) {
        WebElement element = this.driver.findElement(by);
        element.submit();
    }

    public void zoomOut() throws InterruptedException {
        this.robot.keyPress(KeyEvent.VK_CONTROL);
        this.robot.keyPress(KeyEvent.VK_SUBTRACT);
        this.robot.keyRelease(KeyEvent.VK_CONTROL);
        this.robot.keyRelease(KeyEvent.VK_SUBTRACT);
        Thread.sleep(1000);
    }

    public void clickToWorld(String worldName, String username) {

        WebElement elem = null;
        List<WebElement> worlds = driver.findElements(By.partialLinkText(worldName.trim()));
        if (!worlds.isEmpty()) {
            LOGGER.info("world Available !");

            for (WebElement world : worlds) {
                if (world.getAttribute("innerHTML").contains(username)
                        || world.getAttribute("innerHTML").contains(username.toUpperCase())) {
                    elem = world;
                }
            }

        }


        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();", elem);
    }

    public void hoverAndClick(WebElement elementToHover, WebElement elementToClick) {
        Actions action = new Actions(this.driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();
    }

    private void moveTo(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
}
