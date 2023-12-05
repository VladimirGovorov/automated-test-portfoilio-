package com.portfolio.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	static Date date = new Date() ;
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	static SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String testName;

	public static String captureScreen(WebDriver driver, String title) {
		String path;
		try {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			path = System.getProperty("user.dir")+"/target/screenshots/"+dateFormat2.format(date)+"/"+testName+"/"+ title+"_"+dateFormat.format(date)+"_"+ source.getName();
			FileUtils.copyFile(source, new File(path)); 
			Thread.sleep(1000);
		}
		catch(Exception e) {
			path = "Failed to capture screenshot: " + e.getMessage();
		}
		return path;
	}
	public static void cleanFolder(String testName){
        try {
            File f = new File("./target/screenshots/"+dateFormat2.format(date)+"/"+testName+"/");
            FileUtils.cleanDirectory(f); //clean out directory (this is optional -- but good know)
            FileUtils.forceDelete(f); //delete directory
            FileUtils.forceMkdir(f); //create directory
            System.out.println("Cleaned folder location...>>>"+f);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Location does not exist...>>>");
        } 
    }
}
