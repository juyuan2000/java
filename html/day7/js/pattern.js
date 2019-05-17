window.onload = function () {
    var bt = document.getElementById("bT");
    bt.onclick = function () {
        checkChiese()
    };
}

function checkChiese(){
 // alert(666);
 var txt = document.getElementById("txt1").value;
 pattern = /^[\u4E00-\u9FA5]+$/;
 result = pattern.test(txt);
 alert(result);
if (!result){
    s=document.createElement(lable);
    s.value="你的输入有误";
    alert(s);
    // s.style.color = red;
    this.parentNode.appendChild(s);
    // this.parentNode.appendChild(s);+
}
}