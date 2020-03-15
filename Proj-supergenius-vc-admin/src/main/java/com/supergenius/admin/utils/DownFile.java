package com.supergenius.admin.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownFile {
    /**
     *  filename 下载到客户端后的文件名称
          *   filepath 文件的路径 绝对路径和相对路径都可以
     *下载 文件
     */
    public static void downZip(String filename, String filepath, HttpServletResponse response) {


        FileInputStream inStream=null;
        try {
            File zip=new File(filepath);// 文件
            inStream=new FileInputStream(zip);
            byte[] buf=new byte[4096];
            int readLength;
            setResponseHeader(response, filename);
            while (((readLength=inStream.read(buf)) != -1)) {
                response.getOutputStream().write(buf, 0, readLength);
            }
        }catch (Exception e){
            try {
                OutputStream outputStream=response.getOutputStream();//获取OutputStream输出流
                response.setHeader("content-type", "text/html;charset=UTF-8");//通过设置响应头控制浏览器以UTF-8的编码显示
                byte[] dataByteArr="下载失败".getBytes("UTF-8");//将字符转换成字节数组，指定以UTF-8编码进行转换
                outputStream.write(dataByteArr);//使用OutputStream流向客户端输出字节数组
                return;
            }catch (Exception ex){

            }
        }finally {
            try {
                inStream.close();
            } catch (Exception e) {

            }
        }
    }

    /**
     * 设置响应头  文件类型为zip的   可以修改对应的后缀
     */
    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            response.reset();// 清空输出流
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + new String(fileName.getBytes("GB2312"), "8859_1")
                    );
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void responsnDownload(HttpServletResponse resp, String fileName) {
        File file = new File(fileName);
        String name = file.getName();
        resp.reset();
        resp.setContentType("application/octet-stream");
        resp.setCharacterEncoding("utf-8");
        resp.setContentLength((int) file.length());
        resp.setHeader("Content-Disposition", "attachment;filename=" + name);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = resp.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            boolean delete = file.delete();
            System.out.println("删除成功");
        }
    }
}
