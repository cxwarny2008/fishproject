<template>
  <el-container>
    <el-header>
      <topView>
      </topView>
    </el-header>
    <el-container>
      <el-aside>
        <sideBar></sideBar>
      </el-aside>
      <el-container>
        <el-main>
          <transition name="fade" mode="out-in">
            <router-view></router-view>
          </transition>
        </el-main>
      </el-container>
    </el-container>
  </el-container>
</template>

<script>
  import sideBar from './SideBar.vue';
  import topView from './TopView.vue';

  export default {
    name: "layout",
    components: {
      topView, sideBar
    }
  }
</script>

<style scoped>

</style>
