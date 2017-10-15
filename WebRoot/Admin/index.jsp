<%@page import="com.wz.dto.AdminDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>微知后台管理</title>
<link href="weizhi/htmlframe/plugings/layui/css/layui.css"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="weizhi/htmlframe/plugings/bootstrap/css/site.min.css" />
<link rel="stylesheet"
	href="weizhi/htmlframe/plugings/bootstrap/css/bootstrap.min.css" />
<link rel="shortcut icon" href="WZMusic/img/favicon.ico">
<link rel="stylesheet"
	href="weizhi/htmlframe/iconfont/font-awesome-4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="weizhi/htmlframe/style/hui.css" />
</head>
<%
	request.setCharacterEncoding("utf-8");
	HttpSession hs = request.getSession();
	AdminDto admin=(AdminDto)hs.getAttribute("admin");
	String name=null;
	if(admin!=null){
		name = admin.getRealName();
	}
	
%>
<body>
    <div class="hui-top-nav">
        <!-- logo -->
        <div class="hui-top-nav-logo">
            微知后台管理
        </div>
        <div style="position: absolute;left: 256px;height: 50px;line-height: 50px;">
            <button class="layui-btn layui-btn-small" style="background: #314555;margin-top:8px;" id="hui-top-menu" data-open="true"><i class="fa fa-bars"></i></button>
        </div>
        <!--管理员开始-->
        <ul class="hui-top-nav-right-usr">
            <li class="dropdown">
                <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#" id="dLabel">
                    <i class="iconfont icon-touxiang"></i><%=name%>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                    <li role="presentation ">
                        <a href="#">
                            <i class="fa fa-user"></i> 个人信息
                        </a>
                    </li>
                    <li role="presentation ">
                        <a href="exitLogin">
                            <i class="iconfont icon-jinru"></i> 注销
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
        <!--管理员结束-->
    </div>
    <div class="hui-left-slide-container">
        <ul class="hui-slide-menu">
            <li>
                <a href="#" url="weizhi/htmlframe/Admin/echarts.html" tab-id="0">
                    <i class="fa fa-bar-chart"></i> 统计台
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-plus"></i> 音乐类型管理
                    <span class="fa fa-angle-right"></span>
                </a>
                <ul class="hui-slide-menu-item">
                    <li>
                        <a href="#" url="Admin/MusicType/AddMusicType.jsp" tab-id="150" >
                            添加类型
                        </a>
                    </li>
                    <li>
                        <a href="#" url="musicType" tab-id="10">
                            类型列表
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-plus"></i>自创音乐类型管理
                  <span class="fa fa-angle-right"></span>
                </a>
                <ul class="hui-slide-menu-item">
                    <li>
                        <a href="#" url="addMyMusicTypeMU" tab-id="200">
                            添加我的音乐类型
                        </a>
                    </li>
                    <li>
                        <a href="#" url="listMyMusicType" tab-id="119">
                            我的音乐类型列表
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-music"></i> 音乐管理
                  <span class="fa fa-angle-right"></span>
                </a>
                <ul class="hui-slide-menu-item">
                    <li>
                        <a href="#" url="addMusicMTY" tab-id="2">
                            添加音乐
                        </a>
                    </li>
                    <li>
                        <a href="#" url="listMusic" tab-id="11">
                            音乐列表
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-book"></i> 文章管理
                   <span class="fa fa-angle-right"></span>
                </a>
                <ul class="hui-slide-menu-item">
                    <li>
                        <a href="#" url="addArticleMU" tab-id="3">
                            添加文章
                        </a>
                    </li>
                    <li>
                        <a href="#" url="listArticle" tab-id="13">
                            文章列表
                        </a>
                    </li>
                </ul>
            </li>
             <li>
                <a href="#">
                    <i class="fa fa-commenting"></i> 评论管理
                    <span class="fa fa-angle-right"></span>
                </a>
                <ul class="hui-slide-menu-item">
                    <li>
                        <a href="#" url="addCommentMU"  tab-id="4">
                            添加评论
                        </a>
                    </li>
                    <li>
                        <a href="#" url="listComments" tab-id="14">
                            评论列表
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-user"></i> 管理员管理
                    <span class="fa fa-angle-right"></span>
                </a>
                <ul class="hui-slide-menu-item">
                    <li>
                        <a href="#" url="Admin/Admins/AddAdmin.jsp"  tab-id="71">
                            添加管理员
                        </a>
                    </li>
                    <li>
                        <a href="#" url="admin" tab-id="21">
                            管理员列表
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#">
                    <i class="fa fa-address-book"></i> 用户管理
                    <span class="fa fa-angle-right"></span>
                </a>
                <ul class="hui-slide-menu-item">
                    <li>
                        <a href="#" url="Admin/User/AddUser.jsp" tab-id="1">
                            添加用户
                        </a>
                    </li>
                    <li>
                        <a href="#" url="user" tab-id="31">
                            用户列表
                        </a>
                    </li>
                </ul>
            </li>
            <!--三级联动的范例开始-->
            <li>
                <a href="#">
                    <i class="fa fa-wrench"></i> 三级菜单
                    <span class="fa fa-angle-right"></span>
                </a>
                <ul class="hui-slide-menu-item">
                    <li>
                        <a href="#">
                            第三级菜单
                            <span class="fa fa-angle-right"></span>
                        </a>
                        <ul>
                            <li>
                                <a href="#">三级子菜单</a>
                            </li>
                            <li>
                                <a href="#">三级子菜单</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                           三级中的二级
                        </a>
                    </li>
                </ul>
            </li>
            <!--三级联动的范例结束-->
        </ul>
    </div>
    <div class="hui-right-container">
        <div class="layui-tab  layui-tab-card" style="margin-top: 2px;background: whitesmoke;" lay-filter="tab-filter" lay-allowclose="true">
            <ul class="layui-tab-title" style="background: #FAFAFA;margin: 0px;">
                <li class="layui-this first">主页</li>
            </ul>
            <div class="layui-tab-content" style=" margin-top:5px;padding: 0px;">
                <div class="layui-tab-item layui-show">
                    <iframe src="weizhi/htmlframe/Admin/echarts.html" src-id="0" name="iframe_a" style="width: 100%; border: 0px;" tab-index="0"></iframe>
                </div>
            </div>
        </div>
    </div>
    <div class="hui-frame-footer">
        Copyright © 2017 <a href="#" target="_blank">微知音乐</a> Powered by 幸福摩天轮
    </div>
    <script src="weizhi/htmlframe/plugings/layui/layui.js" type="application/javascript"></script>
    <script src="weizhi/htmlframe/plugings/scroll/jquery-2.1.1.min.js" type="application/javascript"></script>
    <script src="weizhi/htmlframe/plugings/bootstrap/js/bootstrap.min.js" type="application/javascript"></script>
    <script src="weizhi/htmlframe/js/hui-menu.js" type="application/javascript"></script>
    <script src="weizhi/htmlframe/plugings/scroll/jquery.nicescroll.min.js" type="application/javascript"></script>
    <script src="weizhi/htmlframe/js/main.js" type="application/javascript"></script>
</body>

</html>