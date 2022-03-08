import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
export default new Vuex.Store({
  state: {
    state:localStorage.getItem('state') ? localStorage.getItem('state') : '',//存储当前的登陆状态
    token:localStorage.getItem('token') ? localStorage.getItem('token') : '',//存储当前登录的token
    uid:localStorage.getItem('uid') ? localStorage.getItem('uid') : '',//存储当前的登录的用户uid
    mid:JSON.parse(localStorage.getItem('mid')) ? JSON.parse(localStorage.getItem('mid')) : '',
    user:JSON.parse(localStorage.getItem('user')) ? JSON.parse(localStorage.getItem('user')) : '',
    type:JSON.parse(localStorage.getItem('type')) ? JSON.parse(localStorage.getItem('type')) : '',//歌曲类型中的歌曲数据本地化
    mv:JSON.parse(localStorage.getItem('mv')) ? JSON.parse(localStorage.getItem('mv')) : '',
    mlist:JSON.parse(localStorage.getItem('mlist')) ? JSON.parse(localStorage.getItem('mlist')) : '',
    sheetlist:JSON.parse(localStorage.getItem('sheetlist')) ? JSON.parse(localStorage.getItem('sheetlist')) : '',
    search:JSON.parse(localStorage.getItem('search')) ? JSON.parse(localStorage.getItem('search')) : ''
  },
  mutations: {
    //token，state，uid设置方法
    setstate(state,data){
     state.state=data.state,
     state.token=data.token,
     state.uid=data.uid,
     state.user=data.user
     localStorage.setItem('state',data.state),
     localStorage.setItem('token',data.token),
     localStorage.setItem('uid',data.user.uid),
     localStorage.setItem('user',JSON.stringify(data.user))
    },
    //歌曲类型的歌曲数据设置方法
    settype(state,data)
    {
        state.type=data,
        localStorage.setItem('type',JSON.stringify(data))
    },
    //当前播放的mv数据存储方法
    setmv(state,data)
    {
        state.mv=data,
        localStorage.setItem('mv',JSON.stringify(data))
    },
    //退出登录修改vuex与缓存数据
    logoutx(state,data)
    {
        state.state=data,
        state.token=data,
        state.uid=data,
        state.mlist=data,
        localStorage.setItem('state',data),
        localStorage.setItem('token',data),
        localStorage.setItem('uid',data),
        localStorage.setItem('user',data),
        localStorage.setItem('mlist',data)
    },
    setmlist(state,data)
    {
      state.mlist=data,
      localStorage.setItem('mlist',JSON.stringify(data))
    },
    setmid(state,data)
    {
      state.mid=data,
      localStorage.setItem('mid',JSON.stringify(data))
    },
    setsheetlist(state,data)
    {
      state.sheetlist=data,
      localStorage.setItem('sheetlist',JSON.stringify(data))
    },
    setsearch(state,data)
    {
      state.search=data,
      localStorage.setItem('search',JSON.stringify(data))
    }
  }
})
