package removeDuplicates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {
	private final static Logger logger = LoggerFactory.getLogger(StringUtil.class);

	/**
	 * this is an O(n^2) algorithm which removes all duplicated chars in a string
	 * @param str
	 * @return the result string with duplicated chars removed
	 */
	public static String removeDuplicates(String str) {
		char[] strChars = str.toCharArray();
		if (strChars == null) {
			return null;
		}
		int len = strChars.length;
		if (len < 2) {
			return null;
		}
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (strChars[i] == strChars[j])
					break;
			}
			if (j == tail) {
				strChars[tail] = strChars[i];
				++tail;
			}
		}
		// strChars[tail] = 0;
		logger.debug("tail= " + tail);
		return new String(strChars).substring(0, tail);
	}

	/**
	 * this is an O(n) algorithm which removes all duplicated chars in a string</br>
	 * However, since extra buffer is used, more space is used for this algorithm
	 * can shifting operating be incorporated into this algorithm?
	 * @param str
	 * @return the result string with duplicated chars removed
	 */
	public static String removeDuplicatesExtraBuffer(String str) {
		char[] strChars = str.toCharArray();
		if (strChars == null) {
			return null;
		}
		int len = strChars.length;
		if (len < 2) {
			return null;
		}
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			hit[i] = false;
		}
		hit[strChars[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[strChars[i]]) {
				strChars[tail] = strChars[i];
				++tail;
				hit[strChars[i]] = true;
			}
		}
		// strChars[tail] = 0;
		logger.debug("tail= " + tail);
		return new String(strChars).substring(0, tail);
	}

	/**
	 * 这个方法判断输入的字符串str中有没有重复的字符
	 * 前提：str中的字符只能属于ascii码表
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isUniqueCharsACSII(String str) {
		boolean[] char_set = new boolean[256]; // 建立一个boolean数组char_set对应ascii码表
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) { // 如果str中出现了在char_set已经标记过的字母，表示有重复
				return false;
			}
			char_set[val] = true; // 把str中未标记过的字母在char_set中标记
		}
		return true;
	}

	/**
	 * 这个方法判断输入的字符串str中有没有重复的字符
	 * 前提：str中的字符只能是小写的英文字母
	 * 优点：这个方法非常节省内存，而且运行效率因为是基于位运算，效果应该更高
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isUniqueCharsLowerCaseLetters(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			logger.debug("val= " + val);
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}

}
