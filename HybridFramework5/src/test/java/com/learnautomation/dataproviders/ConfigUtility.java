package com.learnautomation.dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility 
{
	static Properties pro;

	
	public static String getProperty(String key)
	{	
			createInstance();
			return pro.getProperty(key);
	}

	
	
	public static Properties createInstance()
	{
	
		if(pro==null)
		{
		
		System.out.println("**** Property is null- loading property file ****");	
			
		pro=new Properties();
		
		try 
		{
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Configuration/Config.property")));
		} catch (FileNotFoundException e) 
		{

			System.out.println("File not found "+e.getMessage());
			
		} catch (IOException e) 
		{
			System.out.println("Could not read file "+e.getMessage());

		}
		
		return pro;
		
		}
		else
		{
			System.out.println("**** Using existing property object ****");	
			return pro;
		}
		
		
		
	}
	
	
	
}
