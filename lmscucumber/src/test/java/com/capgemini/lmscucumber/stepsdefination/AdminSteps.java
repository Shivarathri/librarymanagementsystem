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

public class AdminSteps {

	WebDriver driver;
	boolean check;

	@Before
	public void openBrowser() throws Exception {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@After
	public void closeBrowser() {

		driver.close();
	}

	@Given("^Admin is on login page$")
	public void admin_is_on_login_page() throws Throwable {

		driver.get("http://localhost:4200/login");

	}

	@When("^Admin gives \"([^\"]*)\", \"([^\"]*)\"$")
	public void admin_gives(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(arg1);
		driver.findElement(By.id("password")).sendKeys(arg2);
		driver.findElement(By.xpath("//button[@class='btn btn-black']")).click();
	}

	@Then("^Admin is logged in$")
	public void admin_is_logged_in() throws Throwable {
		String actual = driver.getTitle();
		String expected = "LmsAngular";
		assertEquals("passed", expected, actual);
	}

	@And("^Click on the Admin$")
	public void click_on_the_admin() throws Throwable {
		driver.findElement(By.id("dropdownMenuButton")).click();
	}

	@Given("^Admin is adding book$")
	public void admin_is_adding_book() throws Throwable {

		driver.findElement(By.linkText("Add Book")).click();
	}

	@When("^Admin enters  \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void admin_enters(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		driver.findElement(By.id("bookName")).sendKeys(arg1);
		driver.findElement(By.id("author")).sendKeys(arg2);
		driver.findElement(By.id("category")).sendKeys(arg3);
		driver.findElement(By.id("publisher")).sendKeys(arg4);

	}

	@Then("^Book should be \"([^\"]*)\"$")
	public void book_should_be(String arg1) throws Throwable {

		driver.findElement(By.xpath("//button[@class='btn btn-outline-primary float-right']")).click();
		String s = arg1;
		boolean b = driver.getPageSource().contains(s);
		if (s.equals(b)) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}

	}

	@Given("^Admin is updating book$")
	public void admin_is_updating_book() throws Throwable {
		driver.findElement(By.linkText("Books Info")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-outline-primary']")).click();

	}

	@When("^Admin enters updated values \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void admin_enters_updated_values(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		driver.findElement(By.id("bookName")).sendKeys(arg1);
		driver.findElement(By.id("author")).sendKeys(arg2);
		driver.findElement(By.id("category")).sendKeys(arg3);
		driver.findElement(By.id("publisher")).sendKeys(arg4);
	}

	@Then("^Book will be \"([^\"]*)\"$")
	public void book_will_be(String arg1) throws Throwable {

		driver.findElement(By.xpath("//button[@class='btn btn-outline-primary float-right']")).click();
		System.out.println(arg1);
	}

	@And("^Admin is deleting book$")
	public void admin_is_deleting_book() throws Throwable {
		driver.findElement(By.xpath("(//button[@class='btn btn-outline-danger'])[1]")).click();
		System.out.println("Record is  Deleted");

		driver.navigate().refresh();
		Thread.sleep(3000);
	}

	@When("^Bid and Uid are given (\\d+), (\\d+)$")
	public void bid_and_Uid_are_given(int arg1, int arg2) throws Throwable {
		/*
		 * bookBean.setbId(arg1); userBean.setuId(arg2);
		 */
		// check = dao.issueBook(arg1, arg2);
	}

	@Then("^Book is issued successfully$")
	public void book_is_issued_successfully() throws Throwable {

		// Assertions.assertTrue(check);
	}

}
