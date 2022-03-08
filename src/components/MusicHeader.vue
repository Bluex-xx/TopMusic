<template>
  <div class="header">
      <div class="logo">
    <svg width="100%" height="83">
    <text text-anchor="middle" x="50%" y="50%" class="text text-1">
        TopMusic
    </text>
    <text text-anchor="middle" x="50%" y="50%" class="text text-2">
        TopMusic
    </text>
    <text text-anchor="middle" x="50%" y="50%" class="text text-3">
        TopMusic
    </text>
    <text text-anchor="middle" x="50%" y="50%" class="text text-4">
        TopMusic
    </text>
    </svg> 
    </div>
     <div class="musicsort">
      <el-menu :default-active="user.activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" background-color="#f9fbfd" router=true>
      <el-menu-item index="/">HOME</el-menu-item>
      <el-submenu index="1">
      <template slot="title">歌曲类型</template>
      <el-menu-item v-for="item in type" :key="item" @click="typeupdata(item.musicList)" index="/sort">{{item.style}}</el-menu-item>
      </el-submenu>
      <el-submenu index="2" :disabled="!state">
      <template slot="title">我的歌单</template>
      <el-menu-item index="/newsheet">创建歌单</el-menu-item>
      <el-menu-item v-for='item in sheet' :key='item.mid' @click="updatamid(item.mid)" index="/sheet">{{item.value}}</el-menu-item>
      </el-submenu>
      </el-menu>
     </div>
     <div class="search">
       <el-input
       placeholder="请输入内容"
       v-model="searchinput">
       <i @click="search" slot="prefix" class="el-input__icon el-icon-search"></i>
       </el-input>
     </div>
      <div class="logout">
              <div v-if="state">
        <router-link to="/">
         <button @click="logout"> 退出
        </button>
      </router-link>
      </div>
      </div>
      <el-row>
        <div v-if="!state">
        <router-link to="/login">
         <button> Login
        </button>
         </router-link>
          </div>
          <div v-if="state">
        <router-link to="/edit">
         <button> Edit
        </button>
      </router-link>
      </div>

      </el-row>
  </div>
</template>

<script>
import {mapMutations} from 'vuex';
import axios from 'axios'
export default {
   name:'MusicHeader',
   data() {
    return {
      user:{
        activeIndex:localStorage.getItem('key') ? localStorage.getItem('key'):'/'//导航下标保存
      },
      state:localStorage.getItem('state'),
      type:'',
      sortIndex:'',
      uid:'',
      searchinput:''
    }
  },
   methods:{
      ...mapMutations(["settype"]),
      ...mapMutations(["logoutx"]),
      ...mapMutations(["setmid"]),
      ...mapMutations(["setsheetlist"]),
      handleSelect(key) {
        localStorage.setItem('key',key)
      },
      typeupdata(data){
        this.settype(data);
        this.$router.push(`/sort`)
      },
      logout(){
        this.logoutx('')
      },
      updatamid(data)
      {
        let uid=localStorage.getItem('uid')
        axios.post('/api/dlall/findbymid',{mid:data,uid}).then(
        Response => {
        this.setmid(Response.data)
        },
        error =>{
        console.log(error.message)
        }
        )
      },
      search()
      {
        let name=this.searchinput
        axios.post('/api/music/search',{name:name}).then(
        Response => {
        this.$store.commit('setsearch',Response.data);
        this.$router.push('/search')
        },
        error =>{
        console.log(error.message)
        }
        )
      }
  },
   created(){
     //获取所有歌曲分类，以及各个分类下的歌曲数据
      let uid=localStorage.getItem('uid')
      axios.post('/api/music/findall').then(
      Response => {
         this.type=Response.data
      },
      error =>{
        console.log(error.message)
      }
    ),
    axios.post('/api/mlist/listall',{uid}).then(
       Response => {
         this.setsheetlist(Response.data)
      },
      error =>{
        console.log(error.message)
      }
    )
   },
    computed:{
      getState(){
        return this.$store.state.state;
      },
      sheet()
      {
        return this.$store.state.sheetlist
      },
    },
    //监测vuex的数据变化，并更新数据
    watch:{
      getState(){
        let uid=localStorage.getItem('uid')
       this.state=this.$store.state.state,
       axios.post('/api/mlist/listall',{uid}).then(
       Response => {
         this.setsheetlist(Response.data)
      },
      error =>{
        console.log(error.message)
      }
    )
      }
    }
}
</script>
<style scoped>
.header
{
  height: 60px;
  width: 100%;
  display: flex;
  background: #f9fbfd;
  box-shadow: 0 2px 4px rgb(243 199 199 / 12%), 0 0 6px rgb(0 0 0 / 4%);
  position: relative;
}
.logo
{
  margin: 0 47px;
  width:160px;
}
.text{
    font-size: 28px;
    font-weight: bold;
    text-transform: uppercase;
    fill: none;
    stroke-width: 2px;
    stroke-dasharray: 90 310;
    animation: stroke 6s infinite linear;
}
.text-1{
    stroke: #3498db;
    text-shadow: 0 0 5px #3498db;
    animation-delay: -1.5s;
}
.text-2{
    stroke: #409EFF;
    text-shadow: 0 0 5px #409EFF;
    animation-delay: -3s;
}
.text-3{
    stroke: #3a83c2e0;
    text-shadow: 0 0 5px #3a83c2e0;
    animation-delay: -4.5s;
}
.text-4{
    stroke: #5393cab8;
    text-shadow: 0 0 5px #5393cab8;
    animation-delay: -6s;
}

@keyframes stroke {
  100% {
    stroke-dashoffset: -400;
  }
}

.el-row
{
  margin-top:10px;
  position: absolute;
  right:47px;
}
.el-menu
{
  margin-left: 0px;
}
.el-menu-item
{
  height: 100%;
}
button,
button::after {
 padding: 12px 18px;
 font-size: 16px;
 background: linear-gradient(90deg, transparent 5%, #3a83c2e0 5%);
 border: 0;
 color: #fff;
 letter-spacing: 4px;
 line-height: 1;
 box-shadow: 6px 0px 0px #5393cab8;
 border-radius: 6px;
 outline: transparent;
 position: relative;
}

button::after {
 --slice-0: inset(50% 50% 50% 50%);
 --slice-1: inset(80% -6px 0 0);
 --slice-2: inset(50% -6px 30% 0);
 --slice-3: inset(10% -6px 85% 0);
 --slice-4: inset(40% -6px 43% 0);
 --slice-5: inset(80% -6px 5% 0);
 content: "TopMusic";
 display: block;
 position: absolute;
 top: 0;
 left: 0;
 right: 0;
 bottom: 0;
 background: linear-gradient(45deg, transparent 3%, #00e6f6 3%, #00e6f6 5%, #3a83c2e0 5%);
 text-shadow: -3px -3px 0px #f8f005, 3px 3px 0px #00e6f6;
 clip-path: var(--slice-0);
}

button:hover::after {
 animation: 1s glitch;
 animation-timing-function: steps(2, end);
}

@keyframes glitch {
 0% {
  clip-path: var(--slice-1);
  transform: translate(-20px, -10px);
 }

 10% {
  clip-path: var(--slice-3);
  transform: translate(10px, 10px);
 }

 20% {
  clip-path: var(--slice-1);
  transform: translate(-10px, 10px);
 }

 30% {
  clip-path: var(--slice-3);
  transform: translate(0px, 5px);
 }

 40% {
  clip-path: var(--slice-2);
  transform: translate(-5px, 0px);
 }

 50% {
  clip-path: var(--slice-3);
  transform: translate(5px, 0px);
 }

 60% {
  clip-path: var(--slice-4);
  transform: translate(5px, 10px);
 }

 70% {
  clip-path: var(--slice-2);
  transform: translate(-10px, 10px);
 }

 80% {
  clip-path: var(--slice-5);
  transform: translate(20px, -10px);
 }

 90% {
  clip-path: var(--slice-1);
  transform: translate(-10px, 0px);
 }

 100% {
  clip-path: var(--slice-1);
  transform: translate(0);
 }
}
.logout
{
  position: absolute;
  right:9%;
  top: 10px;
}
.search
{
  position: absolute;
  right:15%;
  top: 11px;
}
.search i:hover
{
  color: black;
}
</style>