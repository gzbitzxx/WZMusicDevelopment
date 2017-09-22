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

<title>My JSP 'Tail.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- Loading Bootstrap -->
<link href="WZMusic/dist/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Loading Flat UI -->
<link href="WZMusic/dist/css/flat-ui.css" rel="stylesheet">
<link href="WZMusic/docs/assets/css/demo.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="WZMusic/css/roll-ad.css">
<link rel="shortcut icon" href="WZMusic/img/favicon.ico">
<link rel="stylesheet" type="text/css" href="WZMusic/css/wz_index.css">

</head>

<body>

	<div style="clear:both; "></div>

	<!--footer开始-->
	<div class="wz_index_footer" style="margin-bottom: 60px">
		<div
			style="width:1080px; height:100%; background:#B1A9A9; margin:0 auto 0; ">
			<div class="wz_index_footer_title">
				<p class="wz_index_footer_name">微知音乐歌曲招募</p>
				<p class="wz_index_footer_word">上传音乐，给你不一样的惊喜</p>
			</div>
			<div class="wz_index_footer_title">
				<p class="wz_index_footer_name">音乐人签约</p>
				<p class="wz_index_footer_word">我们的音乐团队，等待你的加入</p>
			</div>
			<div class="wz_index_footer_title">
				<p class="wz_index_footer_name">关于微知-客服服务 贵州大学 SRT
					微知开发项目小组版权所有@2017 Coding Right</p>
				<p class="wz_index_footer_word">
					<span class="fui-location "></span>：贵州省贵阳市花溪区贵州大学北校区
				</p>
			</div>
		</div>
	</div>
	<!--footer结束-->

	<!--底部的播放栏开始-->
	<div id="zxx_doo" style="width:100%;height:60px;background:#000000;position:fixed;bottom: 0">
		<div style="width:1080px; height:100%; margin:0 auto 0; ">
            <div style="margin-top:12px; height:100%; float:left; ">
                <span style=" margin-left:15px; "> <img src="images/reverse.png " title="上一曲 " /></span>
                <span style="margin-left:15px; "><img src="images/pause.png " title="暂停 " /></span>
                <span style="margin-left:15px; "><img src="images/next.png " title="下一曲 " /></span>
            </div>
            <div style="float:left; ">
                <img src="WZMusic/images/images (2).jpg " height="60px " ; width="60px " ; style="margin-left:15px; " />
            </div>
            <div style="float:left; width:40%; height:100%; ">
                <p style="font-size:20px; ">当你 <samp style="font-size:5px; ">林俊杰</samp> <span style="float:right; font-size:15px; ">00:00/05:23</span></p>
                <div id="slider" class="ui-slider">
                    <div class="ui-slider-segment"></div>
                    <div class="ui-slider-segment"></div>
                    <div class="ui-slider-segment"></div>
                </div>
            </div>
            <div style="float:left; width:20%; height:100%; margin-top:20px; ">
                <span class="fui-heart " style="margin-left:50px; margin-right:12px; "></span> | <span class="fui-mute " style="margin-left:12px; "></span>
            </div>

        </div>
    </div>
	<!--底部的播放栏结束-->

	<script src="WZMusic/dist/js/vendor/jquery.min.js "></script>
	<script src="WZMusic/dist/js/vendor/video.js "></script>
	<script src="WZMusic/dist/js/flat-ui.min.js "></script>
	<script src="WZMusic/docs/assets/js/application.js "></script>
	<script src="WZMusic/js/jquery.roll-ad.js "></script>

	<script>
		videojs.options.flash.swf = "WZMusic/dist/js/vendors/video-js.swf ";
	</script>

	<script>
		RollAd.init($('.rollad'));
	</script>

	<script>
		var timer;
		var obj = document.getElementById('zxx_doo');
		window.onscroll = function() {
			clearTimeout(timer);
			timer = setTime(function() {
				var scrolltop = document.body.scrolltop || document.documentElement.scrollTop || 0;
				obj.style.buttom = 0 - scroltop + 'px';
			}, 300);
		}
	</script>

</body>
</html>
