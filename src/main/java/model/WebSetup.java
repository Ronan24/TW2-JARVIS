package model;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

import static controller.LoginController.waitForLoad;


public class WebSetup {
    private static final WebSetup instance = new WebSetup();

    public static final WebSetup getInstance() {
        return instance;
    }


    private WebDriver driver = null;
    private Robot robot = null;
    private WebDriverWait wait = null;

    private WebSetup() {
        String os = System.getProperty("os.name").toUpperCase();
        if (os.contains("LINUX")) {
            System.out.println("NOT headless LInux");
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
                    e1.printStackTrace();
                }

            if (!target.canExecute())
                try {
                    throw new FileNotFoundException("chrome(linux) copy did not work!");
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            try {
                System.setProperty("webdriver.chrome.driver", target.getCanonicalPath());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (os.contains("WIN")) {
            System.out.println("NOT headless WIndows");
            InputStream res = WebSetup.class.getResourceAsStream("/resources/chromedriver.exe");

            File target = new File(System.getProperty("java.io.tmpdir") + "chromedriver.exe");

            if (!target.exists())
                try {
                    Files.copy(res, target.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            if (!target.canExecute())
                try {
                    throw new FileNotFoundException("chrome.exe(win) copy did not work!");
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            try {
                System.setProperty("webdriver.chrome.driver", target.getCanonicalPath());
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        System.out.println("Chrome driver instance");
        wait = new WebDriverWait(driver, 100);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
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

    public void moveAndClickOn(By by){
        this.moveTo(by);
        this.clickOn(by);
    }

    public void clickOn(By by) {
        WebElement element = this.wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }

    public void sendKey(By by, String key) {
        WebElement element = this.driver.findElement(by);
        element.clear();
        element.sendKeys(key);
    }

    public Integer readInteger(By by) {
        return Integer.parseInt(this.readValue(by).replace(" ", ""));
    }

    public String readValue(By by) {
        WebElement element = this.driver.findElement(by);
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

    public void clickToWorld(String worldName, String username) throws InterruptedException {

        WebElement elem = null;
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


        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();", elem);
    }

    public void hoverAndClick(WebElement elementToHover,WebElement elementToClick) {
        Actions action = new Actions(this.driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();
    }

    public void ByVisibleElement() {
        System.setProperty("webdriver.chrome.driver", "G://chromedriver.exe");
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        //Launch the application
        driver.get("http://demo.guru99.com/test/guru99home/");

        //Find element by link text and store in variable "Element"
        WebElement Element = driver.findElement(By.linkText("Linux"));

        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    private void moveTo(By by){
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
}
