package com.mvn.ShopifyTask;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sShopifyInvoke {

	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver",
		// "D:/chromedriver/chomedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		/*
		 * driver.get("https://www.shopify.com/in"); System.out.println("Title: " +
		 * driver.getTitle()); driver.manage().window().maximize(); Thread.sleep(3000);
		 * 
		 * // click on Star free trial button WebElement StarttrialButton =
		 * driver.findElement(By.linkText("Start free trial"));
		 * StarttrialButton.click(); System.out.println("StarttrialButton Clicked");
		 * System.out.println("Current Url Before press :" + driver.getCurrentUrl());
		 * Thread.sleep(3000); driver.navigate().back();
		 * System.out.println("Current Url After back press :" +
		 * driver.getCurrentUrl());
		 * 
		 * //driver.quit();
		 * 
		 * 
		 * // click on login 
		 * WebElement link = driver.findElement(By.xpath("//a[@data-component-name='login']"));
		 * link.click(); System.out.println("Link Clicked"); Thread.sleep(3000);
		 * driver.quit();
		 * 
		 */

		try {
			// Step 1: Open Shopify website
			driver.get("https://www.shopify.com/");
			driver.manage().window().maximize();
			System.out.println("Opened Shopify website.");

			// Step 2: Start free trial
			WebElement startTrialButton = driver.findElement(By.linkText("Start free trial"));
			startTrialButton.click();
			Thread.sleep(3000);
			driver.navigate().back();
			
			WebElement link = driver.findElement(By.xpath("//a[@data-component-name='login']"));
			 link.click();
			 System.out.println("Linked Clicked"); Thread.sleep(3000);

			// Step 3: Fill in signup details
			WebElement emailField = driver.findElement(By.id("email"));
			emailField.sendKeys("your-email@example.com");

			WebElement passwordField = driver.findElement(By.id("password"));
			passwordField.sendKeys("YourSecurePassword");

			WebElement storeNameField = driver.findElement(By.id("shop-name"));
			storeNameField.sendKeys("MyTestStore123");

			WebElement createStoreButton = driver.findElement(By.cssSelector("button[type='submit']"));
			createStoreButton.click();
			Thread.sleep(5000);

			System.out.println("Store creation process initiated.");

			// Step 4: Login to Shopify
			driver.get("https://accounts.shopify.com/login");
			WebElement loginEmail = driver.findElement(By.id("account_email"));
			loginEmail.sendKeys("your-email@example.com");
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			Thread.sleep(3000);

			// Step 5: Add a product
			driver.get("https://your-store.myshopify.com/admin/products");
			WebElement addProductButton = driver.findElement(By.linkText("Add product"));
			addProductButton.click();
			Thread.sleep(3000);

			WebElement productNameField = driver.findElement(By.name("title"));
			productNameField.sendKeys("Test Product");

			WebElement productPriceField = driver.findElement(By.name("price"));
			productPriceField.sendKeys("19.99");

			WebElement saveButton = driver.findElement(By.cssSelector("button[type='submit']"));
			saveButton.click();
			Thread.sleep(5000);

			System.out.println("Product added successfully.");

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		} finally {
			// Close the browser
			//driver.quit();
		}
	}
}
