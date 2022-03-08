<template>
  <div id="app">
    <MusicHeader />
    <router-view></router-view>
    <mv-list></mv-list>
    <MusicPlayer />
    <MusicFooter />
  </div>
</template>
<script>
//网站顶栏组件
import MusicHeader from "./components/MusicHeader.vue";
//网站底栏组件
import MusicFooter from "./components/MusicFooter.vue";
//音乐播放器组件
import MusicPlayer from "./page/MusicPlayer.vue";
export default {
  name: "App",
  components: {
    MusicHeader,
    MusicFooter,
    MusicPlayer,
  },
};
</script>

<style>
* {
  padding: 0;
  margin: 0;
  text-decoration: none;
  list-style: none;
}
</style>
