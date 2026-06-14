import Mock from 'mockjs'
Mock.mock('/api/goods/list', 'get', req => {
  const { pageNum, pageSize, categoryId } = req.query
  const total = 28
  const start = (pageNum - 1) * pageSize
  const pageData = Mock.mock({
    [`list|${pageSize}`]: [{
      id: '@increment',
      name: '@cword(5,9)好物',
      price: '@float(9.9, 199.9, 2)',
      categoryId: categoryId || 1,
      pic: '@image(120x120, #eee, #333, png)'
    }]
  })
  return {
    code: 200,
    data: {
      records: pageData.list,
      total,
      pageNum,
      pageSize
    }
  }
})