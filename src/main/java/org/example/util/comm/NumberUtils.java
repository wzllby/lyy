package org.example.util.comm;

import java.util.UUID;

/**
 * 个人数字工具类
 *
 * @author wzllby
 * @date 2022年11月20日 22:32
 */
public class NumberUtils {

    /**
     * 生成uuid
     *
     * @author wzllby
     * @date 2022/11/20 22:34
     * @return java.lang.String
     */
    public static String uuidRomDom() {
        UUID uuid = UUID.randomUUID();
        return String.valueOf(uuid);
    }
}
