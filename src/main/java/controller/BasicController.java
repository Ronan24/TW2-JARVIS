package controller;

import model.unit.Army;
import model.unit.UnitStaticInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class BasicController {
    private static final BasicController instance = new BasicController();

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicController.class);

    public static BasicController getInstance() {
        return instance;
    }

    private WebSetup webSetup;

    private BasicController() {
        this.webSetup = WebSetup.getInstance();
    }

    public void attackVillage(Point point, Army army, Army armyToSend) throws InterruptedException {
        this.goToVillage(point);

        webSetup.clickOn(By.xpath("//li[contains(@class,'context-menu-item custom-army')]//div//div[contains(@class,'border')]"));
        Thread.sleep(2000);

        int index = 1;

        for (UnitStaticInfo unitStaticInfo : UnitStaticInfo.values()) {
            if (army.getUnitNumberByUnit(unitStaticInfo) > 0) {
                if (armyToSend.getUnitNumberByUnit(unitStaticInfo) != 0) {
                    LOGGER.debug("Let's send {} {}", armyToSend.getUnitNumberByUnit(unitStaticInfo), unitStaticInfo);

                    webSetup.sendKey(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[" +
                                    index +
                                    "]/div[1]/div[3]/input[1]"),
                            String.valueOf(armyToSend.getUnitNumberByUnit(unitStaticInfo)));
                }
                index++;
            }
        }

        webSetup.clickOn(By.xpath("//a[contains(@class,'btn-orange btn-form btn-border no-padding')]"));
    }

    public void goToVillage(Point point) {
        webSetup.clickOn(By.id("world-map"));
        webSetup.sendKey(By.xpath("//input[@type='number']"), String.valueOf(point.x));
        webSetup.sendKey(By.xpath("(//input[@type='number'])[2]"), String.valueOf(point.y));
        webSetup.clickOn(By.xpath("//footer[@id='interface-bottom-container']//td[3]//div[1]"));
    }

    public String getUserName() {
        String userInfo = webSetup.readValue(By.xpath("//div[@id='info-player']//h4"));
        return userInfo.split(" ")[0];
    }

    public int getUserRank() {
        return webSetup.readInteger(By.xpath("//div[@id='info-player-rank']//div[@class='info-player-text']"));
    }

    public int getUserPoints() {
        return webSetup.readInteger(By.xpath("//div[@id='info-player-money']//div[@class='info-player-text']"));
    }

    public Point getCurrentLocation() {
        String locationString = webSetup.readValue(By.xpath("//div[@id='info-town']//h4//span"));
        String[] locationStringList = locationString.replace("(", "").replace(")", "").split("\\|");
        return new Point(Integer.parseInt(locationStringList[0]), Integer.parseInt(locationStringList[1]));
    }

    public String getCurrentVillageName() {
        return webSetup.readValue(By.xpath("//div[@id='village-name']"));
    }

    public void enterIntoVillage(Point localisation) {
        try {
            this.webSetup.readValue(By.xpath("//div[@id='label-headquarter']//span[@class='building-name']"));
        } catch (TimeoutException e) {
            this.goToVillage(localisation);
            this.webSetup.clickOn(By.xpath("//div[@class='menu-highlight']"));
        }
    }

    public void nextVillage() {
        this.webSetup.clickOn(By.xpath("//a[@id='switch-village-next']"));
    }
}
