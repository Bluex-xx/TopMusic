<template>
  <div class="musiclist">
    <div class="musiclisttitle">歌曲列表</div>
    <div class="musicmain">
      <div v-for="item in data" :key="item.id" class="musicone">
        <div class="musiccover">
          <img :src="item.cover" />
        </div>
        <div class="musicname">
          {{ item.name }}
        </div>
        <div class="musician">
          {{ item.artist }}
        </div>
        <div @click="updatamlist(item.id)" class="musicbutton">
          <i class="el-icon-video-play"></i>
        </div>
        <div @click="updatasheet(item.id)" class="mlistupdata">
          <i class="el-icon-plus"></i>
        </div>
      </div>
      <el-alert title="没有更多歌曲咯！" type="info" center show-icon>
      </el-alert>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapMutations } from "vuex";
export default {
  data() {
    return {
      data: this.$store.state.type,
    };
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
    updatasheet(data) {
      this.$prompt("请输入歌单名字", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
      })
        .then(({ value }) => {
          //此处添加加入歌单接口
          var uid = localStorage.getItem("uid");
          axios.post("/api/dlall/insert", { value, data, uid }).then(
            (Response) => {
              this.$message({
                type: "info",
                message: Response.data,
              });
            },
            (error) => {
              console.log(error.message);
            }
          );
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消输入",
          });
        });
    },
  },
  computed: {
    getMusic() {
      return this.$store.state.type;
    },
  },
  watch: {
    getMusic() {
      this.data = this.$store.state.type;
    },
  },
};
</script>

<style scoped>
.musiclist {
  height: auto;
  width: 100%;
  padding: 18px 0;
}
.musicmain {
  width: 1240px;
  margin: 0 auto;
  display: flex;
  flex-wrap: wrap;
}
.musicone {
  width: 30%;
  height: 116px;
  background-image: linear-gradient(90deg, #ffffff54, #a0d4f924);
  margin: 20px;
  flex-shrink: 1;
  border-radius: 4px;
  position: relative;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.musiccover {
  height: 116px;
  width: 116px;
  position: absolute;
  left: 0;
  overflow: hidden;
  border-radius: 4px;
  background: black;
}
.musiccover img {
  width: 100%;
  border-radius: 4px;
  transition: all 0.5s;
}
.musiccover img:hover {
  transform: scale(1.1);
  opacity: 0.8;
}
.musicname {
  position: absolute;
  left: 38%;
  top: 29%;
  width: 150px;
  height: 21px;
  overflow: hidden;
}
.musician {
  position: absolute;
  left: 38%;
  top: 48%;
  width: 150px;
  height: 42px;
  color: grey;
  overflow: hidden;
}
.mlistupdata {
  position: absolute;
  right: 63%;
  top: 43%;
  font-size: 7px;
  color: black;
}
.mlistupdata:hover {
  color: #b2b6c3;
}
.musicbutton {
  position: absolute;
  right: 6%;
  top: 31%;
  font-size: 32px;
  color: #8080807a;
}
.musicbutton:hover {
  color: #409eff;
}
.el-alert {
  margin-top: 20px;
  padding-top: 10px;
  margin-bottom: 20px;
}
</style>
