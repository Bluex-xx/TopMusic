<template>
  <div class="Loginbox">
    <div class="boxchild">
      <div class="Logintitle">Edit Page</div>
      <el-form v-model="users">
        <el-input
          placeholder="请输入用户名"
          suffix-icon="el-icon-user-solid"
          v-model="users.name"
          type="text"
        >
        </el-input>
        <el-input
          placeholder="请输入邮箱"
          suffix-icon="el-icon-takeaway-box"
          v-model="users.email"
          type="email"
        >
        </el-input>
        <el-input
          placeholder="请输入密码"
          suffix-icon="el-icon-sunrise-1"
          v-model="users.password"
          type="password"
        >
        </el-input>
        <el-row>
          <span @click="useredit">修改信息</span>
        </el-row>
      </el-form>
    </div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "UserEdit",
  data() {
    return {
      users: {
        name: "",
        password: "",
        email: "",
        uid: localStorage.getItem("uid"),
      },
    };
  },
  methods: {
    useredit() {
      if (this.users.name == "" || this.users.password == "") {
        window.alert("账号或密码为空");
      } else if (this.users.email.indexOf("@") === -1) {
        window.alert("请正确输入邮箱");
      } else {
        axios.post("/api/user/update", this.users).then(
          (Response) => {
            console.log(Response.data);
            window.alert(Response.data);
            this.$router.push("/");
            this.$store.commit("logoutx", "");
          },
          (error) => {
            console.log(error.message);
          }
        );
      }
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
  height: 556px;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background: #f9fbfd;
}
.Logintitle {
  font-size: 40px;
  font-weight: 600;
  margin: 10% 32%;
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
