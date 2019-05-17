function set_time1(){
    s = get_time();
    document.getElementById("t1").innerHTML = s;
    t = setTimeout("set_time1()",1000);
}

function end_time(){
    clearTimeout(t);
}