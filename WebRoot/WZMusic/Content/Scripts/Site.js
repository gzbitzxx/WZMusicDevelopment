myFocus.set({
    id: 'focus-content',
    pattern: 'mF_classicHB', //风格应用的名称
    time: 3, //切换时间间隔(秒)
    trigger: 'click', //触发切换模式:'click'(点击)/'mouseover'(悬停)
    txtHeight: 'default', //文字层高度设置(像素),'default'为默认高度，0为隐藏
    width: 266,
    height: 208,
    wrap: false
});

function setCurrentNav(nav) {
    ////           nav = document.getElementById("a");
    //          var list = document.getElementById("nav-list");
    //            var li = list.getElementsByTagName("li");
    //            for (var i = 0; i < li.length; i++) {
    //                li[i].className = "";
    //            }
    //            nav.className = "current-nav";

    $("#nav-list>li").removeClass("current-nav");
    nav.className = "current-nav";
}

function initNav() {
    //            var list = document.getElementById("nav-list");
    //            var li = list.getElementsByTagName("li");
    //            for (var i = 0; i < li.length; i++) {
    //                li[i].onmouseover = function () {
    //                    setCurrentNav(this);
    //                }
    //            }
    $("#nav-list>li").mouseover(function () {
        setCurrentNav(this);
    });
}

$(initNav);