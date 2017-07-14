package hr.tvz.foodie.core.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class ImageUtil {

	public static String getImageBase64(byte[] image) {
		byte[] encodeBase64 = Base64.getEncoder().encode(image);

		String base64Encoded = null;

		try {
			base64Encoded = new String(encodeBase64, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return base64Encoded;
	}

}
