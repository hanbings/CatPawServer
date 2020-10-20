package com.nanokylin.catpawserver.utils;

import org.apache.commons.lang.ArrayUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 一个文字处理类
 *
 * @author Hanbings
 */
public class TextUtil {
    /**
     * 生成MD5
     *
     * @param s 输入的字符串
     * @return 生成后的MD5
     */
    public String getMD5(String s, int start, int end) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes(StandardCharsets.UTF_8);
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str).substring(start, end);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成时间戳
     *
     * @return 时间戳
     */
    public String getTime() {
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        return sdf.format(cd.getTime());
    }

    /**
     * 转换为Minecraft时间戳
     */
    public String getDateToMinecraftFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        return sdf.format(date);
    }

    /**
     * 拼接理由字段
     *
     * @return 拼接完成的字段
     * @author Hanbings
     */
    public String getStringArrayToString(String[] strings) {
        return ArrayUtils.toString(strings, " ");
    }

    /**
     * 黑名单封禁时间识别处理方法
     * 悠悠真好用
     *
     * @param start    开始的时间
     * @param duration 结束时间
     * @return 标准的date
     * @author Yoooooory
     */
    public Date getCalculatingTime(Date start, String duration) {
        // 时h / 分m / 秒s / 天d / 周w / 月mo / 年y /
        // 1 month = 30 days
        // 1 year = 365 days
        // 1 century = 100 years + 24 days extra
        long time = start.getTime();
        if (!duration.matches("(\\d+(s|h|d|mo|m|y|c))+")) {
            throw new IllegalArgumentException("Cannot solve duration string '" + duration + "'");
        }
        Matcher m = Pattern.compile("(\\d+)(s|h|d|mo|m|y|c)").matcher(duration);
        while (m.find()) {
            long num = Long.parseLong(m.group(1));
            switch (m.group(2)) {
                case "s":
                    time += 1000 * num;
                    break;
                case "m":
                    time += 60000 * num;
                    break;
                case "h":
                    time += 3600000 * num;
                    break;
                case "d":
                    time += 86400000 * num;
                    break;
                case "mo":
                    time += 2592000000L * num;
                    break;
                case "y":
                    time += 31536000000L * num;
                    break;
                case "c":
                    time += 3155673600000L * num;
                    break;
            }
        }
        return new Date(time);
    }

    /**
     * List数组转String数组
     * List To String[]
     *
     * @param list<String> list 传入的List
     * @return String数组
     * @author Hanbings
     */
    public String[] getListToStrings(List<String> list) {
        return list.toArray(new String[0]);
    }

    /**
     * String转Date
     *
     * @param string String格式的时间
     * @author Hanbings
     */
    public Date getStringToDate(String string) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        Date date = null;
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 比较两个时间的大小 将会比较用结束时间来比较开始时间
     * Compare time
     *
     * @return 返回true则表示BAN未过期 返回的Boolean是结束时间去比较开始时间 startTime.getTime() < endTime.getTime()
     */
    public Boolean getCompareTime(String start, String end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        try {
            Date startTime = sdf.parse(start);
            Date endTime = sdf.parse(end);
            return startTime.getTime() < endTime.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 读取一个数组内的每一个项是否符合某一个内容
     *
     * @return 是否包含指定内容
     */
    public Boolean getKeysList(Object[] strings, String playerName) {
        for (Object string : strings) {
            if (string.equals(playerName)) {
                return true;
            }
        }
        return false;
    }

}
