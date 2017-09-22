package com.wz.option;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wz.common.VerificatCode;

public class imageServlet extends BaseServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VerificatCode vc=new VerificatCode(4,35);
		ImageIO.write(vc.getImage(),"jpg",response.getOutputStream());

		HttpSession hs=request.getSession();
		String code=vc.getRand();
		hs.setAttribute("fcode", code);
	}

}
