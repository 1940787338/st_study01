<template>
  <div id="login">
    <div class="login">
      <el-form :model="loginForm" ref="loginForm" label-width="100px">
        <h3 class="loginTitle">双碳管理系统-登录</h3>
        <el-form-item label="用户名" prop="username" :rules="[{ required: true, message: '用户名不能为空'},]">
          <el-input id="username" v-model="loginForm.username"></el-input>
        </el-form-item>
        
        <el-form-item label="密码" prop="password" :rules="[{required: true, message:'密码不能为空'}]">
          <el-input id="password" type="password" v-model="loginForm.password"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button id="loginBth" @click="subLogin" type="primary">登录</el-button>
        </el-form-item>
      </el-form>
    </div>

  </div>
</template>

<script>
export default {
  data () {
    return {
      username: '123',
      loginForm: {
        username: '',
        password: ''
      }
    }
  },
  methods:{
    subLogin(){
      
    }
  }
}
</script>

<style>

  .login {
    margin: 0 auto;
    margin-top: 150px;
    width: 40%;
    height: 40%;
    background: #78e68c;
    border-radius: 20px;
  }

  #username,#password {
    width: 50%;
  }

  .loginTitle {
    font-size: 30px;
    padding-top: 30px;
    padding-left: 100px;
  }

  #loginBth {
    width: 100px;
    margin-bottom: 30px;
  }

  body{
    background: url(../assets/bg.png) no-repeat;
    background-size: cover;
  }
</style>