package hr.tvz.foodie.core.util;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
    
	public static String hashPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String hash = DatatypeConverter.printHexBinary( 
		           MessageDigest.getInstance("MD5").digest(password.getBytes("UTF-8")));
		return hash;
	}
	
}