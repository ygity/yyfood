/*
package yyy.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class StrUtils {

	public static final String VALIDATE_CODE = "validateCode";
	
	public static boolean strIsEmpty(String info) {
		if(info == null || info.equals("")) {
			return true;
			
		} else {
			return false;
		}
	}
	public static final String Long_User = "loginuser";
	public static String createOrderNum() {
		
		String uuid =UUID.randomUUID().toString().replace("_", "");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestr = sdf.format(new Date());
		return uuid + timestr;
	}
}
	
*/
