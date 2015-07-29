package com.batch;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;

public class LocationItemprocessor implements ItemProcessor<LocationList, LocationList> {
	
	private static final Log log = LogFactory.getLog(LocationItemprocessor.class);
	
	@Override
	public LocationList process(final LocationList locationList) throws Exception {
		final String userId = locationList.getUserId();
		
		String changeTime = locationList.getmTime();
		String[] date = changeTime.split("/");
		
		int change = Integer.parseInt(date[2]);
		String chageDate = Integer.toString((change+3));
		String resultTime= date[0].concat(date[1]).concat(chageDate).concat(date[3]);		
		
        final String mTime = resultTime;
        final String beaconId= locationList.getBeaconId();
        final LocationList transformedLocation = new LocationList(userId, mTime,beaconId);

        log.info("Converting (" + locationList + ") into (" + transformedLocation + ")");

        return transformedLocation;
	}

}
