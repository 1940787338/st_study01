import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

import LoginView from '@/views/LoginView.vue'
//配置路由器规则
const router = new VueRouter({
    routes:[
        {path: '/login', component: LoginView},
        {path: '/', redirect: '/login'}
    ]
})

export default router