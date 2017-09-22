
layui.use(['element','layer'], function(){
    var $ = layui.jquery,
        element = layui.element(),//Tab的切换功能，切换事件监听等，需要依赖element模块
        layer=layui.layer;

    //禁止主页tab被关闭
    $(".first i").remove();

    changColor();

    var tabContent=$(".layui-tab-content").eq(0);


    $(".hui-left-slide-container .hui-slide-menu li a").click(function(){


            var url=$(this).attr("url");
            var id=$(this).attr("tab-id");
            var iframe=$(".layui-tab-content").find('iframe[src-id='+id+']');
            var iframes=$(".layui-tab-content iframe");
            var tabIndex=iframes.length;
            var title=$(this).text();
            console.log(url+":"+id);
            var isLogin;

            if(id!=undefined&&id!=null&&url!=undefined&&url!=null){

                layer.load();
                setTimeout(function() {
                    layer.closeAll('loading');
                }, 300);

                $.ajax({
                    url:"/management/isLogin",
                    type:"post",
                    success:function (data) {
                        if(data.status==undefined||data.status!=true){
                            console.log(data.status);
                            window.location.reload();
                        }
                    }
                })

                if(iframe.length){
                    tabIndex=iframe.attr('tab-index');
                }else {


                    element.tabAdd("tab-filter",{
                        title:title,
                        content:'<iframe src='+url+' src-id='+id+' style="width: 100%; border: 0px;" tab-index='+tabIndex+'></iframe>'
                    })

                }

            }

            element.tabChange('tab-filter',tabIndex);
            changeSize();
    });



    //监听tab选项卡切换
    element.on('tab(tab-filter)', function(data){
        //禁止首页选项卡被关闭
        $(".first i").remove();
        changColor();
    });



    //iframe自适应高度
    $(window).resize(function() {
        changeSize();
    }).resize();


    $("#hui-top-menu").click(function(){

        var rightContent=$(".hui-right-container");
        var leftSide=$('.hui-left-slide-container');
        var footer=$('.hui-frame-footer');

        if($(this).attr('data-open')=='true'){
            rightContent.animate({left:'0px'},400,function(){
                rightContent.css('padding-left','0px');
            });

            footer.animate({left:'0px'},400);

            $(this).attr('data-open','false');
        }else {

           rightContent.animate({left:'250px'},400,function(){
                rightContent.css('padding-left','2px');
            });


            footer.animate({left:'250px'},400);

            $(this).attr('data-open','true');
        }



    });


    //自适应iframe高度
    function changeSize(){

        //禁止首页选项卡被关闭
        $(".first i").remove();

        //设置顶部切换卡容器度
        tabContent.height($(window).height()-52- 40-45); //头部高度 顶部切换卡标题高度 底部高度
        //设置顶部切换卡容器内每个iframe高度
        tabContent.find('iframe').each(function (index,element) {
            $(element).height(tabContent.height());
        });
    }

    //改变当前打开的tab的背景色与颜色
    function changColor(){
        var tab=$(".layui-tab-title .layui-this");
        var tabTitle=$(".layui-tab-title li");

        tabTitle.css('background','#FAFAFA');
        tabTitle.css('color','#1CC09F');

        tab.css('background','#1CC09F');
        tab.css('color','white');

        tabTitle.css('border','solid 1px #F3F3F4');
    }

});



