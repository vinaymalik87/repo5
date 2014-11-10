package com.company.testclasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.company.util.Excel;


public class GroupTest {
	private WebDriver driver;
	Excel excel=new Excel();
	@BeforeMethod
	public void launchBrowser() throws InterruptedException{
		driver=new FirefoxDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/?gfe_rd=cr&ei=WyZbVLfOM-jA8gfMhoGIDg&gws_rd=ssl");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(3000);
}
	@Test
	public void login() throws IOException{
		excel.setExcel("src//test//resources//data//excelmaven.xls","Sheet1");
		String txt=excel.getCellValue(1,1);
		System.out.println(txt);
		driver.findElement(By.xpath("//input[@id='gbqfq']")).sendKeys(txt);
		driver.findElement(By.xpath("//button[@id='gbqfb']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ol[@id='rso']/div[@class='srg']/li[1]//h3/a")).getText().toUpperCase().contains( (excel.getCellValue(1, 1)).toUpperCase() ));
		System.out.println("assert pass");
		
	}
	@AfterTest
	public void tearDown(){
		driver.quit();}}
