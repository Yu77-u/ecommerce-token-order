import request from '../utils/axios'
// 登录接口
export function login(username, password) {
  return request({
    url: '/login',
    method: 'post',
    data: { username, password }
  })
}
// 订单分页查询接口
export function getOrderList(pageNum, pageSize, status) {
  return request({
    url: '/order/list',
    method: 'get',
    params: { pageNum, pageSize, status }
  })
}