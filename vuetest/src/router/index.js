import Vue from 'vue'
import VueRouter from 'vue-router'
import User from "../views/User";
import PageTwo from "../views/PageTwo";
import PageThree from "../views/PageThree";
import PageFour from "../views/PageFour";
import App from "../App";
import Index from "../views/index";
import AddUser from "../views/AddUser";
import UserTest from "../views/UserTest";

Vue.use(VueRouter)

const routes = [
  {
    path:"/",
    name:"用户",
    component: Index,
    redirect:"/User",
    children:[
      {
        path:"/User",
        name:"职员信息",
        component: User
      },
      {
        path:"/UserTest",
        name:"职员信息test",
        component: UserTest
      },{
      path: "/AddUser",
        name: "添加用户",
        component: AddUser
      },
      {
        path:"/PageTwo",
        name:"页面二",
        component: PageTwo
      }
    ]
  },
  {
    path:"/navigation",
    name:"导航二",
    component:Index,
    children:[
      {
        path:"/pageThree",
        name:"页面3",
        component: PageThree
      },
      {
        path:"/PageFour",
        name:"页面4",
        component: PageFour
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
