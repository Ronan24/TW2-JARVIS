# TW2-JARVIS

This project, based on this [setup](https://github.com/spectral369/TW2-Bot) create a bot to play at [Tribal Wars 2](https://us.tribalwars2.com/#/).

## Program Details:  
   - Based on Selenium  
   - Works with ChromeDriver(meaning it works with chromium/chrome browsers)  
   - Requires Java 1.8.0  
   - Linux and windows support.  
    
## What can this program do:
   * Can automatically login user and choose the world using a properties file.  
   * Can automatically upgrade your buildings 
        - Required have enough resources
        - You must already have constructed the building
        - The building choose will be the fastest to upgrade
   * Can farm barbaric villages.  
        - Require barbaric town coordinates.  
        - Require 20 spear men for each attack and optionally a knight
   * Automatically collect the resource deposit missions
## How to launch :
  * Create a `config.properties` file into `src\main\resources\config.properties` with the following properties.
    * `tw2.user=<YOUR_USERNAME>`
    * `tw2.password=<YOUR_PASSWORD>`
    * `tw2.url=<TRIBAL_WARS_2_URL>`
    * `tw2.world=<WORLD_NAME>`
  * Define into `RuleAttackBarbaric.java` the list of barbaric villages you want to attack
  * Run the Main class
      
