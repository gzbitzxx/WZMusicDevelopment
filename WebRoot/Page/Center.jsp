<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">

<title>我的音乐</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- Loading Bootstrap -->
<link href="WZMusic/dist/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="WZMusic/dist/css/flat-ui.css" rel="stylesheet">
<link href="WZMusic/docs/assets/css/demo.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="WZMusic/css/roll-ad.css">
<link rel="shortcut icon" href="WZMusic/img/favicon.ico">
<link rel="stylesheet" type="text/css" href="WZMusic/css/wz_index.css">
<link rel="stylesheet" type="text/css" href="WZMusic/css/center.css">

</head>

<body style="background:rgb(245,245,245);">
	<div style=" width::100%;">
		<div style="width:1080px; margin:0 auto 0;">
			<!--中间部分开始-->
			<div id="wz_index_body">
				<!--left begin-->
				<div id="center_left">
					<ul class="list-group" style="font-weight:bold; font-size:14px;">
						<li class="list-group-item"><a href="Page/Single.jsp"
							target="openIframe">我的歌手</a></li>
						<li class="list-group-item"><a href="Page/Wzmv.jsp"
							target="openIframe">我的MV</a></li>
						<li class="list-group-item" id="Table_Open"><a>我的音乐<span
								class="fui-triangle-up"></span></a></li>
						<li class="list-group-item" id="tongy1"><a
							href="<%=basePath %>specialMusic" target="openIframe">特别喜欢</a></li>
						<li class="list-group-item" id="tongy2"><a
							href="<%=basePath %>recentMusic" target="openIframe">最近</a></li>
						<li class="list-group-item" id="tongy3"><a href="javaascript:;">轻音乐</a></li>
						<li class="list-group-item" id="tongy4"><a href="javaascript:;">摇滚</a></li>
					</ul>
					<!-- /btn-group -->
				</div>
				<!--left begin-->
				<!--right begin-->
				<div id="center_right">
					<iframe name="openIframe" style="width:100%; min-height:100%;"
						src="<%=basePath %>specialMusic"></iframe>
				</div>
				<!--right begin-->
			</div>
			<!--中间部分结束-->
		</div>
		<div style="clear:both;"></div>

		  <script src="WZMusic/dist/js/vendor/jquery.min.js "></script>
        <script src="WZMusic/dist/js/vendor/video.js "></script>
        <script src="WZMusic/dist/js/flat-ui.min.js "></script>
        <script src="WZMusic/docs/assets/js/application.js "></script>
        <script src="WZMusic/js/jquery.roll-ad.js "></script>
        <script type="text/jscript">
            $(document).ready(function () {

                for (var i = 0; i < 5; i++) {
                    $("#center_left").find("#tongy" + i).hide();
                }

                $("#Table_Open").click(function () {
                    var text = $(this).find("a span").attr("class");
                    if (text == 'fui-triangle-down') {
                        $(this).find("a span").attr("class", "fui-triangle-up");
                        for (var i = 0; i < 5; i++) {
                            $("#center_left").find("#tongy" + i).hide("flst");
                        }

                    } else {
                        $(this).find("a span").attr("class", "fui-triangle-down");
                        for (var i = 0; i < 5; i++)
                            $("#center_left").find("#tongy" + i).show("flst");

                    }
                });
            });
        </script>


</body>
</html>
