package com.batch;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("fileWriter")
public class CsvFileWriter {
	
	//Delimiter used in CSV file
		private static final String COMMA_DELIMITER = ",";
		private static final String NEW_LINE_SEPARATOR = "\n";
		
		//CSV file header
		private static final String FILE_HEADER = "mNumber,userId,mTime,beaconId";
		private static final Log log = LogFactory.getLog(CsvFileWriter.class);
		public void writeCsvFile(List<LocationList> result) {
			
			FileWriter fileWriter = null;
					
			try {
				String fileName = System.getProperty("user.home")+"/sample.csv";
				fileWriter = new FileWriter(fileName);

				//Write the CSV file header
				fileWriter.append(FILE_HEADER.toString());
				
				//Add a new line separator after the header
				fileWriter.append(NEW_LINE_SEPARATOR);
				
				
				for (LocationList location : result) {
					log.info(location.toString());
					fileWriter.append(String.valueOf(location.getmNumber()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(location.getUserId());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(location.getmTime());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(location.beaconId);
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
		
			} catch (Exception e) {
				log.info("Error in CsvFileWriter !!!");
				e.printStackTrace();
			} finally {
				
				try {
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e) {
					log.info("Error while flushing/closing fileWriter !!!");
	                e.printStackTrace();
				}
				
			}
		}
	}

