package com.itm.ucompiler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import org.springframework.web.util.WebUtils;

/*Class to generate captcha
 *Generate a CAPTCHA String consisting of random lowercase & uppercase letters, and numbers.*/
public class UgenerateCaptchaTests {

	public static String generateCaptchaString() {
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

	public static void main(String[] args) {
		String captcha = generateCaptchaString();
		System.out.println(captcha);
		
	}
}
