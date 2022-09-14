package com.monster.learn;

import java.util.ArrayList;

//30.54%
public class Codec535 {
			private ArrayList<String> mDatabase = new ArrayList<>();
	    // Encodes a URL to a shortened URL.
			public String encode(String longUrl) {
				if (mDatabase.contains(longUrl)) {
					return "http://tinyurl.com/" + mDatabase.indexOf(longUrl);
				}
				mDatabase.add(longUrl);
				return "http://tinyurl.com/" + (mDatabase.size() - 1);
			}
	
			// Decodes a shortened URL to its original URL.
			public String decode(String shortUrl) {
					String index = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);	
					return mDatabase.get(Integer.parseInt(index));
			}
}
