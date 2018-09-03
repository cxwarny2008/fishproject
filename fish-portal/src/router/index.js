import Vue from 'vue'
import Router from 'vue-router'
import layout from '@/layout/layout.vue'
import person from '@/views/person/index.vue'
import add_person from '@/views/person/addPerson.vue'
import login from '@/views/login.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/', redirect: '/person'},

    {
      path: '/',
      name: '人员管理',
      component: layout,
      children: [
        {path: '/person', component: person, name: '人员信息', meta: {requireAuth: true}},
        {path: '/addperson', component: add_person, name: '新增人员', meta: {requireAuth: true}}
      ]
    },
    {
      path: '/login',
      name: '登录',
      component: login,
      hidden: true,
      meta: {requireAuth: false}
    }
  ]
})
