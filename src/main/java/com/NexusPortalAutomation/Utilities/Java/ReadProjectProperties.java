package com.NexusPortalAutomation.Utilities.Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * This class will handle reading data from project properties file
 * @author: Talha Rahim
 * @since:04/08/2019
 */
public class ReadProjectProperties {

	public ReadProjectProperties() {
		System.out.println("Reading Project Properties");

	}

	public String ReadFile(String str) {
		String Result = null;
		Properties obj = new Properties();
		File filePath = new File("./Configurations\\Project.properties");
		FileInputStream objfile;
		try {
			objfile = new FileInputStream(filePath);
			obj.load(objfile);
			Result = obj.getProperty(str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Result;
	}

}
