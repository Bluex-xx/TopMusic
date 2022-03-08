<template>
  <div class="Mvlist">
    <div class="mvwidth">
      <el-carousel :interval="3000" type="card" height="370px" trigger="click">
        <el-carousel-item v-for="item in mv" :key="item.id">
          <h3 class="medium"><img :src="item.cover" /></h3>
          <div class="mvbutton">
            <button @click="mvupdata(item)" class="cta">
              <router-link to="/mv">
                <span>watch it!</span>
              </router-link>
              <svg width="15px" height="10px" viewBox="0 0 13 10">
                <path d="M1,5 L11,5"></path>
                <polyline points="8 1 12 5 8 9"></polyline>
              </svg>
            </button>
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapMutations } from "vuex";
export default {
  name: "MvList",
  data() {
    return {
      mv: "",
    };
  },
  methods: {
    //将用户想要播放的mv的数据传给vuex
    ...mapMutations(["setmv"]),
    mvupdata(data) {
      this.setmv(data);
    },
  },
  created() {
    //获取首页推荐的歌曲数据，以及推荐的mv数据
    axios.post("/api/mv/findall").then(
      (Response) => {
        this.mv = Response.data.mvList;
      },
      (error) => {
        console.log(error.message);
      }
    );
  },
};
</script>

<style scoped>
.mvwidth {
  width: 93%;
  margin: 0 auto;
}
img {
  width: 100%;
  overflow: hidden;
  border-radius: 16px;
  height: 300px;
  object-fit: cover;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.2);
}
.el-carousel__item {
  background-color: transparent;
  backdrop-filter: blur(5px);
}
.mvbutton {
  width: 158px;
  margin: 5px auto;
}
.cta {
  position: relative;
  margin: auto;
  padding: 10px 18px;
  transition: all 0.2s ease;
  border: none;
  background: none;
}

.cta:before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  display: block;
  border-radius: 50px;
  background: #409effa1;
  width: 45px;
  height: 45px;
  transition: all 0.3s ease;
}

.cta span {
  position: relative;
  font-family: "Ubuntu", sans-serif;
  font-size: 18px;
  font-weight: 700;
  letter-spacing: 0.05em;
  color: #3d5b7896;
}

.cta svg {
  position: relative;
  top: 0;
  margin-left: 10px;
  fill: none;
  stroke-linecap: round;
  stroke-linejoin: round;
  stroke: #234567;
  stroke-width: 2;
  transform: translateX(-5px);
  transition: all 0.3s ease;
}

.cta:hover:before {
  width: 100%;
  background: #b1dae7;
}

.cta:hover svg {
  transform: translateX(0);
}

.cta:active {
  transform: scale(0.95);
}
</style>
