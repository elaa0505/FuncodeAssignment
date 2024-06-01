package com.elaa.fancode.common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utility {
	public static void EvidenceFileCreator(String filename, String requestBody, String ResponseBody, int StatusCode)
			throws IOException {

		File NewText = new File("/home/elango/TestFramework/fancode/" + filename + ".txt");
		System.out.println("New Blank File Created : " + NewText.getName());

		FileWriter Data = new FileWriter(NewText);

		Data.write("Request Body is :\n" + requestBody + "\n\n");
		Data.write("Status Code is :\n" + StatusCode + "\n\n");
		Data.write("Response Body is :\n" + ResponseBody);

		Data.close();
		System.out.println("Data Written into the file : " + NewText.getName());
	}
}
