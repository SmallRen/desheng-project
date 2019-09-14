package com.desheng.util;

import java.util.HashMap;
import java.util.Map;

public class ResultMsg {

    /**
     * 成功信息
     *
     * @param msg 信息内容
     * @return Map
     */
    public static Map<String, Object> success(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("code", 0);
        map.put("msg", msg);
        return map;
    }

    /**
     * 失败信息
     *
     * @param msg 信息内容
     * @return Map
     */

    public static Map<String, Object> failure(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 100);
        map.put("code", 100);
        map.put("msg", msg);
        return map;
    }

    /**
     * shiro session过期
     */
    public static Map<String, Object> shiroSessionDisabled(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 403);
        map.put("msg", msg);
        return map;
    }

    /**
     * 成功数据信息
     *
     * @param obj 返回数据
     * @return
     */
    public static Map<String, Object> successData(Object obj, String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("code", 0);
        map.put("msg", msg);
        map.put("data", obj);
        return map;
    }

    /**
     * 失败数据信息
     *
     * @param obj 返回数据
     * @return
     */
    public static Map<String, Object> failureData(Object obj, String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 100);
        map.put("code", 100);
        map.put("msg", msg);
        map.put("data", obj);
        return map;
    }


}
