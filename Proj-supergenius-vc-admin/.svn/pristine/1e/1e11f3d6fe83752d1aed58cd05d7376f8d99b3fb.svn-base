package com.supergenius.admin.utils;


import com.supergenius.admin.utils.image.IM4GraphicsMagickEngine;
import org.ehcache.shadow.org.terracotta.offheapstore.Metadata;
import org.im4java.core.IM4JavaException;
import org.im4java.core.InfoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author Architect.bian
 *
 */
public class ImgUtil extends BaseUtil {

	private static Logger log = LoggerFactory.getLogger(ImgUtil.class);
	
	public static final String southeast = "southeast";

	//	private static ImageEngine engine = new IM4GraphicsMagickEngine();
	private static IM4GraphicsMagickEngine engine = new IM4GraphicsMagickEngine();
	
	public static String resizeImage(int width, int height, String file) {
		try {
			return engine.resizeImages(width, height, file)[0];
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}
	
	public static String resizeImage(int width, int height, double quality, String file) {
		try {
			return engine.resizeImages(width, height, quality, file)[0];
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}
	
	public static String[] resizeImages(int width, int height, String... files) {
		try {
			return engine.resizeImages(width, height, files);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}
	
	public static String waterTextMark(String text, int size, String color, String gravity, int dissolve, String srcImgPath) {
		try {
			return engine.waterTextMarks(text, size, color, gravity, dissolve, srcImgPath)[0];
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}

	/**
	 * 给当前图片直接加水印不创建新文件
	 * @param imgnature
	 * @param waterImgPath
	 * @param gravity
	 * @return
	 */
	public static String waterMark(String imgnature, String waterImgPath, String gravity) {
		try {
			return engine.waterMarks(imgnature, waterImgPath, gravity);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}

	/**
	 * 给一张图片加水印，会创建新文件
	 * @param waterImgPath
	 * @param gravity
	 * @param dissolve
	 * @param srcImgPath
	 * @return
	 */
	public static String waterMark(String waterImgPath, String gravity, int dissolve, String srcImgPath) {
		try {
			return engine.waterMarks(waterImgPath, gravity, dissolve, srcImgPath)[0];
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}
	
	/**
	 * 给多张图片加水印，会创建新的水印文件
	 * @param waterImgPath
	 * @param gravity
	 * @param dissolve
	 * @param srcImgPath
	 * @return
	 */
	public static String[] waterMarks(String waterImgPath, String gravity, int dissolve, String... srcImgPath) {
		try {
			return engine.waterMarks(waterImgPath, gravity, dissolve, srcImgPath);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}
	
	public static String cropImage(int dw, int dh, String srcPaths) {
		try {
			return engine.cropImage(dw, dh, srcPaths)[0];
		} catch (Exception e) {
			logException(log, e);
			return null;
		}
	}
	
	public static String[] cropImage(int dw, int dh, String... srcPaths) {
		try {
			return engine.cropImage(dw, dh, srcPaths);
		} catch (Exception e) {
			logException(log, e);
			return null;
		}
	}
	
	public static String cutImage(int x, int y, int x2, int y2, String srcPath) {
		try {
			return engine.cutImage(x, y, x2, y2, srcPath)[0];
		} catch (Exception e) {
			logException(log, e);
			return null;
		}
	}
	
	public static String rotate(double angle, String srcImgPath) {
		try {
			return engine.rotate(angle, srcImgPath)[0];
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}

	public static String[] rotate(double angle, String... srcImgPath) {
		try {
			return engine.rotate(angle, srcImgPath);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}
	
	public static String concatenateImage(int width, int height, String... srcPaths) {
		try {
			return engine.concatenateImage(width, height, srcPaths);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}
	
	public static String gray(String srcImgPath) {
		try {
			return engine.gray(srcImgPath)[0];
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}
	
	public static String[] gray(String... srcImgPath) {
		try {
			return engine.gray(srcImgPath);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}
	
	public static String showImageInfo(String img) {
		try {
			return engine.showImageInfo(img);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}
	
	public static int getImageWidth(String img) {
		try {
			return engine.getImageWidth(img);
		} catch (InfoException e) {
			logException(log, e);
			return -1;
		}
	}
	
	public static int getImageHeight(String img) {
		try {
			return engine.getImageHeight(img);
		} catch (InfoException e) {
			logException(log, e);
			return -1;
		}
	}
	
	public static String getGeometry(String img) {
		try {
			return engine.getGeometry(img);
		} catch (InfoException e) {
			logException(log, e);
			return null;
		}
	}
	
	public static String getImageFormat(String img) {
		try {
			return engine.getImageFormat(img);
		} catch (InfoException e) {
			logException(log, e);
			return null;
		}
	}

	/**
	 * @param srcImgPath
	 * @return
	 */
	public static String[] compress(String... srcImgPath) {
		try {
			return engine.compress(srcImgPath);
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}
	
	/**
	 * @param srcImgPath
	 * @return
	 */
	public static String compress(String srcImgPath) {
		try {
			return engine.compress(srcImgPath)[0];
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}

	/**
	 *
	 * @param quality
	 * @param srcImgPath
	 * @return
	 */
	public static String compress(double quality, String srcImgPath) {
		try {
			return engine.compress(quality, srcImgPath)[0];
		} catch (IOException | InterruptedException | IM4JavaException e) {
			logException(log, e);
			return null;
		}
	}
	
	/**
	 * 获得iphone手机竖屏照片上传时的修正角度
	 * @param imgFile
	 * @return
	 * @author liubin
	 * @createtime 2017年3月31日下午5:55:43
	 * @return int
	 */

}