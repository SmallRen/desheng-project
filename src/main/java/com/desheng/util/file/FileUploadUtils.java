package com.desheng.util.file;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.desheng.util.DateUtils;
import com.desheng.util.properties.PropertiesUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FileUploadUtils {

    private static Logger log = LoggerFactory.getLogger(FileUploadUtils.class);

    /**
     * 单文件上传
     *
     * @param filePath
     * @param file
     * @return 返回路径
     */
    public static String upload(String filePath, MultipartFile file) throws MaxUploadSizeExceededException, IOException {
        log.info("[文件类型] - [{}]", file.getContentType());
        log.info("[文件名称] - [{}]", file.getOriginalFilename());
        log.info("[文件大小] - [{}]", file.getSize());
        // TODO 将文件写入到指定目录（具体开发中有可能是将文件写入到云存储/或者指定目录通过 Nginx 进行 gzip 压缩和反向代理，此处只是为了演示故将地址写成本地电脑指定目录）
        try {
            //取出上传路劲
            String uploadPath = PropertiesUtils.getUploadPath();
            //获取文件扩展名
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            //根据时间生成文件夹
            String newpath = newpath(file.getOriginalFilename());
            //判断文件夹是否存在
            File savepath = new File(uploadPath + "/" + newpath);
            if (!savepath.exists()) {
                savepath.mkdirs();
            }
            //生成新的文件名
            String fileName = UUID.randomUUID().toString().replace("-", "") + "." + extension;
            //创建目标文件
            File savefile = new File(savepath + "/" + fileName);
            //将内存中的数据写入到目标文件中去

            file.transferTo(savefile);

            //返回路径
            String pathFileName = "/profile/" + newpath + "/" + fileName;
            return pathFileName;
        } catch (MaxUploadSizeExceededException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * Base64文件上传
     *
     * @param base64
     * @throws IOException
     */
    public void base64Upload(String base64) throws IOException {
        // TODO BASE64 方式的 格式和名字需要自己控制（如 png 图片编码后前缀就会是 data:image/png;base64,）
        String uploadPath = PropertiesUtils.getUploadPath();
        String date = DateUtils.getCurrentDate1();
        //取出image/png
        String extension = base64.split(";base64")[0].split(":")[1];
        //得到后缀
        String suffix = MimeTypeUtils.getExtension(extension);
        //生成新的文件名
        String fileName = UUID.randomUUID().toString().replace("-", "") + "." + suffix;
        File tempFile = new File(uploadPath + "/" + date + "/" + fileName);
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }
        // TODO 防止有的传了 data:image/png;base64, 有的没传的情况
        String[] d = base64.split("base64,");
        final byte[] bytes = Base64Utils.decodeFromString(d.length > 1 ? d[1] : d[0]);
        FileCopyUtils.copy(bytes, tempFile);

    }

    /**
     * 用hashcode打散文件存储
     *
     * @param filename
     * @return 格式 w:/upload/20190822/5/6
     */
    public static String newpath(String filename) {
        //获取文件名的hashcode值，这样可以上传文件同名放在一个文件夹下面
        String date = DateUtils.getCurrentDate1();
        int hashcode = filename.hashCode();
        int dir1 = hashcode & 0xf;
        int dir2 = (hashcode & 0xf0) >> 4;

        return date + "/" + dir1 + "/" + dir2;
    }

    /**
     * 返回上传路径
     *
     * @param uploadDir 文件存储地址
     * @param fileName  文件名
     * @return
     * @throws IOException
     */
    private static final String getPathFileName(String uploadDir, String fileName) throws IOException {
        int dirLastIndex = uploadDir.lastIndexOf("/") + 1;
        String currentDir = StringUtils.substring(uploadDir, dirLastIndex);
        String pathFileName = "/profile/" + currentDir + "/" + fileName;
        return pathFileName;
    }


}
