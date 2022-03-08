<template>
  <div class="Loginbox">
    <div class="boxchild">
      <div class="Logintitle">Login Page</div>
      <el-form v-model="user">
        <el-input
          placeholder="请输入邮箱"
          suffix-icon="el-icon-user-solid"
          v-model="user.email"
          type="text"
        >
        </el-input>
        <el-input
          placeholder="请输入密码"
          suffix-icon="el-icon-sunrise-1"
          v-model="user.password"
          type="password"
        >
        </el-input>
        <el-row>
          <span @click="userLogin">登录</span>
          <router-link to="/register">
            <span>注册</span>
          </router-link>
        </el-row>
      </el-form>
    </div>
  </div>
</template>
<script>
import { mapMutations } from "vuex";
import axios from "axios";
export default {
  name: "UserLogin",
  data() {
    return {
      user: {
        email: "",
        password: "",
      },
    };
  },
  methods: {
    ...mapMutations(["setstate"]),
    userLogin() {
      if (this.user.email === "" || this.user.password === "") {
        window.alert("邮箱或密码为空");
      } else {
        axios.post("/api/user/login", this.user).then(
          (Response) => {
            console.log(Response.data);
            window.alert(Response.data.msg);
            if (Response.data.state === "false") {
              this.$router.push("/login");
            } else {
              this.setstate(Response.data);
              this.$router.push("/");
            }
          },
          (error) => {
            console.log(error.message);
          }
        );
      }
    },
  },
  //判断是否重复登录
  mounted() {
    if (this.$store.state.state) {
      this.$router.push("/"), window.alert("已登录，请勿重复登录");
    }
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
  margin: 5% 28%;
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
  height: 496px;
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
