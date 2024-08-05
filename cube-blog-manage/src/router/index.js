import Vue from 'vue'
import VueRouter from 'vue-router'
import articleManage from '@/views/articleManage/index.vue'
// import articleForm from '@/views/articleManage/articleForm/index.vue'
// import articleDetail from '@/views/articleManage/articleDetail/index.vue'
import imageManage from '@/views/imageManage/index.vue'
import introManage from '@/views/introManage/index.vue'
import login from '@/views/login/index.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'login',
    component: login,
  },
  {
    path: '/',
    name: 'home',
    component: () => import('../layout'),
    redirect: '/articleManage',
    children: [{
      path: 'articleManage',
      name: 'articleManage',
      component: articleManage,
      meta: {title: '文章管理'},
      // children: [
      //   {
      //     path: 'articleForm',
      //     name: 'articleForm',
      //     component: articleForm,
      //     meta: {title: '文章编辑'}
      //   },
      //   {
      //     path: 'articleDetail',
      //     name: 'articleDetail',
      //     component: articleDetail,
      //     meta: {title: '文章详情'}
      //   },
      // ]
    }]
  },
  {
    path: '/',
    name: 'image',
    component: () => import('../layout'),
    // redirect: '/articleManage',
    children: [{
      path: 'imageManage',
      name: 'imageManage',
      component: imageManage,
      meta: {
        title: '图片管理'
      }
    }]
  },
  {
    path: '/',
    name: 'intro',
    component: () => import('../layout'),
    // redirect: '/articleManage',
    children: [{
      path: 'introManage',
      name: 'introManage',
      component: introManage,
      meta: {
        title: '个人介绍'
      }
    }]
  },
  
]

const router = new VueRouter({
  // mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
