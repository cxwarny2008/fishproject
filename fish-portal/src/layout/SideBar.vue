<template>
  <el-menu :default-active="$route.path">
    <template v-for="(item,index) in $router.options.routes" v-if="!item.hidden">
      <el-submenu :index="index+''" v-if="!item.hidden && item.name">
        <template slot="title"><i :class="item.iconCls"></i>{{item.name}}
        </template>
        <el-menu-item @click="$router.push(child.path)" v-for="child in item.children" :index="child.path"
                      :key="child.path">{{child.name}}
        </el-menu-item>
      </el-submenu>
    </template>
  </el-menu>
</template>
<script>
  export default {
    name: "SideBar"
  }
</script>
<style scoped>

</style>
