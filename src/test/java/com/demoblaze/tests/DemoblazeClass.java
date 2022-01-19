package com.demoblaze.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoblazeClass {

	public static WebDriver demoblaze;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		demoblaze = new ChromeDriver();
	}

	@AfterMethod
	public void tearDown() {
		demoblaze.quit();
	}

	@Test(priority = 1)
	public void openPage() {
		demoblaze.manage().window().maximize();
		demoblaze.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		demoblaze.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		demoblaze.manage().deleteAllCookies();
		demoblaze.get("https://www.demoblaze.com/");
		Assert.assertEquals(demoblaze.getTitle(), "STORE");

	}

	@Test(priority = 2)
	public void sign_up() throws InterruptedException {

		demoblaze.manage().window().maximize();
		demoblaze.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		demoblaze.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		demoblaze.manage().deleteAllCookies();
		demoblaze.get("https://www.demoblaze.com/");
		demoblaze.findElement(By.xpath("//a[text()='Sign up']")).click();
		demoblaze.findElement(By.xpath("//input[@id='sign-username']")).sendKeys("Arsen Amiryan");
		demoblaze.findElement(By.xpath("//input[@id='sign-password']")).sendKeys("123456");
		demoblaze.findElement(By.xpath("//button[text()='Sign up']")).click();
		// demoblaze.switchTo().alert().accept();
		Thread.sleep(3000);
		//WebDriverWait w = new WebDriverWait(demoblaze,4);
		demoblaze.switchTo().alert().accept();
		Assert.assertTrue(demoblaze.findElement(By.xpath("//a[text()='CATEGORIES']")).isDisplayed());
	}

	@Test(priority = 3)
	public void log_in() throws InterruptedException {

		demoblaze.manage().window().maximize();
		demoblaze.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		demoblaze.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		demoblaze.manage().deleteAllCookies();
		demoblaze.get("https://www.demoblaze.com/");
		demoblaze.findElement(By.xpath("//a[text()='Log in']")).click();
		demoblaze.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("Arsen Amiryan");
		demoblaze.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("123456");
		demoblaze.findElement(By.xpath("//button[text()='Log in']")).click();
		//Thread.sleep(3000);
		WebDriverWait w = new WebDriverWait(demoblaze,3);
		Assert.assertTrue(demoblaze.findElement(By.xpath("//a[contains(text(),'Welcome')]")).isDisplayed());
	}

	@Test(priority = 4)
	public void enter_homepage() throws InterruptedException {

		demoblaze.manage().window().maximize();
		demoblaze.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		demoblaze.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		demoblaze.manage().deleteAllCookies();
		demoblaze.get("https://www.demoblaze.com/");
		demoblaze.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a")).click();
		// Thread.sleep(7000);
		Assert.assertTrue(demoblaze.findElement(By.xpath("//a[text()='CATEGORIES']")).isDisplayed());
	}

	@Test(priority = 5)
	public void send_contacts() throws InterruptedException {

		demoblaze.manage().window().maximize();
		demoblaze.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		demoblaze.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		demoblaze.manage().deleteAllCookies();
		demoblaze.get("https://www.demoblaze.com/");
		demoblaze.findElement(By.xpath("//a[text()='Contact']")).click();
		demoblaze.findElement(By.xpath("//input[@id='recipient-email']")).sendKeys("ars@mail.ru");
		demoblaze.findElement(By.xpath("//input[@id='recipient-name']")).sendKeys("Arsen Amiryan");
		demoblaze.findElement(By.xpath("//textarea[@id='message-text']")).sendKeys(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. "
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, "
				+ "when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
		demoblaze.findElement(By.xpath("//button[text()='Send message']")).click();
		demoblaze.switchTo().alert().accept();
		Assert.assertTrue(demoblaze.findElement(By.xpath("//a[text()='CATEGORIES']")).isDisplayed());
	}

	@Test(priority = 6)
	public void using_About_us() throws InterruptedException {

		demoblaze.manage().window().maximize();
		demoblaze.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		demoblaze.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		demoblaze.manage().deleteAllCookies();
		demoblaze.get("https://www.demoblaze.com/");
		demoblaze.findElement(By.xpath("//a[text()='About us']")).click();
		demoblaze.findElement(By.xpath("//*[@id='videoModal']/div/div/div[3]/button")).click();
		Assert.assertTrue(demoblaze.findElement(By.xpath("//a[text()='CATEGORIES']")).isDisplayed());
	}

	@Test(priority = 7)
	public void enter_Cart() throws InterruptedException {

		demoblaze.manage().window().maximize();
		demoblaze.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		demoblaze.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		demoblaze.manage().deleteAllCookies();
		demoblaze.get("https://www.demoblaze.com/");
		demoblaze.findElement(By.xpath("//a[text()='Cart']")).click();
		// Thread.sleep(3000);
		Assert.assertTrue(demoblaze.findElement(By.xpath("//h2[text()='Products']")).isDisplayed());
	}

	@Test(priority = 8)
	public void add_item_to_Cart() throws InterruptedException {

		demoblaze.manage().window().maximize();
		demoblaze.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		demoblaze.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		demoblaze.manage().deleteAllCookies();
		demoblaze.get("https://www.demoblaze.com/");
		demoblaze.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();
		demoblaze.findElement(By.xpath("//a[text()='Add to cart']")).click();
		demoblaze.findElement(By.xpath("//a[text()='Cart']")).click();
		//Thread.sleep(2000);
		WebDriverWait w = new WebDriverWait(demoblaze,3);
		Assert.assertTrue(demoblaze.findElement(By.xpath("//*[@id='tbodyid']/tr/td[2]")).isDisplayed());
	}

	@Test(priority = 9)
	public void delete_item_from_Cart() throws InterruptedException {
		demoblaze.manage().window().maximize();
		demoblaze.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		demoblaze.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		demoblaze.manage().deleteAllCookies();
		demoblaze.get("https://www.demoblaze.com/");
		demoblaze.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();
		demoblaze.findElement(By.xpath("//a[text()='Add to cart']")).click();
		demoblaze.findElement(By.xpath("//a[text()='Cart']")).click();
		WebDriverWait w = new WebDriverWait(demoblaze,3);
		demoblaze.findElement(By.xpath("//a[text()='Delete']")).click();
		Assert.assertTrue(demoblaze.findElement(By.xpath("//th[text()='Title']")).isDisplayed());
	}

	@Test(priority = 10)
	public void order_item() throws InterruptedException {
		demoblaze.manage().window().maximize();
		demoblaze.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		demoblaze.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		demoblaze.manage().deleteAllCookies();
		demoblaze.get("https://www.demoblaze.com/");
		demoblaze.findElement(By.xpath("//a[text()='Cart']")).click();
		demoblaze.findElement(By.xpath("//button[text()='Place Order']")).click();
		demoblaze.findElement(By.xpath("//input[@id='name']")).sendKeys("Arsen Amiryan");
		demoblaze.findElement(By.xpath("//input[@id='country']")).sendKeys("Armenia");
		demoblaze.findElement(By.xpath("//input[@id='city']")).sendKeys("Yerevan");
		demoblaze.findElement(By.xpath("//input[@id='card']")).sendKeys("123456");
		demoblaze.findElement(By.xpath("//input[@id='month']")).sendKeys("month");
		demoblaze.findElement(By.xpath("//input[@id='year']")).sendKeys("year");
		demoblaze.findElement(By.xpath("//button[text()='Purchase']")).click();
		Assert.assertTrue(demoblaze.findElement(By.xpath("//html/body/div[10]")).isDisplayed());
	}

}
