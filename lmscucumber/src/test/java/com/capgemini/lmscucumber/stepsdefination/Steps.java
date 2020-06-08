package com.capgemini.lmscucumber.stepsdefination;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	WebDriver driver;

	@Before
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/login");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@After
	public void closeBrowser() {
		driver.close();
	}

	
	@When("^Admin give \"([^\"]*)\", \"([^\"]*)\"$")
	public void admin_give(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(arg1);
		driver.findElement(By.id("password")).sendKeys(arg2);
		driver.findElement(By.xpath("//button[@class='btn btn-black']")).click();
	}

	@Then("^Admin logged in$")
	public void admin_logged_in() throws Throwable {
		String actual = driver.getTitle();
		String expected = "LmsAngular";
		assertEquals("passed", expected, actual);
	}

	@And("^Clicking on the Admin$")
	public void clicking_on_the_admin() throws Throwable {
		driver.findElement(By.id("dropdownMenuButton")).click();
	}

	@Given("^Admin adds book$")
	public void admin_adds_book() throws Throwable {

		driver.findElement(By.linkText("Add Book")).click();
	}

	@When("^Admin enter  \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void admin_enter(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		driver.findElement(By.id("bookName")).sendKeys(arg1);
		driver.findElement(By.id("author")).sendKeys(arg2);
		driver.findElement(By.id("category")).sendKeys(arg3);
		driver.findElement(By.id("publisher")).sendKeys(arg4);

	}

	@Then("^Book \"([^\"]*)\"$")
	public void book(String arg1) throws Throwable {

		driver.findElement(By.xpath("//button[@class='btn btn-outline-primary float-right']")).click();
		String s = arg1;
		boolean b = driver.getPageSource().contains(s);
		if (s.equals(b)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}

	}

	@Then("^Admin should be Logout$")
	public void admin_should_be_Logout() throws Throwable {
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		Thread.sleep(3000);

	}

	@When("^User enters   \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_enters(String arg1, String arg2) throws Throwable {
		driver.navigate().refresh();
		driver.findElement(By.id("email")).sendKeys(arg1);
		driver.findElement(By.id("password")).sendKeys(arg2);

	}

	@Then("^User should be logged in$")
	public void user_should_be_logged_in() throws Throwable {

		driver.findElement(By.xpath("//button[@class='btn btn-black']")).click();

		Thread.sleep(3000);
	}

	@Then("^User click on the Student Dropdown Field$")
	public void user_click_on_the_Student_Dropdown_Field() throws Throwable {
		driver.findElement(By.id("dropdownMenuButton")).click();
		Thread.sleep(3000);

	}

	@Then("^User click on Request book$")
	public void user_click_on_Request_book() throws Throwable {
		driver.findElement(By.xpath("//a[.='Request Book']")).click();

	}

	@Then("^User click on the Request$")
	public void user_click_on_the_Request() throws Throwable {
		driver.findElement(By.xpath("//td[.='JAVA']/following-sibling::td/button[.='Request']")).click();
	}

	@Then("^User should be Logout$")
	public void user_should_be_Logout() throws Throwable {
		driver.findElement(By.xpath("//a[.='Logout']")).click();
	}

	@When("^Admin enter the username \"([^\"]*)\"$")
	public void admin_enter_the_username(String arg1) throws Throwable {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys(arg1);

	}

	@When("^enters the password \"([^\"]*)\"$")
	public void enters_the_password(String arg1) throws Throwable {
		driver.findElement(By.id("password")).sendKeys(arg1);
	}

	@Then("^Admin sholud be in Logged in$")
	public void admin_sholud_be_in_Logged_in() throws Throwable {
		driver.findElement(By.xpath("//button[@class='btn btn-black']")).click();
	}

	@Then("^Admin click on admin dropdown$")
	public void admin_click_on_admin_dropdown() throws Throwable {
		driver.findElement(By.id("dropdownMenuButton")).click();
	}

	@Then("^Admin click on the show request$")
	public void admin_click_on_the_show_request() throws Throwable {
		driver.findElement(By.xpath("//a[.='Show Requests']")).click();
	}

	@Then("^Admin click on the ISSUE$")
	public void admin_click_on_the_ISSUE() throws Throwable {
		String a = "ISSUE";
		if (a.equals("ISSUE")) {
			driver.findElement(By.xpath("//button[.='ISSUE']")).click();
		} else {
			driver.findElement(By.xpath("//button[.='Reject']")).click();
		}
	}

	@Then("^Admin Should be Logged out$")
	public void admin_Should_be_Logged_out() throws Throwable {
		driver.findElement(By.xpath("//a[.='Logout']")).click();
	}

	@When("^User enter the username \"([^\"]*)\"$")
	public void user_enter_the_username(String arg1) throws Throwable {
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@When("^enter the password  \"([^\"]*)\"$")
	public void enter_the_password(String arg1) throws Throwable {
		driver.findElement(By.id("password")).sendKeys(arg1);
	}

	@Then("^User Should be LOgged in$")
	public void user_Should_be_LOgged_in() throws Throwable {
		driver.findElement(By.xpath("//button[@class='btn btn-black']")).click();
	}

	@Then("^User click on the Student$")
	public void user_click_on_the_Student() throws Throwable {
		driver.findElement(By.id("dropdownMenuButton")).click();
		Thread.sleep(3000);
	}

	@Then("^User click on the Return Book$")
	public void user_click_on_the_Return_Book() throws Throwable {
		driver.findElement(By.xpath("//a[.='Return Book']")).click();
		driver.findElement(By.xpath("//td[.='Java']/following-sibling::td/button[.='Return']")).click();
	}

	@Then("^User Should be Log Out$")
	public void user_Should_be_Log_Out() throws Throwable {
		driver.findElement(By.xpath("//a[.='Logout']")).click();
	}

}
