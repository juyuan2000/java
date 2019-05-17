function getTime () {
    // 得到时间数字
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth()+1;
    var day = d.getDate();
    var h = d.getHours();
    var m = d.getMinutes();
    var s = d.getSeconds();
    // 修改分秒的时间格式
    if( s<10 ) {
        s = "0" + s;
    }
    if (m<10) {
        m = "0" + m;
    }

    return "" + year + "-" + month + "-" + day+ " " + h +":" + m+":" +s; 
}

function start(){
    // alert(document.getElementById("d"));
    document.getElementById("d").innerText = getTime();
    setTimeout("start()",1000)
    
}

window.onload = function () {
    // window.alert(getTime
    start();
}