package com.itm.ucompiler.util;

import java.util.Random;

/**
 * This class generates captcha
 * 
 * @author Alexis Ortiz
 * @since 2017
 *
 */
public class Captcha {

	public static String captcha() {

		int length = (7 + (Math.abs(new Random().nextInt()) % 3));

		StringBuffer captchaStringBuffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int baseCharNumber = (Math.abs(new Random().nextInt()) % 62);
			int charNumber = 0;
			if (baseCharNumber < 26) {
				charNumber = 65 + baseCharNumber;
			} else if (baseCharNumber < 52) {
				charNumber = 97 + (baseCharNumber - 26);
			} else {
				charNumber = 48 + (baseCharNumber - 52);
			}
			captchaStringBuffer.append((char) charNumber);
		}

		return captchaStringBuffer.toString();
	}
}
