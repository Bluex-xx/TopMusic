<template>
  <div class="mvmain">
    <div class="mvdetail">
      MV:{{ mv.title }}
      <div class="button">
        <el-button
          @click="tip"
          type="success"
          icon="el-icon-thumb"
          circle
        ></el-button>
        <el-button
          @click="tip"
          type="info"
          icon="el-icon-message"
          circle
        ></el-button>
        <el-button
          @click="tip"
          type="danger"
          icon="el-icon-star-off"
          circle
        ></el-button>
      </div>
    </div>
    <div class="player-container">
      <vue-core-video-player
        :src="videoSource"
        :cover="mv.cover"
        title=""
        autoplay
        loop="true"
      />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      videoSource: [
        {
          src: "http://media.vued.vanthink.cn/sparkle_your_name_am360p.mp4",
          resolution: 360,
        },
        {
          src: "http://media.vued.vanthink.cn/sparkle_your_name_am720p.mp4",
          resolution: 720,
        },
        {
          src: "http://media.vued.vanthink.cn/y2mate.com%20-%20sparkle_your_name_amv_K_7To_y9IAM_1080p.mp4",
          resolution: 1080,
        },
      ],
    };
  },
  methods: {
    tip() {
      alert("点赞成功");
    },
  },
  computed: {
    mv() {
      return this.$store.state.mv;
    },
  },
  mounted() {
    localStorage.setItem("mvurl", this.mv.url);
  },
};
</script>

<style scoped>
.mvmain {
  width: 70%;
  margin: 0 auto;
  margin-bottom: 80px;
}
.mvdetail {
  line-height: 88px;
  font-size: 30px;
  font-weight: 500;
  color: grey;
}
.button {
  float: right;
}
</style>
