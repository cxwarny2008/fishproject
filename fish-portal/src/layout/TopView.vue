<template>

  <el-col :span="24" class="header">
    <el-col :span="10" class="logo">
    </el-col>
    <el-col :span="10">
      <div class="tools">
        <i class="fa fa-align-justify"></i>
      </div>
    </el-col>
    <el-col :span="4">
      <el-dropdown>
        <span class="el-dropdown-link" >
         <span v-if="loginUser">
           {{loginUser.userName}}
         </span>
          <i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>我的消息</el-dropdown-item>
          <el-dropdown-item>设置</el-dropdown-item>
          <el-dropdown-item divided @click.native="logout">退出登录</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </el-col>
  </el-col>
</template>

<script>
  export default {
    name: "TopView",
    data() {
      return {
        loginUser: JSON.parse(sessionStorage.getItem("user"))
      }
    },
    methods:
      {
        logout: function () {
          sessionStorage.removeItem("user");
          this.$router.push({path: '/login'})
        }
      }
  }
</script>

<style scoped>
  .container {
    position: absolute;
    top: 0px;
    bottom: 0px;
    width: 100%;
  }

  .header {
    height: 60px;
    line-height: 60px;
    color: #fff;
  }

  .userinfo {
    text-align: right;
    padding-right: 35px;
    float: right;
  }

  .userinfo-inner {
    cursor: pointer;
    color: #fff;
  }

  img {
    width: 40px;
    height: 40px;
    border-radius: 20px;
    margin: 10px 0px 10px 10px;
    float: right;
  }

  .logo {
  / / width: 230 px;
    height: 60px;
    font-size: 22px;
    padding-left: 20px;
    padding-right: 20px;
    border-color: rgba(238, 241, 146, 0.3);
    border-right-width: 1px;
    border-right-style: solid;
  }

  img {
    width: 40px;
    float: left;
    margin: 10px 10px 10px 18px;
  }

  .txt {
    color: #fff;
  }

  .logo-width {
    width: 230px;
  }

  .logo-collapse-width {
    width: 60px
  }

  .tools {
    padding: 0px 23px;
    width: 14px;
    height: 60px;
    line-height: 60px;
    cursor: pointer;

  }

  .main {
    display: flex;
  / / background: #324057;
    position: absolute;
    top: 60px;
    bottom: 0px;
    overflow: hidden;
  }

  aside {
    flex: 0 0 230px;
    width: 230px;
  / / position: absolute;
  / / top: 0 px;
  / / bottom: 0 px;
  }

  .el-menu {
    height: 100%;
  }

  .collapsed {
    width: 60px;
  }

  .item {
    position: relative;
  }

  .submenu {
    position: absolute;
    top: 0px;
    left: 60px;
    z-index: 99999;
    height: auto;
    display: none;
  }

  .menu-collapsed {
    flex: 0 0 60px;
    width: 60px;
  }

  .menu-expanded {
    flex: 0 0 230px;
    width: 230px;
  }

  .content-container {
  / / background: #f1f2f7;
    flex: 1;
  / / position: absolute;
  / / right: 0 px;
  / / top: 0 px;
  / / bottom: 0 px;
  / / left: 230 px;
    overflow-y: scroll;
    padding: 20px;
  }

  .breadcrumb-container {
  / / margin-bottom: 15 px;
  }

  .title {
    width: 200px;
    float: left;
    color: #475669;
  }

  .breadcrumb-inner {
    float: right;
  }

  .content-wrapper {
    background-color: #fff;
    box-sizing: border-box;
  }
</style>
