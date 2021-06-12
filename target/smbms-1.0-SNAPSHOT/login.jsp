<%@ page language="java" contentType="text/html; chaeset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 --聚旺福超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <script type="text/javascript">
    </script>
</head>

<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>聚旺福超市订单管理系统</h1>
        </header>
        <section class="loginCont">
            <form class="loginForm" action="jsp/frame.jsp"  name="actionForm" id="actionForm"  method="post" >
                <div class="info"></div>
                <div class="inputbox">
                    <label for="user">用户名：</label>
                    <input type="text" class="input-text" id="userCode" name="userCode" placeholder="请输入用户名"/>
                </div>
                <div class="inputbox">
                    <label for="mima">密码：</label>
                    <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码"/>
                </div>
                <div class="subBtn">

                    <input type="button" id="login" value="登录"/>
                    <input type="reset" value="重置"/>
                </div>
            </form>
        </section>
    </section>
</body>
</html>