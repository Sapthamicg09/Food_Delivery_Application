package com.myFoodApplication.security;

import com.myFoodApplication.security.secretkey.SecretKey;

public class Security {
	
	public static String encryption(String s) {
		
		String e="";
		for(int i=0;i<s.length();i++) {
			
			e+=(char)(s.charAt(i)+SecretKey.getKey());
			
		}
		
		return e;
		
	}

	
public static String decryption(String s) {
		
		String e="";
		for(int i=0;i<s.length();i++) {
			
			e+=(char)(s.charAt(i)-SecretKey.getKey());
			
		}
		
		return e;
		
	}


}
