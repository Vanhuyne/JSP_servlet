package security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class Mahoa {
	public static String toSHA1(String string) {
		String salt = "asdfghjkl"; //them do phuc tap cho mat khau
		String result = null;
		
		string += salt;

		try {
			byte[] dataByte = string.getBytes("UTF-8");
			MessageDigest ms = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(ms.digest(dataByte));
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		return result;
	}
//	public static void main(String[] args) {
//		System.out.println(toSHA1("336333"));
//	}
}
