package com.learnautomation.unittests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.dataproviders.ConfigUtility;

public class UniTest002_ConfigTest {

	@Test
	public void loadConfig()
	{
		Assert.assertTrue(ConfigUtility.getProperty("Browser")!=null);
	}
	
}
