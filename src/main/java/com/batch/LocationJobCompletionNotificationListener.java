package com.batch;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component
public class LocationJobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Log log = LogFactory.getLog(LocationJobCompletionNotificationListener.class);

	private final JdbcTemplate jdbcTemplate;
	
	/*@Autowired
	@Qualifier("fileWrite")
	FlatFileItemWriter<LocationList> fileWrite;*/
	@Autowired
	@Qualifier("fileWriter")
	CsvFileWriter writer;
	
	@Autowired
	public LocationJobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution ) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

			List<LocationList> results = jdbcTemplate.query("SELECT mNumber, userId,mTime,beaconId FROM LocationList", new RowMapper<LocationList>() {
				@Override
				public LocationList mapRow(ResultSet rs, int row) throws SQLException {
					return new LocationList(Integer.parseInt(rs.getString(1)), rs.getString(2),rs.getString(3),rs.getString(4));
				}
			});
		
			writer.writeCsvFile(results);
		
			for (LocationList person : results) {
				
				log.info("Found <" + person + "> in the database.");
			}
			
			

		}
	}
}