package com.wz.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 这是实现 MD5 数据加密的算法
 * 
 * @author TongZhou
 *
 */
public class EncodeByMd5 {
	/**
	 * 
	 * @param str 传入的参数
	 * @return 返回加密后的字符串
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String EncoderByMd5(String string) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = string.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
	}
}