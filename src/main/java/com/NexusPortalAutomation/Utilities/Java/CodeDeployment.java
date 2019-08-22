package com.NexusPortalAutomation.Utilities.Java;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;


public class CodeDeployment {
	String installationpath_api = "F:\\CogsdaleWorkSpace\\BitBucket\\nexus_api\\";
	String codesource_api = "F:\\CogsdaleWorkSpace\\BitBucket\\nexus_api\\";
	String codesource_view ="F:\\CogsdaleWorkSpace\\BitBucket\\nexus_view\\";
	String installationpath_view ="F:\\CogsdaleWorkSpace\\BitBucket\\nexus_view\\";
	String configPathapi = "D:\\vmshare\\this.ConfigFiles\\api\\";
	String configPathview = "D:\\vmshare\\this.ConfigFiles\\view\\";


	@Test(priority = 1)
	public void CopyConfigApi() throws IOException {
		File from = new File(configPathapi);
		File to = new File(installationpath_api);
		
		File files = new File(installationpath_api);
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        }
		FileUtils.copyDirectory(from,to);
		
	}
	
	@Test(priority = 2)
	public void CopyConfigView() throws IOException {
		File from = new File(configPathview);
		File to = new File(installationpath_view);
		
		File files = new File(installationpath_view);
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Multiple directories are created!");
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        }
		FileUtils.copyDirectory(from,to);
		
	}

//	public static void delete(File file) throws IOException {
//
//		if (file.isDirectory()) {
//
//			// directory is empty, then delete it
//			if (file.list().length == 0) {
//
//				file.delete();
////            System.out.println("Directory is deleted : "+ file.getAbsolutePath());
//
//			} else {
//
//				// list all the directory contents
//				String files[] = file.list();
//
//				for (String temp : files) {
//					// construct the file structure
//					File fileDelete = new File(file, temp);
//
//					// recursive delete
//					delete(fileDelete);
//				}
//
//				// check the directory again, if empty then delete it
//				if (file.list().length == 0) {
//					file.delete();
////                System.out.println("Directory is deleted : " + file.getAbsolutePath());
//				}
//			}
//
//		} else {
//			// if file, then delete it
//			file.delete();
////        System.out.println("File is deleted : " + file.getAbsolutePath());
//		}
//	}
//	public void DeleteCode() throws IOException, InterruptedException {
//
//		File file = new File(installationpath);
//		delete(file);
//		Thread.sleep(5000);
//
//	}

//	public void CopyCodeapi() throws IOException {
//		File from = new File(codesource_api);
//		File to = new File(installationpath);
//		
//		File files = new File(installationpath);
//        if (!files.exists()) {
//            if (files.mkdirs()) {
//                System.out.println("Multiple directories are created!");
//            } else {
//                System.out.println("Failed to create multiple directories!");
//            }
//        }
//		FileUtils.copyDirectory(from,to);
//		
	
//	}
	
//	
//	public void CopyCodeView() throws IOException {
//		File from = new File(codesource_view);
//		File to = new File(installationpath);
//		
//		File files = new File(installationpath);
//        if (!files.exists()) {
//            if (files.mkdirs()) {
//                System.out.println("Multiple directories are created!");
//            } else {
//                System.out.println("Failed to create multiple directories!");
//            }
//        }
//		FileUtils.copyDirectory(from,to);
//		
//	}

}
