package demoPkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdefDemoWebAddMobile{

	WebDriver driver;

@Given("user login URL")
public void user_login_url() {
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.get("https://demowebshop.tricentis.com/");
}

@Given("user update credentials and click on login")
public void user_update_credentials_and_click_on_login() {
	driver.findElement(By.xpath("//*[text()='Log in']")).click();
	driver.findElement(By.id("Email")).sendKeys("he!!o@email.com");
	driver.findElement(By.id("Password")).sendKeys("pa123456");
	driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	
}

@Given("user click on ELECTRONICS button")
public void user_click_on_electronics_button() {
	
	driver.findElement(By.xpath("(//a[contains(text(),'Electronics')])[1]")).click();
	
}

@Given("user select cell phones link")
public void user_select_cell_phones_link() {
	
	driver.findElement(By.xpath("(//a[@href='/cell-phones'])[4]")).click();
}

@Given("user select Smartphone link")
public void user_select_smartphone_link() {
	
	driver.findElement(By.xpath("(//a[@href='/smartphone'])[4]")).click();
	
	
}

@Given("user click on ADD TO CART button")
public void user_click_on_add_to_cart_button() {
	driver.findElement(By.xpath("//*[@class='button-1 add-to-cart-button']")).click();
}

@Then("verify text msg as Shopping cart in cast")
public void verify_text_msg_as_shopping_cart_in_cast() {
	driver.findElement(By.xpath("(//*[text()='Shopping cart'])[1]")).click();
	
	if(driver.findElement(By.xpath("(//*[text()='Shopping cart'])[2]")).isDisplayed()) {
		System.out.println(driver.findElement(By.xpath("//*[@id='checkout']")).getText() + "is displayed");
		
		
	}
	else {
		System.out.println("not working properly");
		
	}
	
	driver.close();
	System.out.println("Browser Closed");
}
}
