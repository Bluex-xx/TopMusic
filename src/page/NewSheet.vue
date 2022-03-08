<template>
  <div class="Loginbox">
    <div class="boxchild">
      <div class="Logintitle">New Sheet</div>
      <el-form v-model="sheet">
        <el-input
          placeholder="歌单名称"
          suffix-icon="el-icon-takeaway-box"
          v-model="sheet.value"
          type="text"
        >
        </el-input>
        <el-row>
          <span @click="useredit">创建歌单</span>
        </el-row>
      </el-form>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import { mapMutations } from "vuex";
export default {
  name: "NewSheet",
  data() {
    return {
      sheet: {
        value: "",
        uid: localStorage.getItem("uid"),
      },
    };
  },
  methods: {
    ...mapMutations(["setsheetlist"]),
    useredit() {
      if (this.sheet.name == "") {
        window.alert("输入为空");
      } else {
        axios.post("/api/mlist/insert", this.sheet).then(
          (Response) => {
            alert(Response.data);
          },

          (error) => {
            console.log(error.message);
          }
        );
      }
      setTimeout(() => {
        var uid = localStorage.getItem("uid");
        axios.post("/api/mlist/listall", { uid }).then(
          (Response) => {
            this.setsheetlist(Response.data);
          },
          (error) => {
            console.log(error.message);
          }
        );
      }, 30);
    },
  },
};
</script>

<style scoped>
#app {
  background: #606266;
}
.el-input {
  width: 80%;
  margin: 3% 9%;
  height: 50px;
}
.el-row {
  margin: 5% 34%;
  padding: 0 14px;
  width: 333px;
}
.Loginbox {
  width: 100%;
  height: 717px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: center;
}
.boxchild {
  width: 600px;
  height: 400px;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background: #f9fbfd;
}
.Logintitle {
  font-size: 40px;
  font-weight: 600;
  margin: 10% 31%;
  color: #606266;
}
span {
  position: relative;
  padding: 10px 40px;
  margin: 0px 10px 10px 0px;
  float: left;
  border-radius: 3px;
  font-size: 20px;
  color: #fff;
  text-decoration: none;
  background-color: #2ecc71;
  border: none;
  border-bottom: 5px solid #27ae60;
  text-shadow: 0px -2px #27ae60;
  -webkit-transition: all 0.1s;
  transition: all 0.1s;
}

span:hover,
span:active {
  -webkit-transform: translate(0px, 5px);
  -ms-transform: translate(0px, 5px);
  transform: translate(0px, 5px);
  border-bottom: 1px solid #2ecc71;
}
</style>
