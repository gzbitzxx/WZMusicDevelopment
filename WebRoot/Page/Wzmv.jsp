<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Wzmv.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="WZMusic/dist/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Loading Flat UI -->
<link href="WZMusic/dist/css/flat-ui.css" rel="stylesheet">
<link href="WZMusic/docs/assets/css/demo.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="WZMusic/css/roll-ad.css">
<link rel="shortcut icon" href="WZMusic/img/favicon.ico">
<link rel="stylesheet" type="text/css" href="WZMusic/css/wz_index.css">
<link rel="stylesheet" type="text/css" href="WZMusic/css/wz_mv.css" />

</head>

<body >
<div class="wz_index_head_one">
    	<a href="#" class="wz_index_head_one_title" >我的MV<small>(3)</small></a>
    </div>
    
    <div style="width:90%; margin:0 auto 0;">
        <div class="wz_right_world5_singer">
            <div><img src="WZMusic/images/bzd.jpg" class="wz_right_world5_singe_pic"></div>
            <div class="singel_name"><a>听海</a></div>
            <div> <small><a>张惠妹</a></small></div>
        </div>
        
         <div class="wz_right_world5_singer">
            <div><img src="WZMusic/images/gjj.jpg" class="wz_right_world5_singe_pic"></div>
            <div class="singel_name"><a>情歌王</a></div>
            <div> <small><a>古巨基</a></small></div>
        </div>
         <div class="wz_right_world5_singer">
            <div><img src="WZMusic/images/jjjjjj.jpg" class="wz_right_world5_singe_pic"></div>
            <div class="singel_name"><a>告白气球</a></div>
            <div> <small><a>周杰伦</a></small></div>
        </div>
    </div>
</body>
</html>
