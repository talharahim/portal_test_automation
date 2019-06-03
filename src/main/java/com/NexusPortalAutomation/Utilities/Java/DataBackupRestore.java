package com.NexusPortalAutomation.Utilities.Java;

import java.io.IOException;

import org.testng.annotations.Test;

public class DataBackupRestore {

	@Test
	public void BackupCommand()
	{
		
		 try {
			 Runtime.getRuntime().gc();
			 String[] strCmd = {"cmd /c sqlcmd -m 11 -S SERVER -d DB -U USER -P PASS -r0 -i \"SCRIPT.sql\" 2> \"ERRORS.log\" 1> NULL"};
			 Process proc = Runtime.getRuntime().exec(strCmd);
			 proc.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
