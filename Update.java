package assignment.week5.day1;

import java.io.IOException;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testcase.ExcelData;

public class Update extends BaseClass{
	@Test(dataProvider="sendData")
	public void update(String urgencyvalue,String statevalue) throws InterruptedException {
		System.out.println("incidentnumber"+incidentnumber);
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		driver.getTitle();
		driver.switchTo().frame("gsft_main");
	WebElement searchBox = driver.findElement(By.xpath("//span[contains(text(),'Press Enter from within the input to')]/following-sibling::input"));
//	NewIncident obj=new NewIncident();
//	String num=obj.incidentnumber;
	searchBox.sendKeys(incidentnumber,Keys.ENTER);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'INC')]")).click();
	//Update the incidents with Urgency as High and State as In Progress
	WebElement urgency=driver.findElement(By.xpath("//select[@id='incident.urgency']"));
	Select indexdrop=new Select(urgency);
	indexdrop.selectByVisibleText(urgencyvalue);
	WebElement state=driver.findElement(By.xpath("//select[@id='incident.state']"));
	Select inc=new Select(state);
	inc.selectByValue(statevalue);
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("javascript:window.scrollBy(250,350)");
	driver.findElement(By.xpath("(//button[text()='Update'])[2]")).click();
	//verify the priority and state 
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'INC')]")).click();
	String statevalue1=driver.findElement(By.xpath("(//span[text()='Incident state'])[1]/following-sibling::span/span")).getText();
	String priority=driver.findElement(By.xpath("(//span[text()='Priority'])[2]/following-sibling::span/span")).getText();
	if(statevalue.contains(statevalue1) && priority.contains(priority)) {
	System.out.println("Urgency as High and State as In Progress");
	
	}
	else {
		System.out.println("Urgency not High and State nots In Progress");
	}
	}
	@DataProvider
	public String[][] sendData() throws IOException {
	
		return ExcelData.readdata("UpdateIncident");
	
}
}

