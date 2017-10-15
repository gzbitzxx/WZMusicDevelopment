package com.wz.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * 生成图片验证码
 * @author 
 *
 */
public class VerificatCode {
	private int len;//验证码的长度
	private int height;//图片高度
	private int width;//图片长度
	private Font font;//设置图片字体及大小
	private int interfere=5;//设置干扰线的数量
	private String[] str={"a","b","c","d","e","f","g","h",
						  "i","j","k","m","n","p","s","t",
						  "u","v","w","x","y","z","2",
						  "3","4","5","6","7","8","9"} ;//设置验证码产生的字符集
	
	private String rand;//验证码产生的字符串
	/**
	 * 
	 * @param len 验证码字符数量
	 * @param height 图片高度
	 */
	public VerificatCode(int len,int height) {
		this.len=len;
		this.height=height;
		this.width=len*((int)Math.floor(height/2))+12;
		this.font=new Font("宋体", Font.PLAIN, height);
	}
	/**
	 * 获取验证码图片上的字符
	 * @return 验证码图片上的字符
	 */
	public String getRand() {
		return rand;
	}
	private Color getRanColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc-fc);
		int g = fc + random.nextInt(bc-fc);
		int b = fc + random.nextInt(bc-fc);
		return new Color(r, g, b);
	}
	
	/**
	 * 获取验证码图片
	 * @return 验证码图片
	 */
	public BufferedImage getImage() {
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		Random random=new Random();
		//设置背景色
		//g.setColor(getRanColor(200, 250));
		g.setColor(new Color(255,255, 255));
		//画一个实心的长方形，作为背景
		g.fillRect(0, 0, width, height);
		//设置字体
		g.setFont(font);
		g.setColor(getRanColor(160, 200));
		//随机产生干扰线
		for (int i = 0; i < interfere; i++) {
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			int x1=random.nextInt(12);
			int y1=random.nextInt(12);
			g.drawLine(x, y, x+x1, y+y1);
		}
		String sRand="";
		for (int i = 0; i < len; i++) {
			String rand=str[random.nextInt(str.length)];
			sRand+=rand;
			//将验证码显示到图像中
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
			g.drawString(rand, (int)Math.floor((height/2))*i+6, height-(int)Math.floor(height/6));
		}
		rand=sRand;
		g.dispose();
		return image;
		
	}
}
