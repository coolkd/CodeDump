package com.infibeam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinksTest {

	public static void main(String[] args) {
		List<String> urls = getUrls();
		urls.stream().forEach(url -> {
			if (!isUrlWorking(url)) {
				System.err.println(url);
			}
		});
		System.out.println("\nDone");
	}

	private static List<String> getUrls() {
		List<String> urls = new ArrayList<String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File("src/com/infibeam/urls.txt")));
			String line = reader.readLine();
			while (line != null) {
				if (!line.trim().isEmpty()) {
					urls.add(line);
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return urls;
	}

	private static boolean isUrlWorking(String url) {
		boolean available = false;
		try {
			final HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.connect();
			available = 200 == connection.getResponseCode();
		} catch (Exception e) {
			System.err.println("Bad URL: " + url);
		}
		return available;
	}

}
