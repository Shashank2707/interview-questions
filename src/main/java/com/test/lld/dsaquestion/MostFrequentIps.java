package com.test.lld.dsaquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of logs with IP addresses in the following format.
 * 
 * lines = ["10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
 * "10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
 * "10.0.0.2 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
 * "10.0.0.2 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
 * "10.0.0.3 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20"]
 * 
 * Return the most frequent IP address from the logs. 
 * The retuned IP address value must be in a string format. 
 * If multiple IP addresses have the count equal to max count, 
 * then return the address as a comma-separated string with IP addresses in sorted order.
 * 
 * Output : 10.0.0.1,10.0.0.2
 */

public class MostFrequentIps {
	
	public static void main(String[] args) {
		List<String> input = Arrays.asList(
				"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
				"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
				"10.0.0.2 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
				"10.0.0.2 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20",
				"10.0.0.3 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20"
				);
		
		System.out.println(mostFrequentIP(input));
	}

	public static String mostFrequentIP(List<String> logs) {
        Map<String, Integer> ipCount = new HashMap<>();
        
        for (String log : logs) {
            String ip = log.split(" ")[0];
            ipCount.put(ip, ipCount.getOrDefault(ip, 0) + 1);
        }
        
        int maxCount = Collections.max(ipCount.values());
        
        List<String> mostFrequentIps = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ipCount.entrySet()) {
            if (entry.getValue() == maxCount) {
                mostFrequentIps.add(entry.getKey());
            }
        }
        
        Collections.sort(mostFrequentIps);
        
        return String.join(",", mostFrequentIps);
    }
}
