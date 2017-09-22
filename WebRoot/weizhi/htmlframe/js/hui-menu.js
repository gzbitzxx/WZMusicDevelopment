/**
 * Created by Administrator on 2017/3/28.
 */

$(function () {

    var nice=$('.hui-slide-menu').niceScroll('',{
        cursorcolor: "#044F67",//#CC0071 光标颜色
        cursoropacitymax: 1, //改变不透明度非常光标处于活动状态（scrollabar“可见”状态），范围从1到0
        touchbehavior: false, //使光标拖动滚动像在台式电脑触摸设备
        cursorwidth: "4px", //像素光标的宽度
        zindex: "5", // 改变滚动条的DIV的z-index值
        cursorborder: "0", //     游标边框css定义
        cursorborderradius: "2px",//以像素为光标边界半径
        autohidemode: false,//是否隐藏滚动条
        hwacceleration: true,// 激活硬件加速
        nativeparentscrolling: true // 检测内容底部便于让父级滚动
    });

    //将默认打开项打开
    var open=$(".hui-slide-menu>li>ul").hasClass('hui-menu-open');
       if(open){
           $(".hui-slide-menu>li>ul[class='hui-slide-menu-item hui-menu-open']").slideDown();
       }

   $(".hui-slide-menu>li>a").click(function () {
       var menu_item=$(this).parent().find('>ul');
       if(menu_item!=undefined&&menu_item.length>0){
           menu_open($(this));
       }

       console.log("menu-wight:",$('.hui-slide-menu').height());
       console.log("container-wight:",$('.hui-left-slide-container').height());
   })

    $(".hui-slide-menu-item>li>a").click(function () {
        var menu_item=$(this).parent().find('>ul');

        if(menu_item!=undefined&&menu_item.length>0){
            menu_open($(this));
        }else {
            console.log("啥都没有");
        }
    })


    //打开菜单
    function menu_open(element) {

        var parent=element.parent();
        var child=parent.find('>ul').hasClass('hui-menu-open');
        var tag=parent.find('>a>span');
        var flg=true;
        $('.hui-slide-menu').getNiceScroll().resize();
        //如果包含hui-menu-open说明状态是打开的，就将其关闭
        if(child){
            parent.find('>ul').slideUp();
            parent.find('>ul').removeClass('hui-menu-open');
            tag.attr('class','fa fa-angle-right');
        }else {
            parent.find('>ul').addClass('hui-menu-open');
            tag.attr('class','fa fa-angle-down');
            parent.find('>ul').slideDown();
        }

        return flg;
    }

});
