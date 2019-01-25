package com.ECFW.genericClass;

import java.io.File;  
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotHandling implements AutoConstant
{
	public static String getScreenShot(WebDriver driver,String name)
	{
		Date d=new Date();
		SimpleDateFormat f=new SimpleDateFormat(" dd_MM_yyyy  hh-mm-ss");
		String str = f.format(d);
		TakesScreenshot shot=(TakesScreenshot)driver;
		File src=shot.getScreenshotAs(OutputType.FILE);
		//String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis();
		String path = System.getProperty("user.dir")+"/screenshot/"+name+str+".png";
		File dest=new File(path);
		try 
		{
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		return path;
		
	}
}
