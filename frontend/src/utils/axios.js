import axios from 'axios'
const service = axios.create({
  baseURL: 'http://localhost:8080',
  timeout: 5000
})
// 请求拦截：自动带上登录token
service.interceptors.request.use(config => {
  const token = localStorage.getItem('token')
  if(token){
    config.headers.Authorization = `Bearer ${token}`
  }
  return config
})
// 响应拦截：token过期自动跳登录页
service.interceptors.response.use(res => res.data, err => {
  if(err.response?.status === 401){
    localStorage.removeItem('token')
    location.href = '/login'
  }
  return Promise.reject(err)
})
export default service