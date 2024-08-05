<template>
    <div class="login">
        <div class="bg">
            <img src="@/assets/imgs/login.jpg" alt="">
        </div>
        <el-form class="loginForm">
            <div class="title">
                <h3>登录</h3>
            </div>
            <el-form-item>
                <el-input placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item>
                <el-input placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-button type="primary" class="loginButton">登录</el-button>
        </el-form>
    </div>
</template>

<script>
export default {
    name:'',
    data() {
        return {

        };
    },
    methods: {
        
    }
};
</script>

<style scoped lang="less">
    .login {
        // width: 100%;
        // min-height: 100%;
        // background: url('@/assets/imgs/login.jpg');
        // background-size: 100% 100%;
        // object-fit: cover;
        // background-repeat: no-repeat;
        // position: relative;

        .bg {
            img {
                width: 100%;
                height: 100vh;
                object-fit: cover;
                position: absolute;
                z-index: -1;
            }
        }

        .loginForm {
            width: 520px;
            margin: 0 auto;
            padding-top: 160px;


            .title {
                color: #fff;
                text-align: center;
                margin-bottom: 40px;
                font-size: 25px;
                letter-spacing: 10px;
            }

            .el-input {
                height: 47px;
                width: 85%;
            }

            .loginButton {
                width: 85%;
            }
        }
    }
</style>
