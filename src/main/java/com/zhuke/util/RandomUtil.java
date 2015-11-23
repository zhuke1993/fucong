/**
 * 
 */
package com.zhuke.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author Zhangleilei
 *
 */
public class RandomUtil {
	private RandomUtil() {
		// do nothing.
	}

	private static Random genRandom(boolean useSecureRandom) {
		if (useSecureRandom) {
			return new SecureRandom();
		} else {
			return new Random(System.currentTimeMillis());
		}
	}

	public static String generateFixedLengthPositiveNum(int length,
			boolean useSecureRandom) {

        if (length <= 0) {
            throw new IllegalArgumentException();
        }

		Random random = genRandom(useSecureRandom);
		StringBuilder sBuilder = new StringBuilder();

		do {
			sBuilder.append(String.valueOf(random.nextInt(Integer.MAX_VALUE)));
		} while (sBuilder.length() < length);

		if (sBuilder.length() == length) {
			return sBuilder.toString();
		} else {
			return sBuilder.substring(0, length);
		}
	}
	
	public static String genRandomString(int length, char[] symbols, boolean useSecureRandom) {
		if (length <= 0) {
			throw new IllegalArgumentException();
		}

		Random random = genRandom(useSecureRandom);
		StringBuilder sBuilder = new StringBuilder();
		int symbolsLen = symbols.length;
		
		for(int i=0; i<length; i++) {
			sBuilder.append(symbols[random.nextInt(symbolsLen)]);
		}
		
		return sBuilder.toString();
	}
}
