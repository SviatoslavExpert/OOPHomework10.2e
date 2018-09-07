package com.gmail.s.granovskiy;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		Map<String, String> hm = new HashMap<>();
		Translation object = new Translation();
		
		object.addWordsToDictionary(hm);
		object.translateTheText(hm, object.loadTextAndSplit());
		
	}
}
