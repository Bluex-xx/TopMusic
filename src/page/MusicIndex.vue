<template>
  <div class="MusicIndex">
    <div class="mvlistbg">
      <div class="mvlisttitle">MV推荐</div>
      <MvList />
    </div>
    <div class="musiclisttitle">歌曲推荐</div>
    <MusicList />
  </div>
</template>
<script>
//mv推荐组件
import MvList from "./MvList.vue";
//歌曲推荐组件
import MusicList from "./MusicList.vue";
export default {
  components: {
    MvList,
    MusicList,
  },
};
</script>
<style>
.MusicIndex {
  background: #f9fafd;
}
.mvlisttitle,
.musiclisttitle {
  margin: 0 auto;
  width: 160px;
  line-height: 43px;
  margin-bottom: 30px;
  padding-left: 10px;
  font-size: 30px;
  font-weight: 500;
  letter-spacing: 10px;
  color: grey;
  border-bottom-color: #409eff;
  border-bottom-style: solid;
  border-bottom-width: 3px;
}
.musiclisttitle {
  padding-top: 20px;
}
.mvlistbg {
  padding-top: 30px;
  padding-bottom: 10px;
  width: 100%;
  background: #e8e8e842;
}
</style>
