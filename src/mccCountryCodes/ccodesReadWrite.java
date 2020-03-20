package mccCountryCodes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;



public class ccodesReadWrite {
	private static String json_location = "/Users/murerintwiga/Documents/workspace/mccCountryCodes/outputfiles/countrycodes.json";
	private static Gson gson = new Gson();
	
	// Save to file Utility
		public void WriteToFile(String myData) {
			File ccodeFile = new File(json_location);
			if (!ccodeFile.exists()) {
				try {
					File directory = new File(ccodeFile.getParent());
					if (!directory.exists()) {
						directory.mkdirs();
					}
					ccodeFile.createNewFile();
				} catch (IOException e) {
					log("Excepton Occured: " + e.toString());
				}
			}
	 
			try {
				// Convenience class for writing character files
				FileWriter ccWriter;
				ccWriter = new FileWriter(ccodeFile.getAbsoluteFile(), true);
	 
				// Writes text to a character-output stream
				BufferedWriter bufferWriter = new BufferedWriter(ccWriter);
				bufferWriter.write(myData.toString());
				bufferWriter.close();
	 
				log("Telco data saved at file location: " + json_location + " Data: " + myData + "\n");
			} catch (IOException e) {
				log("Error Saving Data " + e.toString());
			}
		}
	 
		// Read From File Utility
		public static void ReadFromFile() {
			File ccFile = new File(json_location);
			if (!ccFile.exists()){
				log("File doesn't exist");
				ccodeScraper ccs = new ccodeScraper();
				ccs.Scrape();
			}
	 
			InputStreamReader isReader;
			try {
				isReader = new InputStreamReader(new FileInputStream(ccFile), "UTF-8");
	 
				JsonReader myReader = new JsonReader(isReader);
				countryCodes cc = gson.fromJson(myReader, null);
	 
				log("Telco Name: " + cc.getTelco());
				log("Country Code: " + cc.getCountryCode());
	 
			} catch (Exception e) {
				log("error load cache from file " + e.toString());
			}
	 
			log("\nTelco loaded successfully from file " + json_location);
	 
		}
		
		
		private static void log(String string) {
			System.out.println(string);
		}

}
