function get_time(){
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth();
    var day = d.getDay();
    var hour = d.getHours();
    var minute = d.getMinutes();
    if (minute<10) {
        minute = "0" + minute;
    }
    var second = d.getSeconds();
    if (second<10){
        second = "0" + second;
    }   
    s = year + '-' + month + '-' + day + ' '+ hour +":"+ minute +":"+ second
    return s;    
}