<%@page import="com.wz.dto.MusicDto"%>
<%@page import="com.wz.dto.UserDto"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="WZMusic/dist/css/flat-ui.css" rel="stylesheet" />
<link href="WZMusic/docs/assets/css/demo.css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="WZMusic/css/roll-ad.css" />
<link rel="shortcut icon" href="WZMusic/img/favicon.ico" />
<link rel="stylesheet" type="text/css" href="WZMusic/css/wz_index.css" />
<link rel="stylesheet" type="text/css" href="WZMusic/css/love_song.css" />
<link href="WZMusic/dist/css/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<%
	request.setCharacterEncoding("utf-8");
	HttpSession s = request.getSession();
	UserDto user = (UserDto) s.getAttribute("user");
	String realName = null;

	if (user != null) {
		realName = (String) user.getRealName();
	}

	List<MusicDto> music = (List<MusicDto>) request.getAttribute("music");
%>
  
<body>
    <div class="love_song_body">
        <div id="title">
            <div class="love_song_first">
                <img src="WZMusic/images/loveHert.jpg" class="love_song_img" />
            </div>
            <div class="love_song_right">
                <div class="love_song_title"><span class="glyphicon glyphicon-heart-empty"></span>我喜欢的音乐</div>
                <div style="float:left;"><img src="images/zxx.jpg" /> </div>
                <div style="float:left; margin-top:20px;"> <span>&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-headphones"></span> <%=user.getAccoutNumber()%> &nbsp;&nbsp;&nbsp;</span> <small> 2017 年 04 月 14 日 </small> </div>	<div style="clear:both;"></div>
                <div style="margin-top:20px;">
                    <button type="button" class="btn btn-info"><span class="glyphicon glyphicon-play-circle" title="播放"></span>播放</button>

                    <button type="button" class="btn btn-info"><span class="fui-folder" title="收藏"></span>收藏</button>

                    <button type="button" class="btn btn-info"><span class="glyphicon glyphicon-share-alt" title="分享"></span>分享</button>

                    <button type="button" class="btn btn-info"><span class="glyphicon glyphicon-download" title="下载"></span>下载</button>

                    <button type="button" class="btn btn-info"><span class="fui-bubble" title="评论"></span>评论</button>
                </div>
            </div>

            <div style="clear:both;"></div>

            <div class="wz_index_head_one">
                <a class="wz_index_head_one_title">歌曲列表</a><small>&nbsp;&nbsp;<samp><%=music.size()%></samp>首歌</small><span class="wz_left"><a>播放：<samp style="color:#F00;">0</samp>次</a></span>
            </div>

            <div style="margin-top:10px; width:95%; margin: 0 auto 0;">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th></th>
                            <th>歌曲标题</th>
                            <th>时长</th>
                            <th>歌手</th>
                            <th>音乐类型</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<%
                    	int number=1;
                    		for(MusicDto dto:music){ 
                    		
                    	%>
                        <tr>
                            <td style="width:8%;"><%=number%> <span class="glyphicon glyphicon-play-circle" title="播放"></span></td>
                            <td><%=dto.getMusicName() %> </td>
                            <td>04:15</td>
                            <td><%=dto.getSinger() %></td>
                            <td><%=dto.getMucicTypeDto().getTypeName() %></td>
                        </tr>
                        <%
                        	number++;
                        	} 
                        %>
                    </tbody>
                </table>
            </div>
            <div margin:0=margin:0 auto=auto 0;"=0;">
                <ul class="pagination" style="width:100%;">
                    <li class="previous">
                        <a href="#fakelink" class="fui-arrow-left"></a>
                    </li>
                    <li class="active"><a href="#fakelink">1</a></li>
                    <li><a href="#fakelink">2</a></li>
                    <li><a href="#fakelink">3</a></li>
                    <li><a href="#fakelink">4</a></li>
                    <li><a href="#fakelink">5</a></li>
                    <li class="next">
                        <a href="#fakelink" class="fui-arrow-right"></a>
                    </li>
                </ul>
            </div>
            <!-- /pagination -->
        </div>
    </div>
</body>
</html>
