package demoPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Then;

public class stepdefAddGifts{

	WebDriver driver;	
	
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
