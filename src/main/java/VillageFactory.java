import model.ResourceType;
import model.UnitStaticInfo;
import model.Village;
import model.WebSetup;
import model.building.BuildingName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class VillageFactory {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public VillageFactory(WebSetup websetup)
    {
        this.driver = websetup.getChromeWebDriver();
        this.wait = websetup.getWait();
    }

    public Village buildVillage() throws InterruptedException {
        Village village = new Village();

        for (BuildingName buildingName : BuildingName.values()) {
            village.addBuilding(buildingName, buildingName.getBuildingFactory().buildBuilding());
        }

        for (ResourceType resourceType : ResourceType.values()) {
            int amount = Integer.parseInt(driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='interface-top']/div[@class='interface-wrapper']/div[@id='top-wrapper']/div[@id='resource-bar']/div[@id='resources-wrapper']/div[" +
                    resourceType.getIndex() +
                    "]/div[2]/div[1]")).getText().replaceAll(" ",""));

            village.addResource(resourceType, amount);
        }

        for (UnitStaticInfo unitStaticInfo : UnitStaticInfo.values()) {
            String amountString = driver.findElement(By.xpath("//div[@id='topinterface-right-wrapper']//li[" +
                    unitStaticInfo.getIndex() +
                    "]//div[1]//div[1]")).getText();

            if (amountString.isEmpty()){
                amountString = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='topinterface-right-wrapper']/div[@id='unit-bar']/ul/li[" +
                        unitStaticInfo.getIndex() +
                        "]/div[1]/div[1]")).getText();
            }

            village.addUnit(unitStaticInfo, Integer.parseInt(amountString));
        }

        System.out.println("Elements charged");

        return village;
    }
}
