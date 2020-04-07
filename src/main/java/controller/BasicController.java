package controller;

import model.Army;
import model.UnitStaticInfo;
import model.building.BuildingName;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class BasicController {

    private WebDriver driver;
    private WebDriverWait wait;
    private Robot robot;

    public BasicController(WebDriver driver, WebDriverWait wait, Robot robot) {
        this.driver = driver;
        this.wait = wait;
        this.robot = robot;
    }

    public void goToBuilding(BuildingName buildingName) throws InterruptedException {
        WebElement element = this.driver.findElement(By.xpath("//body/div[@id='building-label-wrapper']/div[@id='label-"+
                buildingName.getLabelIdFromMap()+
                "']/a[@class='level-indicator']"));

        element.click();

        Thread.sleep(1000);

        WebElement element1 = this.driver.findElement(By.xpath("//li[@class='context-menu-item open-screen']//div//div[@class='border']"));
        element1.click();

        Thread.sleep(1000);
    }

    public int getQueueSize(){
        try {
            WebElement element = this.driver.findElement(By.xpath("//div[@class='in-queue building-queue short']"));
            return Integer.parseInt(element.getText());
        } catch (NoSuchElementException e){
            return 0;
        }
    }

    public void goBack() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//div[@class='tribe-crest-front level-0']"));
        element.click();
        Thread.sleep(1000);
        element.click();
        Thread.sleep(1000);
    }

    public void goToMainMenu() throws InterruptedException {
        Thread.sleep(8000);

        WebElement element = driver.findElement(By.id("village-zoom"));
        element.click();

        Thread.sleep(3000);
    }

    public void attackVillage(Point point, Army army, Army armyToSend) throws InterruptedException {
        this.goToVillage(point);

        WebElement loc =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class,'context-menu-item custom-army')]//div//div[contains(@class,'border')]")));
        loc.click();
        Thread.sleep(3000);

        int index = 1;

        for (UnitStaticInfo unitStaticInfo : UnitStaticInfo.values()) {
            if (army.getUnitNumberByUnit(unitStaticInfo) > 0){
                if (armyToSend.getUnitNumberByUnit(unitStaticInfo) != null){
                    System.out.println("Let's send " +
                            armyToSend.getUnitNumberByUnit(unitStaticInfo) +
                            " " +
                            unitStaticInfo.name());

                    loc = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[" +
                            index +
                            "]/div[1]/div[3]/input[1]"));
                    loc.sendKeys(String.valueOf(armyToSend.getUnitNumberByUnit(unitStaticInfo)));
                }
                index++;
            }
        }

        loc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'btn-orange btn-form btn-border no-padding')]")));
        loc.click();
        Thread.sleep(2000);
        this.goToMainMenu();
    }

    public void goToVillage(Point point) throws InterruptedException {
        WebElement loc =  wait.until(ExpectedConditions.elementToBeClickable(By.id("world-map")));
        loc.click();
        loc =  driver.findElement(By.xpath("//input[@type='number']"));
        loc.clear();
        loc.sendKeys(String.valueOf(point.x));
        loc =driver.findElement(By.xpath("(//input[@type='number'])[2]"));
        loc.clear();
        loc.sendKeys(String.valueOf(point.y));
        loc = driver.findElement(By.xpath("//footer[@id='interface-bottom-container']//td[3]//div[1]"));
        loc.click();


    }
}
