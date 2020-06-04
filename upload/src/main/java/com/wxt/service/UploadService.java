package com.wxt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadService {

    private static final List<String>CONTENT_TYPES = Arrays.asList("image/jpeg","image/gif");
    private static final Logger LOGGER  = LoggerFactory.getLogger(UploadService.class);

    public String upload(MultipartFile file)
    {
        String originalFileName = file.getOriginalFilename();

        // 校验文件的类型
        String contentType = file.getContentType();
        if (!CONTENT_TYPES.contains(contentType))
        {
            LOGGER.info("文件类型不合法: {}",originalFileName);
            return null;
        }

        // 校验文件的内容
        try {
            BufferedImage  bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage==null)
            {
                LOGGER.info("bufferImage is null: {}",originalFileName);
                return null;
            }

            file.transferTo(new File("G:\\leyou\\" + originalFileName));
            return "http://image.leyou.com/" + originalFileName;

        } catch (IOException e) {
            LOGGER.error("file.getInputStrem()出错: {}",originalFileName);
            e.printStackTrace();
        }

        return null;


    }

}
