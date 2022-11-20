package org.example.util.comm;

/**
 * 个人Object对象判断工具类
 *
 * @author wzllby
 * @date 2022年11月20日 20:03
 */
public class ObjectUtils {

    /**
     * 判断对象为null
     *
     * @author wzllby
     * @date 2022/11/20 21:13
     * @param obj 需要判断的对象
     * @return boolean
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 判断对象不为null
     *
     * @author wzllby
     * @date 2022/11/20 21:14
     * @param obj 需要判断的对象
     * @return boolean
     */
    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }
}
