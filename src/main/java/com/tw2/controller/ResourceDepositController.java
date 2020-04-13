package com.tw2.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class ResourceDepositController {
    private static final ResourceDepositController instance = new ResourceDepositController();

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceDepositController.class);

    public static ResourceDepositController getInstance() {
        return instance;
    }

    private WebSetup webSetup;
    private Date waitUntil;

    private ResourceDepositController() {
        this.webSetup = WebSetup.getInstance();
        this.waitUntil = null;
    }

    private void goToResourceDeposit() {
        this.webSetup.clickOn(By.xpath("//a[@id='toggle-village-drop-down']"));
        this.webSetup.clickOn(By.xpath("//div[@id='interface-top']//tr[1]"));
    }

    private void exitResourceDeposit() {
        this.webSetup.clickOn(By.cssSelector("div.window-open:nth-child(2) section.screen-resource-deposit.twx-window.screen.left:nth-child(15) div.win-content header.win-head ul.list-btn:nth-child(2) li:nth-child(1) > a.size-34x34.btn-red.icon-26x26-close"));
    }

    private void collectResource() {
        this.webSetup.clickOn(By.xpath("//a[@class='btn-green collect animation-glow-green']"));
    }

    private void acceptNextMission() {
        this.webSetup.moveAndClickOn(By.xpath("//table[1]//tbody[1]//tr[1]//td[1]//div[4]//span[1]"), 10);
    }

    private Date getNextMissionsReload() {
        String coolDownRetrievedString = this.webSetup.readValue(By.xpath("//span[contains(@class,'time-remaining text-black')]"));
        Date result = this.calculateDateFromCoolDown(coolDownRetrievedString);

        LOGGER.debug("Next reload at : {}", result);

        return result;
    }

    private Date getMissionCoolDown() {
        String coolDownRetrievedString = this.webSetup.readValue(By.xpath("//div[contains(@class,'highlight-border')]//div[contains(@class,'progress-wrapper')]//span"));
        Date result = this.calculateDateFromCoolDown(coolDownRetrievedString);

        LOGGER.debug("Mission end at : {}", result);

        return result;
    }

    private Date calculateDateFromCoolDown(String coolDownString) {
        String[] coolDownStringList = coolDownString.split(":");

        Calendar result = Calendar.getInstance();
        result.add(Calendar.HOUR, Integer.parseInt(coolDownStringList[0]));
        result.add(Calendar.MINUTE, 1 + Integer.parseInt(coolDownStringList[1]));
        result.add(Calendar.SECOND, Integer.parseInt(coolDownStringList[2]));

        return result.getTime();
    }

    public void execute(){
        if (this.waitUntil == null || this.waitUntil.before(Date.from(Instant.now()))){
            this.goToResourceDeposit();

            try {
                this.collectResource();
                Thread.sleep(2000);
            } catch (TimeoutException e) {
                LOGGER.debug("No mission to collect");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                this.acceptNextMission();
                this.waitUntil = this.getMissionCoolDown();
            } catch (NoSuchElementException e) {
                LOGGER.debug("There is no more missions for now...");

                this.waitUntil = this.getNextMissionsReload();
            } finally {
                this.exitResourceDeposit();
            }
        } else {
            LOGGER.debug("We need to wait until {}", this.waitUntil);
        }
    }
}
