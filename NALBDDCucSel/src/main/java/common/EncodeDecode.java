package common;

import java.util.Base64;

public class EncodeDecode {

	public static String encodeStringPassword(String original) {
		String encoded = Base64.getEncoder().encodeToString(original.getBytes());
		return encoded;
	}
	
	public static String decodeStringPassword(String encoded) {
		byte[] decodedBytes = Base64.getDecoder().decode(encoded);
		String decodedString = new String(decodedBytes);
		
		return decodedString;
	}
}
