package demoPkg;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdefAddGifts{
	
	WebDriver driver;
	
@Given("user login website")
public void user_login_website() {
   
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.get("https://demowebshop.tricentis.com/");
	driver.findElement(By.xpath("//*[text()='Log in']")).click();
	driver.findElement(By.id("Email")).sendKeys("he!!o@email.com");
	driver.findElement(By.id("Password")).sendKeys("pa123456");
	driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
}

@When("Navigate to gift cards")
public void navigate_to_gift_cards() {
	
	driver.findElement(By.xpath("(//a[contains(text(),'Gift Cards')])[1]")).click();
}

@When("click on any gift card")
public void click_on_any_gift_card() {
  
	driver.findElement(By.xpath(" (//a[@href='/5-virtual-gift-card'])[2]")).click();
	
}

@When("Type the details in Recipients Name, Recipients Email and Message")
public void type_the_details_in_recipients_name_recipients_email_and_message() {
   
	driver.findElement(By.xpath("//*[@id='giftcard_1_RecipientName']")).sendKeys("friend1");
	driver.findElement(By.xpath("//*[@id='giftcard_1_RecipientEmail']")).sendKeys("friend1@email.com");
	driver.findElement(By.xpath("//*[@id='giftcard_1_Message']")).sendKeys("happy");

	//driver.findElement(By.xpath("//*[@class='button-1 add-to-cart-button']")).click();
	
}

@When("click email a friend")
public void click_email_a_friend() {
	driver.findElement(By.xpath("//*[@class='button-2 email-a-friend-button']")).click();
	driver.findElement(By.xpath("//*[@name='FriendEmail']")).sendKeys("friend1@email.com");
    
}


@Then("click on send email")
public void click_on_send_email() {
	driver.findElement(By.xpath("//*[@name='send-email']")).click();
}

	
@Then("Mouse hover on Computers")
public void mouse_hover_on_computers() {

Actions a = new Actions(driver);
a.moveToElement(driver.findElement(By.xpath("(//a[@href='/computers'])[1]")));
a.click().build().perform();

}

@Then("Select Desktops and Sort by Name : A to Z")
public void select_desktops_and_sort_by_name_a_to_z() {
	
	driver.findElement(By.xpath("(//a[@href='/desktops'])[4]")).click();
	Select drpdown = new Select(driver.findElement(By.name("products-orderby")));
	drpdown.selectByVisibleText("Name: A to Z");
   
}

@Then("Click on any product")
public void click_on_any_product() {
	
	driver.findElement(By.xpath("(//a[@href='/build-your-cheap-own-computer'])[2]")).click();
 
}

@Then("Add to compare list and  log out")
public void add_to_compare_list_and_log_out() {
	
	driver.findElement(By.xpath("//*[@value='Add to compare list']")).click();
	driver.findElement(By.xpath("//*[text()='Log out']")).click();
	
	driver.close();
	System.out.println("Browser Closed ");
    
}
}

