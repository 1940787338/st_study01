import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

import LoginView from '@/views/LoginView.vue'
import IndexView from '@/views/IndexView.vue'
import TestView from '@/views/TestView.vue'
import NxyjView from '@/views/NxyjView.vue'
//配置路由器规则
const router = new VueRouter({
    routes:[
        {path: '/login', component: LoginView},
        {path: '/', redirect: '/login'},
        {path: '/index', name:'index' , component: IndexView, children:[
            {path: '/index', name:'test', component: TestView},
            {path: '/zzst/nxyj', name:'nxyj', component: NxyjView}
        ]},
        
    ]
})

export default router