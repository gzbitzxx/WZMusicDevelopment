package com.wz.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sun.mail.handlers.image_gif;
import com.wz.common.BrithDayNumber;
import com.wz.common.EncodeByMd5;
import com.wz.dao.AdminDao;
import com.wz.dto.AdminDto;
import com.wz.dto.ArticleDto;
import com.wz.dto.CommentsDto;
import com.wz.dto.MusicDto;
import com.wz.dto.MusicTypeDto;
import com.wz.dto.Page;
import com.wz.dto.UserDto;

public class Test {
	public static void main(String[] args) throws UnknownHostException, NoSuchAlgorithmException, UnsupportedEncodingException {

		// 管理员测测试代码
		// 获取有效
		// AdminoCRUD t=new AdminoCRUD();
		// try {
		// t.init();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// System.out.println(t.getAdmin());
		//
		// //查询有效
		// AdminDto dto=new AdminDto();
		// dto.setRealName("star");
		// System.out.println(t.queryAddmin(dto));
		//
		//
		//
		// AdminDto ad=new AdminDto();
		// ad.setId(37);
		// t.queryAdmin(ad);
		// System.out.println(t.queryAdmin(ad));
		// //
		// System.out.println(t.getAdmin());
		// System.out.println("asdfasefasdfasdf");
//		InetAddress ia = null;
		// String i=ia.getHostAddress();
		// System.out.println(i);

		// 测试获取Ip的地址
//		ia = InetAddress.getLocalHost();
//		String ipStrs = ia.getHostAddress();
//
//		System.out.println(ipStrs);

		// User 代码测试
//		UserCRUD u = new UserCRUD();

		// 添加用户
		// UserDto dto=new UserDto();
		// dto.setAccoutNumber("1000");
		// dto.setAge(15);
		// dto.setBrithday("2017-4-4");
		// dto.setHobby("篮球");
		// dto.setLoginIP(ipStrs);
		// dto.setPassword("122345");
		// dto.setRealName("zxx");
		// dto.setSex("男");
		// dto.setView("1");
		// u.AddUser(dto);

		// 删除
		// UserDto dto=new UserDto();
		// dto.setId(3);
		//
		// u.DeleteUser(dto);

		//修改
//		UserDto dto = new UserDto();
//		dto.setId(2);
//		dto.setAccoutNumber("1000");
//		dto.setAge(15);
//		dto.setBrithday("2017-4-4");
//		dto.setHobby("篮球");
//		dto.setLoginIP(ipStrs);
//		dto.setPassword("122345");
//		dto.setRealName("zxx");
//		dto.setSex("男");
//		dto.setView("1");
//		u.insertUser(dto);
		
		//这是查找
//		UserDto dto = new UserDto();
//		dto.setRealName("zxx");
//		UserDto m=u.queryUser(dto);
//		System.out.println(m);
		
		//这是后去所有的User 数据
//		 for (UserDto string : u.getUser()) {
//			System.out.println(string);
//		}
		
		
		//测试 Music
//		MusicCRUD mu=new MusicCRUD();
		
		//添加音乐
//		MusicDto dto=new MusicDto();
//		MusicTypeDto mt=new MusicTypeDto();
//		mt.setId(1);
//		dto.setMucicTypeDto(mt);
//		dto.setMusicName("花海");
//		dto.setSinger("周杰伦");
//		dto.setPath("C:/Muisc/花海.mp3");
//		boolean b=mu.AddMusic(dto);
		
		//删除Music
//		dto.setId(4);
//		boolean b=mu.DeleteMusic(dto);
		
//		if(b){
//			System.out.println("插入成功！");
//		}
		
//		if(b){
//			System.out.println("删除成功！");
//		}
//		dto.setId(5);
//		dto.setMusicName("haha");
//		dto.setSinger("周");
//		dto.setMucicTypeDto(mt);
//		mu.insertMusic(dto);
		
		
//		 java.util.List<MusicDto> list= mu.getMusic();
//		 for (MusicDto musicDto : list) {
//			System.out.println(musicDto);
//		}
		
//		ArticleCRUD at=new ArticleCRUD();
//		ArticleDto dto=new ArticleDto();
//		dto.setId(2);
//		dto.setLikeNumber(1);
//		dto.setWords("记录一些我的故事，用音乐留住一些感动！");
//		
//		UserDto u=new UserDto();
//		u.setId(5);
//		
//		dto.setUserDto(u);
//		
//		MusicDto m=new MusicDto();
//		m.setId(13);
//		
//		dto.setMusicDto(m);
//		
		//添加Article
//		boolean b=at.AddArticle(dto);
		
//		删除文章
//		dto.setId(1);
//		boolean b=at.DeleteArticle(dto);
		
		//修改成功
//		boolean b=at.insertArticle(dto);
//		if (b) {
//			System.out.println("修改成功！");
//		}
		
		//获取ArticleDto
//		List<ArticleDto> ar=at.getArticle();
//		for (ArticleDto articleDto : ar) {
//			System.out.println(articleDto);
//		}
//		
//		MusicCRUD admin=new MusicCRUD();
//		// 获取管理员列表
//		System.out.println(admin.getMusicsPage(3,2).toString());
		
		//测试加密
//		System.out.println(EncodeByMd5.EncoderByMd5("zxx123"));
//		System.out.println(EncodeByMd5.EncoderByMd5("zxx123"));
		
//		int age=BrithDayNumber.Calculation("1998-04-12");
//		System.out.println(age);
		
//		CommentsCRUD c=new CommentsCRUD();
////		List<CommentsDto> s=c.getCommentPage(1, 10);
////		System.out.println(s.toString());
//		CommentsDto com=new CommentsDto();
//		com.setId(8);
//		Date s=new Date();
//		com.setDate("2018-7-7");
//		MusicDto m=new MusicDto();
//		m.setId(1);
//		com.setMusicDto(m);
//		UserDto u=new UserDto();
//		u.setId(6);
//		com.setUserDto(u);
//		com.setWords("hhhhhhhhhh");
//		
//		Boolean bn=c.updataComment(com);
//		if(bn){
//			System.out.println("Yes");
//		}
		
//		String s="AFF30C130A9000055DFB40DCDDF82578";
//		System.out.println(s.length());
		
//		B743B522677160D76461AD7B01AD3ED3
	//	A4C593B98D4FC738385F385B2CF2A5F5
	//	AFF30C130A9000055DFB40DCDDF82578
		
//		 String MD5_String;
//	        MD5_String = MD5("zxx123");
//	        System.out.println(MD5_String);
		
//		String s=EncodeByMd5.EncoderByMd5("zxx123456");
//		System.out.println(s);
		
		//计算年龄
		
//		  String dataOfBirth = "1994-3-28";  
//	        int age =getAgeFromBirthTime(dataOfBirth);  
//	        System.out.println("age:" + age);  
//		
		
		
		//测试获取的个人的文章
		UserDto userDto=new UserDto();
		userDto.setId(10);
		ArticleCRUD article=new ArticleCRUD();
		ArticleDto dto=new ArticleDto();
		dto.setUserDto(userDto);
		article.queryMyselfArticles(dto);
		
		System.out.println(article.queryMyselfArticles(dto));
		
		}}
//	 public static String MD5(String key) {
//	        char hexDigits[] = {
//	                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
//	        };
//	        try {
//	            byte[] btInput = key.getBytes();
//	            // 获得MD5摘要算法的 MessageDigest 对象
//	            MessageDigest mdInst = MessageDigest.getInstance("MD5");
//	            // 使用指定的字节更新摘要
//	            mdInst.update(btInput);
//	            // 获得密文
//	            byte[] md = mdInst.digest();
//	            // 把密文转换成十六进制的字符串形式
//	            int j = md.length;
//	            char str[] = new char[j * 2];
//	            int k = 0;
//	            for (int i = 0; i < j; i++) {
//	                byte byte0 = md[i];
//	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
//	                str[k++] = hexDigits[byte0 & 0xf];
//	            }
//	            return new String(str);
//	        } catch (Exception e) {
//	            return null;
//	        }
//	    }
	
//	 public static int getAgeFromBirthTime(String birthTimeString) {  
//	        // 先截取到字符串中的年、月、日  
//	        String strs[] = birthTimeString.trim().split("-");  
//	        int selectYear = Integer.parseInt(strs[0]);  
//	        int selectMonth = Integer.parseInt(strs[1]);  
//	        int selectDay = Integer.parseInt(strs[2]);  
//	        // 得到当前时间的年、月、日  
//	        Calendar cal = Calendar.getInstance();  
//	        int yearNow = cal.get(Calendar.YEAR);  
//	        int monthNow = cal.get(Calendar.MONTH) + 1;  
//	        int dayNow = cal.get(Calendar.DATE);  
//	  
//	        // 用当前年月日减去生日年月日  
//	        int yearMinus = yearNow - selectYear;  
//	        int monthMinus = monthNow - selectMonth;  
//	        int dayMinus = dayNow - selectDay;  
//	  
//	        int age = yearMinus;// 先大致赋值  
//	        if (yearMinus < 0) {// 选了未来的年份  
//	            age = 0;  
//	        } else if (yearMinus == 0) {// 同年的，要么为1，要么为0  
//	            if (monthMinus < 0) {// 选了未来的月份  
//	                age = 0;  
//	            } else if (monthMinus == 0) {// 同月份的  
//	                if (dayMinus < 0) {// 选了未来的日期  
//	                    age = 0;  
//	                } else if (dayMinus >= 0) {  
//	                    age = 1;  
//	                }  
//	            } else if (monthMinus > 0) {  
//	                age = 1;  
//	            }  
//	        } else if (yearMinus > 0) {  
//	            if (monthMinus < 0) {// 当前月>生日月  
//	            } else if (monthMinus == 0) {// 同月份的，再根据日期计算年龄  
//	                if (dayMinus < 0) {  
//	                } else if (dayMinus >= 0) {  
//	                    age = age + 1;  
//	                }  
//	            } else if (monthMinus > 0) {  
//	                age = age + 1;  
//	            }  
//	        }  
//	        return age;  
//	    }  
//	
//	}

