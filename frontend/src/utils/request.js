import axios from 'axios'
const service = axios.create({
  baseURL: '/api',
  timeout: 5000
})
// 请求拦截
service.interceptors.request.use(config => {
  return config
}, err => Promise.reject(err))
// 响应拦截
service.interceptors.response.use(res => {
  return res.data
}, err => {
  console.log('请求异常', err)
  return Promise.reject(err)
})
export default service