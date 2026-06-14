<template>
  <div class="goods-box">
    <!-- 分类筛选下拉 -->
    <div class="filter">
      <span>商品分类：</span>
      <select v-model="categoryId" @change="changePage(1)">
        <option value="">全部分类</option>
        <option value="1">数码电子</option>
        <option value="2">服饰穿搭</option>
        <option value="3">零食饮品</option>
      </select>
    </div>

    <!-- 商品列表 -->
    <div class="goods-list">
      <div class="item" v-for="item in goodsArr" :key="item.id">
        <img :src="item.pic" alt="">
        <h4>{{ item.name }}</h4>
        <p class="price">¥{{ item.price }}</p>
      </div>
    </div>

    <!-- 分页按钮 -->
    <div class="page-bar">
      <button @click="changePage(pageNum -1)" :disabled="pageNum ===1">上一页</button>
      <span>第{{pageNum}}页 / 共{{Math.ceil(total/pageSize)}}页</span>
      <button @click="changePage(pageNum +1)" :disabled="pageNum >= Math.ceil(total/pageSize)">下一页</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { getGoodsList } from '@/api/goods'
// 加载mock模拟接口
import '@/mock'

const goodsArr = ref([])
const pageNum = ref(1)
const pageSize = ref(8)
const total = ref(0)
const categoryId = ref('')

// 加载对应页数据
const changePage = async (p) => {
  pageNum.value = p
  const res = await getGoodsList(pageNum.value, pageSize.value, categoryId.value)
  if(res.code ===200){
    goodsArr.value = res.data.records
    total.value = res.data.total
  }
}
// 页面打开默认加载第一页
changePage(1)
</script>

<style scoped>
.goods-box{padding:20px}
.filter{margin-bottom:15px}
.goods-list{display:grid;grid-template-columns: repeat(4,1fr);gap:15px}
.item{border:1px solid #eee;padding:10px;text-align:center}
.price{color:red;font-weight:bold}
.page-bar{margin-top:20px;display:flex;gap:10px;align-items:center}
</style>