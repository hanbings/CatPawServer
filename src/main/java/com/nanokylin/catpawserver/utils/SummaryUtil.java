package com.nanokylin.catpawserver.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SummaryUtil {
    /**
     * 生成MD2
     *
     * @param string 需要取MD2字符串
     * @return 取出MD2的值
     */
    public String getMD2(String string) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("MD2");
            messageDigest.update(btInput);
            byte[] bytes = messageDigest.digest();
            int j = bytes.length;
            char[] value = new char[j * 2];
            int k = 0;
            for (byte byte0 : bytes) {
                value[k++] = hexDigits[byte0 >>> 4 & 0xf];
                value[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(value);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成MD5
     *
     * @param string 需要取MD5字符串
     * @return 取出MD5的值
     */
    public String getMD5(String string) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(btInput);
            byte[] bytes = messageDigest.digest();
            int j = bytes.length;
            char[] value = new char[j * 2];
            int k = 0;
            for (byte byte0 : bytes) {
                value[k++] = hexDigits[byte0 >>> 4 & 0xf];
                value[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(value);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成SHA1
     *
     * @param string 需要取SHA1字符串
     * @return 取出SHA1的值
     */
    public String getSHA1(String string) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(btInput);
            byte[] bytes = messageDigest.digest();
            int j = bytes.length;
            char[] value = new char[j * 2];
            int k = 0;
            for (byte byte0 : bytes) {
                value[k++] = hexDigits[byte0 >>> 4 & 0xf];
                value[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(value);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成SHA256
     *
     * @param string 需要取SHA256字符串
     * @return 取出SHA256的值
     */
    public String getSHA256(String string) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(btInput);
            byte[] bytes = messageDigest.digest();
            int j = bytes.length;
            char[] value = new char[j * 2];
            int k = 0;
            for (byte byte0 : bytes) {
                value[k++] = hexDigits[byte0 >>> 4 & 0xf];
                value[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(value);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成SHA384
     *
     * @param string 需要取SHA384字符串
     * @return 取出SHA384的值
     */
    public String getSHA384(String string) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-384");
            messageDigest.update(btInput);
            byte[] bytes = messageDigest.digest();
            int j = bytes.length;
            char[] value = new char[j * 2];
            int k = 0;
            for (byte byte0 : bytes) {
                value[k++] = hexDigits[byte0 >>> 4 & 0xf];
                value[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(value);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成SHA512
     *
     * @param string 需要取SHA512字符串
     * @return 取出SHA512的值
     */
    public String getSHA512(String string) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(btInput);
            byte[] bytes = messageDigest.digest();
            int j = bytes.length;
            char[] value = new char[j * 2];
            int k = 0;
            for (byte byte0 : bytes) {
                value[k++] = hexDigits[byte0 >>> 4 & 0xf];
                value[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(value);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
