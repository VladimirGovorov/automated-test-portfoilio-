package com.portfolio.reports;


	
	import java.io.File;
	import java.io.IOException;

	import org.apache.commons.io.FileUtils;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ExtentManager {
		
		private static ExtentReports extent;
	    private static String reportFileName = "TestAutomaton-Report"+".html";
	    private static String fileSeperator = System.getProperty("file.separator");
	    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
	    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
	    
	    public static ExtentReports getInstance() {
	        if (extent == null)
	            createInstance();
	        return extent;
	    }  
	    //Create an extent report instance
	    public static ExtentReports createInstance() {
	    	File f = new File("./target/screenshots/");
	        try {
				FileUtils.cleanDirectory(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        String fileName = getReportPath(reportFilepath);                          
	      
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	       // htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	       // htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(reportFileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(reportFileName);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        //Set environment details
	        extent.setSystemInfo("OS", "Windows");
	        extent.setSystemInfo("Tool", "RestAssured");
	        extent.setSystemInfo("Developer", "");  
	        return extent;
	    }
	    
	  //Create the report path
	    private static String getReportPath (String path) {
	        File testDirectory = new File(path);
	        if (!testDirectory.exists()) {
	            if (testDirectory.mkdir()) {
	                System.out.println("Directory: " + path + " is created!" );
	                return reportFileLocation;
	            } else {
	                System.out.println("Failed to create directory: " + path);
	                return System.getProperty("user.dir");
	            }
	        } else {
	            System.out.println("Directory already exists: " + path);
	        }
	        return reportFileLocation;
	    }

	}


