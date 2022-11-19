package validacoes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class FilaSiteTest {
	
	private WebDriver driver;
	public JavascriptExecutor js;
	
	@BeforeClass
	public static void setDrive() {
		System.setProperty("webdriver.chrome.driver", "SeleniumDrivers/chromedriver.exe");
	}
	 
	@Before
	public void setUp() {
		this.driver = new ChromeDriver();
		this.js = (JavascriptExecutor) this.driver;
	}

	@After
	public void tearDown() {
		this.driver.quit();
	}
	
	
	@Test
	public void openPageTest() {
		driver.get("https://www.fila.com.br/?gclid=EAIaIQobChMIyY2Q2oy5-wIV0uFcCh2H6AubEAAYASAAEgIdU_D_BwE");
	    driver.manage().window().setSize(new Dimension(1050, 700));
	    assertEquals("https://www.fila.com.br/?gclid=EAIaIQobChMIyY2Q2oy5-wIV0uFcCh2H6AubEAAYASAAEgIdU_D_BwE", 
	    		driver.getCurrentUrl());
	}
	
	@Test
	  public void validShoesName() {
	    driver.get("https://www.fila.com.br/");
	    driver.manage().window().setSize(new Dimension(1050, 700));
	    driver.findElement(By.id("downshift-0-input")).click();
	    driver.findElement(By.id("downshift-0-input")).click();
	    driver.findElement(By.id("downshift-0-input")).sendKeys("Fila Float Knit");
	    driver.findElement(By.id("downshift-0-input")).sendKeys(Keys.ENTER);
	    assertEquals("https://www.fila.com.br/fila%20float%20knit?_q=Fila%20Float%20Knit&map=ft", 
	    		driver.getCurrentUrl());
	  }
	
	@Test
	  public void openOutletPage() {
	    driver.get("https://www.fila.com.br/");
	    driver.manage().window().setSize(new Dimension(1050, 700));
	    driver.findElement(By.linkText("Outlet")).click();
	    {
	      WebElement element = driver.findElement(By.cssSelector(".vtex-store-components-3-x-searchIcon"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.cssSelector(".vtex-search-result-3-x-orderByButton"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    assertEquals("https://www.fila.com.br/outlet", 
	    		driver.getCurrentUrl());
	  }
}
