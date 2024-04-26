package com.example;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AppTest 
{
    WebDriver driver;
    XSSFWorkbook workbook;
    String name;

    @BeforeTest
    public void BeforeTest()throws IOException
    {
        driver =new ChromeDriver();
        FileInputStream file=new FileInputStream("C:\\Users\\22it1\\OneDrive\\Desktop\\testing\\cc2\\demo\\src\\main\\java\\com\\datadase.xlsx");
        workbook=new XSSFWorkbook(file);

        XSSFSheet sheetWorkbook=workbook.getSheet("Sheet1");
        name=sheetWorkbook.getRow(1).getCell(1).getStringCellValue();
    }

    @Test
    public void Test1() throws InterruptedException
    {
        driver.get("https://www.barnesandnoble.com/");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\'rhf_header_element\']/nav/div/div[3]/form/div/div[1]/a")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[2]/div/input[1]")).sendKeys(name);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/span/button")).click();
        Thread.sleep(2000);

        String name1 = driver.findElement(By.xpath("//*[@id='searchGrid']/div/section[1]/section[1]/div/div[1]/div[1]/h1/span")).getText();
        if(name1.equals(name))
        {
            System.out.println("Chetan Bhagat name matches");
        }
    }
}
