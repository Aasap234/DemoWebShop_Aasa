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
	public class stepdefDemo {
	public WebDriver driver;
		
	@Given("user login the URL {string}")
	public void user_login_the_url(String URL) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(URL);
	}

	@Then("user click on {string} button")
	public void user_click_on_button(String string) {
		driver.findElement(By.xpath("//*[text()='" + string + "']")).click();
	}
	
	@Then("user click on Register button")
	public void user_click_on_Register_button() {
		driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
	}

	@Then("user enter details {string} and {string} and {string} and {string} and {string}")
	public void user_enter_details_and_and_and_pa123456_and(String Firstname, String Lastname, String Email, String Password,String Confirmpassword ) {
	    driver.findElement(By.id("gender-female")).click();
	    driver.findElement(By.id("FirstName")).sendKeys(Firstname);
	    driver.findElement(By.id("LastName")).sendKeys(Lastname);
	    driver.findElement(By.id("Email")).sendKeys(Email);
	    driver.findElement(By.id("Password")).sendKeys(Password);
	    driver.findElement(By.id("ConfirmPassword")).sendKeys(Confirmpassword);
	}
	 

	@Then("verify the confirmation text")
	public void verify_the_confirmation_text() {
		
		if(driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]  ")).isDisplayed()) {
			System.out.println(driver.findElement(By.xpath("//*[@class='result']")).getText()
			);
			
			
		}
		else
		{
			System.out.println("Not working as expected");
		}
		
		driver.close();
		System.out.println("Browser Closed ");
	}		
	
	

}