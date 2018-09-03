<template>
  <el-form class="login-container" :model="loginForm" :rules="loginRules" ref="loginForm">
    <h3 class="title">系统登录</h3>
    <el-form-item label="账户:" prop="userId">
      <el-input type="text" v-model="loginForm.userId" auto-complete="off" placeholder="账号">
      </el-input>
    </el-form-item>
    <el-form-item label="密码:" prop="password">
      <el-input type="password" v-model="loginForm.password" placeholder="密码"></el-input>
    </el-form-item>
    <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox>
    <el-form-item style="width:100%;">
      <el-button type="primary" style="width:100%;" @click.native="login">登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  export default {
    name: "login",
    data() {
      return {
        loginForm: {
          userId: null,
          password: null,
        },
        checked: false,
        loginRules: {
          userId: [{required: true, message: '请输入姓名', trigger: 'blur'}],
          password: [{required: true, trigger: 'blur', message: "请输入密码！"}]
        }
      }
    },
    methods: {
      login: function () {
        var self = this;
        this.$refs.loginForm.validate((valid) => {
          if (!valid) {
            return;
          }
          var loginUser = JSON.parse(JSON.stringify(this.loginForm));
          this.$axios.post("user/login", loginUser).then(function (response) {
            sessionStorage.setItem('user', JSON.stringify(response.data));
            self.$router.push({path: '/person'})
          });
        });
      }
    }
  }
</script>

<style scoped>
  .login-container {
    /*box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);*/
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

  .remember {
    margin: 0px 0px 35px 0px;
  }

</style>
