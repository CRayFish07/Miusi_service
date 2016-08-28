package com.miusi.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GeneralUtil {
	/**
	 * �ж��ַ���Ϊ�ջ��߿��ַ���
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0)
			return true;
		else
			return false;
	}

	/**
	 * �ж϶����Ƿ�Ϊ��
	 */
	public static boolean isEmpty(Object object) {
		if (object == null)
			return true;
		else
			return false;
	}
	
	/**
	 * list是否为空
	 */
	public static boolean isListEmpty(List<?> list) {
		if (list == null || list.size() == 0)
			return true;
		return false;
	}
	
	public static long getCurrentTimeAsNumber() {
		String returnStr = null;
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date date = new Date();
		returnStr = f.format(date);
		return new Long(returnStr);
	}
}
