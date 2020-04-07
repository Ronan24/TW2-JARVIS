package model.building;

import model.WebSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public abstract class BuildingFactory {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BuildingFactory()
    {
        this.driver = WebSetup.getInstance().getChromeWebDriver();
        this.wait = WebSetup.getInstance().getWait();
    }

    public abstract Building buildBuilding();

    protected boolean getIsConstructedByBuildingName(BuildingName buildingName){
        try {
            getLevelBuildingByBuilding(buildingName);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    protected int getLevelBuildingByBuilding(BuildingName buildingName) throws NoSuchElementException{
        WebElement element = this.driver.findElement(By.xpath("//body/div[@id='building-label-wrapper']/div[@id='label-"+
                buildingName.getLabelIdFromMap()+
                "']/a[@class='level-indicator']/span[@class='building-level']/span[1]"));

        //body/div[@id='building-label-wrapper']/div[@id='label-farm']/a[@class='level-indicator']/span[@class='building-level']/span[1]

        return Integer.parseInt(element.getText());
    }
}
