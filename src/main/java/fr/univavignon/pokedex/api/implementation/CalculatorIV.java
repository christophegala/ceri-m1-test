package fr.univavignon.pokedex.api.implementation;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculateurIV {
	private static final String url = "https://pokeassistant.com/main/ivcalculator?locale=en";

	public double getIv(String name, int cp, int hp, int dust)
	{
	    ChromeDriverManager.getInstance().setup();
		WebDriver driver = new ChromeDriver();
	    driver.get(url);
	    driver.findElement(By.xpath("//*[@id=\"search_pokemon_name\"]")).sendKeys(name);
	    driver.findElement(By.xpath("//*[@id=\"search_cp\"]")).sendKeys(String.valueOf(cp));
	    driver.findElement(By.xpath("//*[@id=\"search_hp\"]")).sendKeys(String.valueOf(hp));
	    driver.findElement(By.xpath("//*[@id=\"search_dust\"]")).sendKeys(String.valueOf(dust));
	    driver.findElement(By.xpath("//*[@id=\"calculatebtn\"]")).click();
	      
	    while(driver.findElement(By.xpath("//*[@id=\"possibleCombinationsStringmax\"]//b")) == null);
	    String result = driver.findElement(By.xpath("//*[@id=\"possibleCombinationsStringmax\"]//b")).getText();
	    driver.quit();
	    return Float.parseFloat(result.replace("%", ""));
	}
}