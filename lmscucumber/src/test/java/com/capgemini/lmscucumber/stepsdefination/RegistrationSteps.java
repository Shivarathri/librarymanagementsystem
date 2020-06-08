package com.capgemini.lmscucumber.stepsdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationSteps {

	WebDriver driver;

	@Given("^User is on Registration page$")
	public void user_is_on_Registration_page() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://localhost:4200/register");
		Thread.sleep(3000);
	}

	@When("^User enters  \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",(\\d+),\"]([^er5\"]*)\"$")
	public void user_enters(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(arg1);
		driver.findElement(By.id("email")).sendKeys(arg2);
		driver.findElement(By.id("password")).sendKeys(arg3);
		driver.findElement(By.id("mobile")).sendKeys(arg4);
		WebElement element = driver.findElement(By.id("role"));
		Select s = new Select(element);
		s.selectByVisibleText(arg5);
	}

	@Then("^User should be \"([^\"]*)\"$")
	public void user_should_be(String arg1) throws Throwable {

		driver.findElement(By.xpath("//button[@class='btn btn-outline-dark float-right']")).click();

	}

}
