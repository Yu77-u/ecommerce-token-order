<template>
  <div style="width:90%;margin:20px auto">
    <h2>我的订单列表</h2>
    <el-table :data="orderList" border style="margin:20px 0">
      <el-table-column label="订单编号" prop="orderNo"></el-table-column>
      <el-table-column label="实付金额" prop="amount"></el-table-column>
      <el-table-column label="订单状态" prop="status"></el-table-column>
      <el-table-column label="创建时间" prop="createTime"></el-table-column>
    </el-table>
    <el-pagination
      @current-change="loadOrderData"
      @size-change="loadOrderData"
      :current-page="pageNum"
      :page-size="pageSize"
      :total="total"
      layout="prev, pager, next, total"
    ></el-pagination>
  </div>
</template>
<script setup>
import { ref, onMounted } from 'vue'
import { getOrderList } from '../api/order'
// 分页变量
const orderList = ref([])
const pageNum = ref(1)
const pageSize = ref(10)
const total = ref(0)
// 加载订单数据
const loadOrderData = async () => {
  const res = await getOrderList(pageNum.value, pageSize.value, '')
  if(res.code === 200){
    orderList.value = res.data.records
    total.value = res.data.total
  }
}
// 页面打开自动加载
onMounted(loadOrderData)
</script>