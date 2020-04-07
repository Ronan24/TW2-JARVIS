package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;


public class WebSetup {
    private static final WebSetup instance = new WebSetup();

    public static final WebSetup getInstance()
    {
        return instance;
    }


    WebDriver driver = null;
    Robot r = null;
    WebDriverWait wait = null;

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
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getChromeWebDriver() {
        return this.driver;
    }

    public Robot getAWTRobot() {
        return this.r;
    }

    public WebDriverWait getWait() {
        return this.wait;
    }

    public void quitWithDelay() throws InterruptedException {
        if (driver != null) {
            //Thread.sleep(6000);//6 secunde
            driver.quit();
        }

    }


}
