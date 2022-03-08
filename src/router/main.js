import VueRouter from "vue-router";
// 引入组件
//用户编辑组件
import UserEdit from "../page/UserEdit.vue";
//用户注册组件
import UserRegister from "../page/UserRegister.vue";
//用户登录组件
import UserLogin from "../page/UserLogin.vue";
//网站首页组件包含歌曲推荐与歌单推荐
import MusicIndex from "../page/MusicIndex.vue";
//歌曲类型组件
import MusicSort from "../page/MusicSort.vue";
//歌单组件
import MusicSheet from "../page/MusicSheet.vue";
//mv播放组件
import MvSingle from "../page/MvSingle.vue";
//创建歌单组件
import NewSheet from "../page/NewSheet.vue";
//搜索组件
import MusicSearch from "../page/MusicSearch.vue";
// 创建并暴露一个路由器
export default new VueRouter({
  routes: [
    {
      path: "/",
      component: MusicIndex,
    },
    {
      path: "/login",
      component: UserLogin,
    },
    {
      path: "/register",
      component: UserRegister,
    },
    {
      path: "/edit",
      component: UserEdit,
    },
    {
      path: "/sort",
      component: MusicSort,
    },
    {
      path: "/sheet",
      component: MusicSheet,
    },
    {
      path: "/mv",
      component: MvSingle,
    },
    {
      path: "/edit",
      component: UserEdit,
    },
    {
      path: "/newsheet",
      component: NewSheet,
    },
    {
      path: "/search",
      component: MusicSearch,
    },
  ],
});
