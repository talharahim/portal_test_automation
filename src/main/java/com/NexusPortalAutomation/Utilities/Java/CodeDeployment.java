package com.NexusPortalAutomation.Utilities.Java;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;



public class CodeDeployment {
	String installationpath = "C:\\CSM_API\\API\\CSR_Portal1\\";
	String code_source = "F:\\NexusPortalCode\\csm_api\\";

	@Test(priority = 1)
	public void DeleteCode() throws IOException, InterruptedException {

		File file = new File(installationpath);
		delete(file);
		Thread.sleep(5000);

	}

	@Test(priority = 2)
	public void CopyCode() throws IOException {
		File from = new File(code_source);
		File to = new File(installationpath);
		
		File files = new File(installationpath);
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        }
		FileUtils.copyDirectory(from,to);
		
	}

	public static void delete(File file) throws IOException {

		if (file.isDirectory()) {

			// directory is empty, then delete it
			if (file.list().length == 0) {

				file.delete();
//            System.out.println("Directory is deleted : "+ file.getAbsolutePath());

			} else {

				// list all the directory contents
				String files[] = file.list();

				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);

					// recursive delete
					delete(fileDelete);
				}

				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();
//                System.out.println("Directory is deleted : " + file.getAbsolutePath());
				}
			}

		} else {
			// if file, then delete it
			file.delete();
//        System.out.println("File is deleted : " + file.getAbsolutePath());
		}
	}
}
