/*
    Logic：
        主要采用原生 JavaScript，
        只有在发送 Ajax 请求是才使用 JQuery
    
    ===
    1、登录注册页面的切换逻辑

    2、Ajax发送及接受响应逻辑
    ===
*/


// 封装选择器, 采用ES6箭头函数写法
const getSelector = ele => {
    return typeof ele === "string" ? document.querySelector(ele) : "";
}


// 登录注册载入

const containerShow = () => {
    var show = getSelector(".container")
    show.className += " container-show"
}


window.onload = containerShow;


// 登录注册页切换
((window, document) => {

    // 登录 -> 注册
    let toSignBtn = getSelector(".toSign"),
        toLoginBtn = getSelector(".toLogin")
    loginBox = getSelector(".login-box"),
        signBox = getSelector(".sign-box");

    toSignBtn.onclick = () => {
        loginBox.className += ' animate_login';
        signBox.className += ' animate_sign';
    }

    toLoginBtn.onclick = () => {
        loginBox.classList.remove("animate_login");
        signBox.classList.remove("animate_sign");
    }


})(window, document);



// Ajax 请求发送
<!--点击登录与注册按钮时发送相应的请求-->
// function sendLoginRequest() {
//
//     var username = document.getElementById("login-user").value.toString();
//
//     var password = document.getElementById("login-password").value.toString();
//
//     $.ajax({
//         url: "http://localhost:8080/user/login",
//         data: {
//             username: username,
//             password: password
//         },
//         type: "get",
//         dataType: "text",
//         success: function (result) {
//             console.log(result)//如何发送成功
//             window.open(result.result);
//             // $("#message").html(html); //在html页面id=ulul的标签里显示html内容
//         }, error: function () {
//             console.log("error")
//         },
//         complete: function () {
//             console.log("complate")
//         }
//     });
// }
//
// function sendRegisterRequest() {
//     var username = document.getElementById("sign-user");
//
//     var password = document.getElementById("sign-password");
//
//     $.ajax({
//         url: "http://localhost:8080/user/register",
//         data: {
//             username: username,
//             password: password
//         },
//         type: "get",
//         dataType: "json"
//
//     });
// }
