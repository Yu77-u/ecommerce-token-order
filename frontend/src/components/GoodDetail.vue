<template>
  <div class="good-detail">
    <h2>商品详情</h2>
    <PromoTag :tagText="promoInfo.tag" :tagColor="promoInfo.color"/>
    <CountDown :endTime="promoInfo.endTime"/>
    <p>原价：{{ promoInfo.price }} 元</p>
    <p>活动价：{{ promoInfo.salePrice }} 元</p>
  </div>
</template>

<script setup>
import PromoTag from './PromoTag.vue'
import CountDown from './CountDown.vue'

const promoInfo = {
  tag: "限时8折",
  color: "#f56c6c",
  price: 299,
  salePrice: 239.2,
  endTime: "2026-08-01 23:59:59"
}
</script>

<style scoped>
.good-detail {
  padding: 20px;
  border: 1px solid #eee;
  width: 420px;
}
</style>