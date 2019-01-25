package com.ECFW.genericClass;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyfileHandling implements AutoConstant
{
	public  static String getProperty(String key)
	{
		String propertyfilepath=PROPERTY_PATH;
		Properties p=new Properties();
		try 
		{
			FileInputStream file  = new FileInputStream(propertyfilepath);
			p.load(file);
		} 
		catch (Exception e1)
		{
			
			e1.printStackTrace();
		}
		return p.getProperty(key);
}
}
