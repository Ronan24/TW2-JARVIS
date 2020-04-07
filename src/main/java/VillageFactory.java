import model.ResourceType;
import model.UnitStaticInfo;
import model.Village;
import model.WebSetup;
import model.building.BuildingName;
import org.openqa.selenium.By;

/**
 * Created by ronan
 * on 05/04/2020.
 */
public class VillageFactory {
    private WebSetup webSetup;

    public VillageFactory(WebSetup websetup) {
        this.webSetup = websetup;
    }

    public Village buildVillage() throws InterruptedException {
        Village village = new Village();

        for (BuildingName buildingName : BuildingName.values()) {
            village.addBuilding(buildingName, buildingName.getBuildingFactory().buildBuilding());
        }

        for (ResourceType resourceType : ResourceType.values()) {
            int amount = webSetup.readInteger(By.xpath("//body/div[@id='wrapper']/div[@id='interface-top']/div[@class='interface-wrapper']/div[@id='top-wrapper']/div[@id='resource-bar']/div[@id='resources-wrapper']/div[" +
                    resourceType.getIndex() +
                    "]/div[2]/div[1]"));

            village.addResource(resourceType, amount);
        }

        for (UnitStaticInfo unitStaticInfo : UnitStaticInfo.values()) {
            String amountString = webSetup.readValue(By.xpath("//div[@id='topinterface-right-wrapper']//li[" +
                    unitStaticInfo.getIndex() +
                    "]//div[1]//div[1]"));

            if (amountString.isEmpty()) {
                amountString = webSetup.readValue(By.xpath("//body/div[@id='wrapper']/div[@id='topinterface-right-wrapper']/div[@id='unit-bar']/ul/li[" +
                        unitStaticInfo.getIndex() +
                        "]/div[1]/div[1]"));
            }

            village.addUnit(unitStaticInfo, Integer.parseInt(amountString));
        }

        System.out.println("Elements charged");

        return village;
    }
}
