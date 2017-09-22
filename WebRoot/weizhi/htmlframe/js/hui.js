/**
 * Created by Administrator on 2017/2/25.
 */


//面板的展开与移除
layui.use('element',function(){

    var $=layui.jquery;

    $(".hui-panel-change a").click(function(){
        var by=$(this).parent().parent().parent().parent();
        by.find('.hui-panel-body').slideToggle();

        console.log("test:",by.find('.hui-panel-body'));

        var open=$(this).parent();

        if(open.attr('data-open')=='true'){
            open.attr('data-open','false');
            $(this).find('i').attr('class','iconfont icon-gobottom');
        }else {
            open.attr('data-open','true');
            $(this).find('i').attr('class','iconfont icon-gotop');
        }

       var footer= by.find('.hui-panel-footer');

        if(footer!=undefined&&footer!=null){
            footer.slideToggle();
        }

    });

    $('.hui-panel-close a').click(function(){

        var by=$(this).parent().parent().parent().parent();
        by.remove();
    });


});





