<template>
  <div style="width:400px;margin:100px auto">
    <h2>电商平台登录</h2>
    <el-input v-model="username" placeholder="输入用户名" style="margin:10px 0"></el-input>
    <el-input v-model="password" type="password" placeholder="输入密码" style="margin:10px 0"></el-input>
    <el-button type="primary" @click="doLogin" style="width:100%">登录</el-button>
  </div>
</template>
<script setup>
import { ref } from 'vue'
import { login } from '../api/order'
const username = ref('')
const password = ref('')
// 登录点击事件
const doLogin = async () => {
  const res = await login(username.value, password.value)
  if(res.code === 200){
    // 登录成功存储token，跳转订单页
    localStorage.setItem('token', res.data)
    location.href = '/order'
  }else{
    alert(res.msg)
  }
}
</script>