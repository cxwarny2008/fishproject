// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(Element);
Vue.config.productionTip = false

axios.defaults.baseURL = 'http://localhost:59129/'
axios.defaults.headers.common['Content-Type'] = 'application/json;charset=UTF-8'

Vue.prototype.$axios = axios;
/* eslint-disable no-new */

router.beforeEach((to, from, next) => {
  var login = sessionStorage.getItem("user");
  if (to.meta.requireAuth) {  // 判断该路由是否需要登录权限
    if (login) {  // 通过vuex state获取当前的token是否存在
      next();
    }
    else {
      next({
        path: '/login',
        query: {redirect: to.fullPath}  // 将跳转的路由path作为参数，登录成功后跳转到该路由
      })
    }
  }
  else {
    next();
  }
})

axios.interceptors.request.use(
  config => {
    config.headers['token'] = "token"
    return config
  }, function (error) {
    return Promise.reject(error)
  }
)

new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})

