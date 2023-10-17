package demoPkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdefDEMOWEBlogin {
	
	 WebDriver driver;
	
	 @Given("login the URL {string}")
	 public void login_the_url(String URL) {
		 ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.get(URL);
	 }

	 @Given("click on {string} button")
	 public void click_on_button(String string) {
		 driver.findElement(By.xpath("//*[text()='" + string + "']")).click();
	 }

	
	 
	 
	@Given("user enter details {string} and {string}")
	public void user_enter_details_and(String string1, String string2) {
	    
		driver.findElement(By.id("Email")).sendKeys(string1);
		driver.findElement(By.id("Password")).sendKeys(string2);
	}

	@Given("user click on login button")
	public void user_click_on_login_button() {
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	}

	@Then("I verify the {string} in login screen")
	public void i_verify_the_in_login_screen(String string) {
		

		if(driver.findElement(By.xpath("//*[text()='" + string + "']")).isDisplayed()) {
			
			System.out.println("User" +driver.findElement(By.xpath("//*[text()='" + string + "']")).getText()+ " logged in successfully" );
				
		}
		else
		{
			System.out.println("Not working as expected");
		}
	
		driver.close();
		System.out.println("Browser Closed ");
}
	
	
	

}