package com.desheng.util.properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

public class PropertiesUtils {
    private static String PROPERTY_NAME = "application.yml";

    private static String UPLOAD_PATH = "file.uploadPath";

    public static Object getCommonYml(Object key) {
        Resource resource = new ClassPathResource(PROPERTY_NAME);
        Properties properties = null;
        try {
            YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
            yamlFactory.setResources(resource);
            properties = yamlFactory.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return properties.get(key);
    }

    /**
     * @return 上传的路径
     */
    public static String getUploadPath() {
        return getCommonYml(UPLOAD_PATH).toString();
    }
}
