<template>
  <div>
    <aplayer ref="aplayer" :audio="audio" :lrcType="0" fixed />
  </div>
</template>

<script>
export default {
  computed: {
    getMlist() {
      return this.$store.state.mlist;
    },
    audio() {
      return this.$store.state.mlist;
    },
  },
  //监测mlist的数据变化，并更新数据
  watch: {
    getMlist() {
      setTimeout(() => {
        this.$refs.aplayer.switch(0);
        this.$refs.aplayer.play();
      }, 10);
    },
  },
};
</script>

<style></style>
