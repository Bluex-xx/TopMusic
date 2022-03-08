<template>
  <div class="musicsheet">
    <div class="sheettitle">
      <div class="titlebg">
        <img :src="music[0].cover" />
      </div>
    </div>
    <div class="title">歌曲列表</div>
    <div class="list">
      <div v-for="i in music" :key="i" class="musicone">
        <img class="musiconeimg" :src="i.cover" />
        <img
          @click="updatamlist(i.id)"
          src="../assets/button.png"
          class="musicbutton"
        />
        <div class="musictitle">
          <div class="musicianname">{{ i.name }}-{{ i.artist }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapMutations } from "vuex";
export default {
  data() {
    return {};
  },
  methods: {
    ...mapMutations(["setmlist"]),
    updatamlist(id) {
      if (!localStorage.getItem("token")) {
        window.alert("请登陆后播放");
        this.$router.push("/login");
      } else {
        let uid = localStorage.getItem("uid");
        axios.post("/api/umusic/playlist", { id, uid }).then(
          (Response) => {
            //此处写将返回播放列表存入vuex并存在localStorange
            this.setmlist(Response.data);
          },
          (error) => {
            console.log(error.message);
          }
        );
      }
    },
  },
  computed: {
    music() {
      return this.$store.state.mid;
    },
  },
};
</script>

<style scoped>
.sheettitle {
  width: 100%;
  height: 300px;
  overflow: hidden;
  position: relative;
}
.sheettitle img {
  width: 100%;
  height: 100%;
}
.title {
  width: 20%;
  height: 80px;
  margin: 0 auto;
  position: absolute;
  top: 20%;
  left: 40%;
  background: #fff;
  opacity: 0.6;
  line-height: 80px;
  text-align: center;
  font-size: 30x;
  border-radius: 8px;
}
.titlebg {
  filter: blur(3px);
}
.list {
  width: 66%;
  margin: 30px auto;
  border-radius: 8px;
  padding-bottom: 40px;
  display: flex;
  flex-wrap: wrap;
}
.musicone {
  width: 23%;
  height: 250px;
  margin: 10px;
  background: black;
  overflow: hidden;
  position: relative;
  box-shadow: 0 16px 38px -12px rgba(0, 0, 0, 0.2),
    0 4px 25px 0px rgba(0, 0, 0, 0.12), 0 8px 10px -5px rgba(0, 0, 0, 0.2);
}
.musiconeimg {
  transition: all 0.6s;
  width: 100%;
  height: 100%;
  object-fit: cover;
}
.musicone:hover .musiconeimg {
  opacity: 0.9;
  transform: scale(1.1);
  filter: blur(4px);
}
.musicbutton {
  position: absolute;
  top: 36%;
  left: 39%;
  opacity: 0.6;
  transition: all 0.6s;
}
.musicbutton:hover {
  opacity: 0.8;
}
.musicone:hover .musictitle {
  display: block;
  bottom: 0;
  transition: all 0.4s;
  opacity: 0.8;
}
.musictitle {
  width: 100%;
  height: 20%;
  position: absolute;
  bottom: -20%;
  background: #ffffff;
}
.musicianname {
  text-align: center;
  margin: 10px auto;
  color: grey;
  font-size: 158x;
}
@media screen and (max-width: 1527px) {
  .list {
    width: 75%;
  }
}
</style>
