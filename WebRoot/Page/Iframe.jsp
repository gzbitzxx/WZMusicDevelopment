<%@page import="com.wz.dto.MusicDto"%>
<%@page import="java.util.List"%>
<%@page import="com.wz.dto.UserDto"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">

<title>微知音乐</title>
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
<link rel="stylesheet" href="bdPlay/src/css/smusic.css" />

</head>
<%
	request.setCharacterEncoding("utf-8");
	HttpSession s = request.getSession();
	UserDto user = (UserDto) s.getAttribute("user");
	String realName = null;
	if (user != null) {
		realName = (String) user.getAccoutNumber();
	}

	List<MusicDto> music = (List<MusicDto>) request.getAttribute("music");
%>
<body style="background:rgb(245,245,245);">
	<div style=" width:100%; ">
		<div style="width:1080px; margin:0 auto 0;">
			<div class="row">
				<div class="col-xs-12">
					<nav class="navbar navbar-inverse navbar-embossed"
						role="navigation" style="margin:0 auto 0;">
					<div class="navbar-header">
						<a class="navbar-brand" href="javascript:;">微知音乐</a>
					</div>
					<div class="collapse navbar-collapse" id="navbar-collapse-01">
						<ul class="nav navbar-nav navbar-left">
							<li><a href="index" target="IndexIframe">发现音乐</a></li>
							<%
								if (realName!= null) {
							%>
							<li><a href="Page/Center.jsp" target="IndexIframe">我的音乐</a></li>
							<%
								}
							%>
							<li><a href="Page/Friends.jsp" target="IndexIframe">朋友</a></li>
							<li><a href="getArticle" target="IndexIframe">发现文章</a></li>
							<%
								if (realName!= null) {
							%>
							<li><a href="showMyseclfArticle" target="IndexIframe">个人中心</a></li>
							<%
								}
							%>
						</ul>
						<form class="navbar-form navbar-right"
							action="javascript:return false;" role="search">
							<div class="form-group">
								<div class="input-group">
									<input class="form-control" id="navbarInput-01" type="search"
										placeholder="Search"> <span class="input-group-btn">
										<button type="submit" class="btn">
											<span class="fui-search"></span>
										</button>
									</span>
								</div>
							</div>
						</form>
						<div style="float:right; margin-top:10px;">

							<%
								if (realName == null) {
							%>
							<span class="fui-user"><i class="buttonDelete"
								style="color: rgb(255,255,255);font-size: 15px;">亲！请登录</i></span>
							<%
								} else {
							%>
							<!--管理员开始-->
							<ul class="hui-top-nav-right-usr">
								<li class="dropdown"><a class="dropdown-toggle"
									role="button" data-toggle="dropdown" href="#" id="dLabel">
										<span class="fui-user"><i
											class="iconfont icon-touxiang">欢迎<%=realName%></i></span> <b
										class="caret"></b>
								</a>
									<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
										<li role="presentation "><a href="myselfInfo?id=<%=user.getId() %>"
											target="IndexIframe"> <i class="fa fa-user"></i> 个人信息
										</a></li>
										<li role="presentation" class="exitUser"><a
											href="javascript:return false;"> <i
												class="iconfont icon-jinru"></i> 注销
										</a></li>
									</ul></li>
							</ul>
							<!--管理员结束-->
							<%
								}
							%>

						</div>
					</div>
					<!-- /.navbar-collapse --> </nav>
					<!-- /navbar -->
				</div>
				<!-- /.row -->
			</div>

			<!--中间部份开始 -->
			<iframe src="index" width="1080px"
				style="min-height:400px;*+height:100%;_height:400px;"
				name="IndexIframe" frameborder="0" scrolling="no" id="iframeHight" onload="this.height=100"></iframe>
			<!--中间部分结束 -->
			

			<!--footer-->
			<div class="wz_index_footer" style="margin-bottom: 90px">
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

		</div>
		</div>
		<!--底部的播放栏-->
		<div style="width:100%; height:90px;background:rgb(54,73,92); position:fixed; bottom: 0;">
			<div class="grid-music-container f-usn"
				style="width:1080px; margin:0 auto 0;">
				<div class="m-music-play-wrap">
					<div class="u-cover"></div>
					<div class="m-now-info">
						<h1 class="u-music-title">
							<strong>标题</strong><small>歌手</small>
						</h1>
						<div class="m-now-controls">
							<div class="u-control u-process">
								<span class="buffer-process"></span> <span
									class="current-process"></span>
							</div>
							<div class="u-control u-time">00:00/00:00</div>
							<div class="u-control u-volume">
								<div class="volume-process" data-volume="0.50">
									<span class="volume-current"></span> <span class="volume-bar"></span>
									<span class="volume-event"></span>
								</div>
								<a class="volume-control"></a>
							</div>
						</div>
						<div class="m-play-controls">
							<a class="u-play-btn prev" title="上一曲"></a> <a
								class="u-play-btn ctrl-play play" title="暂停"></a> <a
								class="u-play-btn next" title="下一曲"></a> <a
								class="u-play-btn mode mode-list current" title="列表循环"></a> <a
								class="u-play-btn mode mode-random" title="随机播放"></a> <a
								class="u-play-btn mode mode-single" title="单曲循环"></a>
						</div>
					</div>
				</div>
				<div class="f-cb">&nbsp;</div>
				<div class="m-music-list-wrap" style="display:none"></div>
			</div>
		</div>

		<script src="WZMusic/dist/js/vendor/jquery.min.js "></script>
		<script src="WZMusic/dist/js/vendor/video.js "></script>
		<script src="WZMusic/dist/js/flat-ui.min.js "></script>
		<script src="WZMusic/docs/assets/js/application.js "></script>
		<script src="WZMusic/js/jquery.roll-ad.js "></script>
		<script src="weizhi/htmlframe/plugings/layui/layui.js"
			type="text/javascript"></script>
		<script src="bdPlay/src/js/smusic.min.js"></script>

		<script type="text/javascript">
		
			layui.use([ 'layer', 'laypage' ], function() {
				var $ = layui.jquery,
					layer = layui.layer,
					laypage = layui.laypage;
		
				$(".buttonDelete").click(function() {
					layer.open({
						type : 2,
						title : '用户登陆',
						shadeClose : true,
						area : [ '420px', '420px' ],
						content : 'Page/Lands.jsp',
					});
				});
		
				$(".exitUser").click(function() {
					var url = "exitUserLands";
					$.post(url, function(data) {
						if (data == 0) {
							window.location.reload();
						}
					});
				});
		
			});
		</script>
		
		<script>
        var musicList = [
            {
                title: '夏天',
                singer: '李玖哲 ',
                cover: 'bdPlay/images/lijiuzhe.jpg',
                src: 'music/李玖哲 - 夏天.mp3'
            },
            {
                title: '可乐',
                singer: '赵紫骅',
                cover: 'bdPlay/images/yangcong.jpg',
                src: 'music/丽江小倩 - 红蔷薇.mp3'
            },
            {
                title: '一瞬间',
                singer: '马融',
                cover: 'bdPlay/images/marong.jpg',
                src: 'music/马融 - 一瞬间.mp3'
            },
            {
                title: '你就不要想起我',
                singer: '冯提莫',
                cover: 'bdPlay/images/fentimo.jpg',
                src: 'http://localhost:8080/WZMusicDevelopment/bdPlay/1.mp3'
            }
        ];
        new SMusic({
            musicList: musicList
        });
    </script>
    
    <script type="text/javascript">
    	function reinitIframe(){
    		var iframe=document.getElementById("iframeHight");
    		try{
				var bHeight = iframe.contentWindow.document.body.scrollHeight;
				var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
				var height = Math.max(bHeight, dHeight);
				iframe.height = height;
			}catch (ex){}
    	}
    	window.setInterval("reinitIframe()",200);
    </script>
</body>
</html>
