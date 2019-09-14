package com.desheng.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.desheng.util.spring.SpringContextUtil;
import com.desheng.util.spring.SpringUtils;

import java.lang.reflect.Method;
import java.util.*;


/**
 * 通过类名获取里面的 方法
 */
public class MethodReflect {

    private static Logger log = LoggerFactory.getLogger(MethodReflect.class);
    private Object T;

    /**
     * 获取全部公共的方法 返回数组
     *
     * @param beanName 类名
     * @return 返回数组
     */
    public static List<?> MethodReflect(String beanName) {
        Object obj = SpringUtils.getBean(beanName);
        Method[] methods = obj.getClass().getMethods();
        String className = obj.getClass().getSimpleName();
        List<StringBuilder> list = new ArrayList<>();
        for (Method method : methods) {
            StringBuilder str = new StringBuilder();
            //  log.info("反射方法：" + method.toString());也行
            //调整前端需要的格式
           // str.append(className + ".");// 类名
            str.append(method.getName());// 获取方法的名字
            Class<?>[] types = method.getParameterTypes();// 或形参个数
            str.append("(");
            for (int i = 0; i < types.length; i++) {
                if (i == types.length - 1) {
                    str.append(types[i].getSimpleName());
                } else {
                    str.append(types[i].getSimpleName() + ",");
                }
            }
            str.append(")");
            //log.info("反射方法：" + str);
            list.add(str);
        }
        return list;
    }


    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.layui.util.MethodReflect");
            System.out.println(aClass.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //   MethodReflect.MethodReflect("ResultInfo");
    }
}
