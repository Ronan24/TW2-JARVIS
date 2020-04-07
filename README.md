# TW2-JARVIS

This project, based on this [setup](https://github.com/spectral369/TW2-Bot) create a bot to play at [Tribal Wars 2](https://us.tribalwars2.com/#/).

## Program Details:  
   - Based on Selenium  
   - Works with ChromeDriver(meaning it works with chromium/chrome browsers)  
   - Requires Java 1.8.0  
   - Linux and windows support.  
    
## What can this program do:
   * Can autolog users and chose the select world.  
   * Can automaticaly upgrade the resource buildings if you have enough resources
   * Can farm barbaric villages.  
        - Require barbaric town coordonates.  
        - Require 20 spearmen for each attack
        - Optional you can have farm cycles 
## How to launch :
  * Create a `config.properties` file into `src\main\resources\config.properties` with the following properties.
    * `tw2.user=<YOUR_USERNAME>`
    * `tw2.password=<YOUR_PASSWORD>`
    * `tw2.url=<TRIBAL_WARS_2_URL>`
    * `tw2.world=<WORLD_NAME>`
  * Define into `RuleAttackBarbaric.java` the list of barbaric villages you want to attack
  * Run the Main class
      
