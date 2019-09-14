package com.desheng.util.shiro;

import cn.hutool.core.bean.BeanUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

public class ShiroUtil {

    private static Logger log= LoggerFactory.getLogger(ShiroUtil.class);

    /**
     * 添加user的密码加密方法
     */

    public static String SysMd5(String username, String password) {
        String hashAlgorithmName = "MD5";//加密方式
        ByteSource salt = ByteSource.Util.bytes(username);//以账号作为盐值
        int hashIterations = 1024;//加密1024次
        SimpleHash hash = new SimpleHash(hashAlgorithmName, password, salt, hashIterations);

        return hash.toString();
    }

    /**
     * 拿到shiro中存的用户
     *
     * @param tClass 眼转换的calss对象
     * @param <T>
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> T copyProperties(Class<T> tClass) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        T obj = tClass.newInstance();
        if (principal != null) {
            BeanUtil.copyProperties(principal, obj);
        }
        return  obj;
    }

    /**
     * 将类转换成指定的类
     *  Entity属性的值赋值到modelClass
     * @param entity
     * @param modelClass
     * @param <F>
     * @param <T>
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static<F,T> T entityToModel(F entity, Class<T> modelClass) throws InvocationTargetException, IllegalAccessException {
        log.debug("entityToModel : Entity属性的值赋值到Model");
        Object model = null;
        if (entity == null || modelClass ==null) {
            return null;
        }

        try {
            model = modelClass.newInstance();
        } catch (InstantiationException e) {
            log.error("entityToModel : 实例化异常", e);
        } catch (IllegalAccessException e) {
            log.error("entityToModel : 安全权限异常", e);
        }
        BeanUtils.copyProperties(entity, model);
        return (T)model;
    }
}
