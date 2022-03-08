import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';//引入elementui
import 'element-ui/lib/theme-chalk/index.css';
import VueRouter from 'vue-router'	// 引入VueRouter
import router from './router/main'				// 引入路由器
import VueCoreVideoPlayer from 'vue-core-video-player'//引入视频播放器
import store from './store'
Vue.use(VueCoreVideoPlayer)
import axios from 'axios';
Vue.prototype.$axios = axios;
Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueRouter);
//引入音乐播放器组件
import APlayer from '@moefe/vue-aplayer'
Vue.use(APlayer, {
    defaultCover: 'http://codexx.cc/usr/themes/pure/images/random/bg3.jpg',
    productionTip: false,
    autoplay:false
});
// 添加请求拦截器，在请求头中加token
axios.interceptors.request.use(  config => {   
  if (localStorage.getItem('token'))
   {      
      config.headers.Authorization = localStorage.getItem('token');    
   }    
  return config;  },  
  error => { return Promise.reject(error);  
});
new Vue({
  render: h => h(App),
  router,
  store
}).$mount('#app')

