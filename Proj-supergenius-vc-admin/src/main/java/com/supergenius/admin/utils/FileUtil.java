package com.supergenius.admin.utils;

import com.supergenius.admin.capital.model.vo.VCImageUploadVO;
import com.supergenius.admin.constants.Consts;
import com.supergenius.admin.enums.EUpload;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileUtil {
    //判断图片尺寸大小
    public static boolean checkImageElement(MultipartFile file, int imageWidth, int imageHeight) throws IOException {
        Boolean result = false;
        if (!file.isEmpty()) {
            return false;
        }
        BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        if (bufferedImage != null && height == imageHeight && width == imageWidth) {
            result = true;
        }
        return result;
    }
    //上传图片 文件 路径 宽度，高度
    public static VCImageUploadVO uploadPic(MultipartFile file, String filePath, int width, int height) throws IOException {
        if(file.isEmpty()){
            //return EUpload.FILENULL;
            return  new VCImageUploadVO(EUpload.FILENULL,"null");
        }
        int begin = file.getOriginalFilename().indexOf(".");
        int last = file.getOriginalFilename().length();
        String a = file.getOriginalFilename().substring(begin, last);
        if(a.endsWith(Consts.IMG_TYPE_JPG)||a.endsWith(Consts.IMG_TYPE_PNG)){
            boolean b = checkImageElement(file, width, height);
            if(b){
                String fileName=file.getOriginalFilename();
                File file1=new File(filePath+"\\"+fileName);
                try {
                    file.transferTo(file1);
                    String path = file1.getPath();
                    //return EUpload.SUCCESS;
                    return  new VCImageUploadVO(EUpload.SUCCESS,path);
                } catch (IOException e) {
                    e.printStackTrace();
                   // return EUpload.OTHERERROR;
                    return  new VCImageUploadVO(EUpload.OTHERERROR,"null");
                }
            }
           // return EUpload.SIZEERROR;
            return  new VCImageUploadVO(EUpload.SIZEERROR,"null");

        }
        return new VCImageUploadVO(EUpload.FORMATERROR,"null");
    }
}
