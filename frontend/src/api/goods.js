import request from '../utils/request'
// 分页+分类查询商品
export function getGoodsList(pageNum, pageSize, categoryId) {
  return request({
    url: '/goods/list',
    method: 'GET',
    params: { pageNum, pageSize, categoryId }
  })
}