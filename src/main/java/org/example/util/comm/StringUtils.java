package org.example.util.comm;

/**
 * 个人字符串工具类
 *
 * @author wzllby
 * @date 2022年11月20日 19:46
 */
public class StringUtils {

    /**
     * 判断一个字符串是否为empty
     *
     * @author wzllby
     * @date 2022/11/20 19:48
     * @param str 需要判断的字符串
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        return str == null || str == "" || str.length() == 0;
    }

    /**
     * 判断一个字符串是否不为empty
     *
     * @author wzllby
     * @date 2022/11/20 19:49
     * @param str 需要判断的字符串
     * @return null
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
