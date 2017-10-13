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

</head>
	<%
	request.setCharacterEncoding("utf-8");
		HttpSession s=request.getSession();
		UserDto user=(UserDto)s.getAttribute("user");
		String realName=null;
		if(user!=null){
			realName=(String)user.getRealName();
		}
		
		List<MusicDto> music=(List<MusicDto>)request.getAttribute("music");
		
	 %>
<body style="background:rgb(245,245,245);">
    <div style=" width:100%; ">
        <div style="width:1080px; margin:0 auto 0;">
            <!---插件-->
            <div style="clear:both;"></div>
            <!--清除浮动-->
            <div style="height:300px; width:100%; margin:0 auto 0; margin-top:-58px;">
                <article class="jq-roll">
                    <div class="rollad" data-setting='{
                                "width":1080,
                                "height":300,
                                "liWidth":700,
                                "liHeight":300,
                                "delay":1000
                            }'>
                        <ul class="roll-list">
                            <li class="roll-item"><img src="WZMusic/wzimage/wz1.jpg" width="100%" height="100%"></li>
                            <li class="roll-item"><img src="WZMusic/wzimage/wz2.jpg" width="100%" height="100%"></li>
                            <li class="roll-item"><img src="WZMusic/wzimage/wz3.jpg" width="100%" height="100%"></li>
                            <li class="roll-item"><img src="WZMusic/wzimage/wz5.jpg" width="100%" height="100%"></li>
                            <li class="roll-item"><img src="WZMusic/wzimage/wz6.jpg" width="100%" height="100%"></li>
                            <li class="roll-item"><img src="WZMusic/wzimage/wz1.jpg" width="100%" height="100%"></li>
                            <li class="roll-item"><img src="WZMusic/wzimage/wz2.jpg" width="100%" height="100%"></li>
                            <li class="roll-item"><img src="WZMusic/wzimage/wz3.jpg" width="100%" height="100%"></li>
                            <li class="roll-item"><img src="WZMusic/wzimage/wz5.jpg" width="100%" height="100%"></li>
                            <li class="roll-item"><img src="WZMusic/wzimage/wz6.jpg" width="100%" height="100%"></li>
                        </ul>
                        <div class="roll-btn">
                            <img src="WZMusic/images/r_left_btn.png" class="roll-prev-btn" />
                            <img src="WZMusic/images/r_right_btn.png" class="roll-next-btn" />
                        </div>
                    </div>
                </article>
            </div>
            <div class="wz_index_body">
                <!--中间内容部分-->
                <!--Left内容-->
                <div class="wz_index_title">
                    <div style="clear:both;"></div>
                    <div class="wz_index_head_one">
                        <span class="wz_index_head_one_title"><a href="javascript:;">热门音乐</a></span> <span class="wz_left"><a href="javascript:;">更多》s</a></span>
                    </div>
                    <!--开始-->
                    <div class="wz_margin10">
                        <div style="text-align:center;" class="wz_picture_set">
                            <img src="WZMusic/images/images (2).jpg" class="wz_pitture_size">
                            <a title="HeLLO" href="#"></a>
                            <div class="button wz_play ">
                                <a title="Play" href="#">播放</a>
                                <span class="fui-triangle-right-large wz_music_play"></span>
                                <span>100万</span>
                            </div>
                            <p class="wz_lunwen"><a href="javascript:;">[华语] 心如欲望，后土难填</a></p>
                        </div>
                        <div class="wz_picture_set">
                            <img src="WZMusic/images/下载.jpg" class="wz_pitture_size">
                            <a title="HeLLO" href="#"></a>
                            <div class="button wz_play ">
                                <a title="Play" href="javascript:;">播放</a>
                                <span class="fui-triangle-right-large wz_music_play"></span>
                                <span>100万</span>
                            </div>
                            <p class="wz_lunwen"><a href="javascript:;">[华语] 心如欲望，后土难填</a></p>
                        </div>
                        <div class="wz_picture_set">
                            <img src="WZMusic/images/下载 (1).jpg" class="wz_pitture_size">
                            <a title="HeLLO" href="#"></a>
                            <div class="button wz_play ">
                                <a title="Play" href="javascript:;">播放</a>
                                <span class="fui-triangle-right-large wz_music_play"></span>
                                <span>100万</span>
                            </div>
                            <p class="wz_lunwen"><a href="javascript:;">[华语] 心如欲望，后土难填</a></p>
                        </div>
                    </div>
                    <!--结束-->
                    <!--开始-->
                    <div class="wz_margin10">
                        <div class="wz_picture_set">
                            <img src="WZMusic/images/images.jpg" class="wz_pitture_size">
                            <a title="HeLLO" href="#"></a>
                            <div class="button wz_play ">
                                <a title="Play" href="javascript:;">播放</a>
                                <span class="fui-triangle-right-large wz_music_play"></span>
                                <span>100万</span>
                            </div>
                            <p class="wz_lunwen"><a href="javascript:;">[华语] 心如欲望，后土难填</a></p>
                        </div>
                        <div class="wz_picture_set">
                            <img src="WZMusic/images/下载 (2).jpg" class="wz_pitture_size">
                            <a title="HeLLO" href="javascript:;"></a>
                            <div class="button wz_play ">
                                <a title="Play" href="javascript:;">播放</a>
                                <span class="fui-triangle-right-large wz_music_play"></span>
                                <span>100万</span>
                            </div>
                            <p class="wz_lunwen"><a href="javascript:;">[华语] 心如欲望，后土难填</a></p>
                        </div>
                        <div class="wz_picture_set">
                            <img src="WZMusic/images/下载 (4).jpg" class="wz_pitture_size">
                            <a title="HeLLO" href="#"></a>
                            <div class="button wz_play ">
                                <a title="Play" href="javascript:;">播放</a>
                                <span class="fui-triangle-right-large wz_music_play"></span>
                                <span>100万</span>
                            </div>
                            <p class="wz_lunwen"><a href="javascript:;">[华语] 心如欲望，后土难填</a></p>
                        </div>
                    </div>
                    <!--结束-->
                    <!--标题栏-->
                    <div style="clear:both;"></div>
                    <div class="wz_index_head_one">
                        <a href="javascript:return false;" class="wz_index_head_one_title">推荐音乐</a></span> <span class="wz_left"><a href="javascript:return false;">更多》</a></span>
                    </div>
                    <div style="margin-top:10px; width:95%; margin: 0 auto 0;">
                        <table class="table table-hover">
                            <tbody>
                            <%
                            int idNumber=1; 
                            for(MusicDto m:music){
                            	
                            %>
                                <tr>
                                    <td style="width:10%;"><%=idNumber %></td>
                                    <td class="wz_music_play">
                                    	<%=m.getMusicName()%>
                                        <span class="fui-triangle-right-large wz_music_play" title="播放"></span>
                                        <span class="fui-heart" title="喜欢"></span>
                                    </td>
                                </tr>
                               <%
                               		idNumber++;
                               		} 
                               %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!--right内容-->
            <div  style="width: 28%; float: right; min-height: 400px;">
            	<%if(realName==null){%>
                <div style="width:100%; height:225px;">
                    <div class="wz_right_part_mysef">
                        <img src="WZMusic/images/noImages.png" height="150" style="float:left;">
                        <div style="float:left; text-align:center;">
                            <p><i class="buttonDelete" style="color:#16a085" >请登录</i></p>
                            <p class="wz_right_world">Lv.0</p>
                            <p class="wz_right_world3">未签到</p>
                        </div>
                    </div>
                    <div style="background:#9B9B9B; width:100%; height:75px;">
                        <div class="wz_right_world2">
                            <p>0</p>
                            <p>动态</p>
                        </div>
                        <div class="wz_right_world2">
                            <p>0</p>
                            <p>关住</p>
                        </div>
                        <div class="wz_right_world2">
                            <p>0</p>
                            <p>粉丝</p>
                        </div>
                    </div>
                </div>
                <%}else{ %>
                
                <div style="width:100%; height:225px;">
                    <div class="wz_right_part_mysef">
                        <img src="WZMusic/images/zxx.jpg" height="150" style="float:left;">
                        <div style="float:left; text-align:center;">
                            <p><a href="#"><%=realName%></a></p>
                            <p class="wz_right_world">Lv.5</p>
                            <p class="wz_right_world3">已签到</p>
                        </div>
                    </div>
                    <div style="background:#9B9B9B; width:100%; height:75px;">
                        <div class="wz_right_world2">
                            <p>0</p>
                            <p>动态</p>
                        </div>
                        <div class="wz_right_world2">
                            <p>10</p>
                            <p>关住</p>
                        </div>
                        <div class="wz_right_world2">
                            <p>20</p>
                            <p>粉丝</p>
                        </div>
                    </div>
                </div>
                <%} %>
                
                
                <div style="width:90%; margin-top:20px;">
                    <div class="wz_right_world4">
                        <span style="font-size:20px;"><a>入驻歌手</a></span>
                        <span class="wz_right_world4_look"><a href="javascript:return false;">查看更多></a></span>
                    </div>
                    <div class="wz_right_world4_singer">
                        <img src="WZMusic/images/zhm.jpg " class="wz_right_world4_singe_pic">
                        <div style="text-align:center; ">
                            <p class="wz_right_world4_singe_name">林俊杰</p>
                            <p>中国流行歌手</p>
                        </div>
                    </div>
                    <div class="row demo-row wz_right_world4_singe_btn">
                        <a href="javascript:return false;" class="btn btn-block btn-lg btn-primary">申请微知音乐人</a>
                    </div>
                </div>

            </div>
        </div>
    </div>
    </div>
    <script src="WZMusic/dist/js/vendor/jquery.min.js "></script>
    <script src="WZMusic/dist/js/vendor/video.js "></script>
    <script src="WZMusic/dist/js/flat-ui.min.js "></script>
    <script src="WZMusic/docs/assets/js/application.js "></script>
    <script src="WZMusic/js/jquery.roll-ad.js "></script>
    <script src="weizhi/htmlframe/plugings/layui/layui.js"
		type="text/javascript"></script>


    <script>
        RollAd.init($('.rollad'));
    </script>

    
    <script type="text/javascript">
    
    var windowIndex ; 
    
    	layui.use(['layer','laypage'], function() {
    		var $=layui.jquery,
    		layer=layui.layer,
    		laypage=layui.laypage;
    		
    		$(".buttonDelete").click(function(){
    		windowIndex = layer.open({
    				type:2,
    				title:'用户登陆',
    				shadeClose:true,
    				area:['420px','70%'],
    				content:'Page/Lands.jsp',
    			});
    		});
    		
    		
    	});
    	
    	
    	function closeWindow(){
    		if(windowIndex!=undefined){
    			layer.close(windowIndex);
    			window.location.reload();
    		}
    	}
    	
    </script>
</body>
</html>
