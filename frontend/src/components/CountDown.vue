<template>
  <div class="count">
    距活动结束：{{ day }}天 {{ hour }}时 {{ min }}分 {{ sec }}秒
  </div>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue'
const props = defineProps({
  endTime: String
})

const day = ref(0)
const hour = ref(0)
const min = ref(0)
const sec = ref(0)
let timer = null

function calcTime() {
  const end = new Date(props.endTime).getTime()
  const now = Date.now()
  let diff = end - now
  if (diff <= 0) {
    day.value = hour.value = min.value = sec.value = 0
    clearInterval(timer)
    return
  }
  day.value = Math.floor(diff / (1000*60*60*24))
  hour.value = Math.floor((diff % (1000*60*60*24)) / (1000*60*60))
  min.value = Math.floor((diff % (1000*60*60)) / (1000*60))
  sec.value = Math.floor((diff % (1000*60)) / 1000)
}

onMounted(() => {
  calcTime()
  timer = setInterval(calcTime, 1000)
})
onUnmounted(() => clearInterval(timer))
</script>

<style scoped>
.count {
  color: #e4393c;
  margin: 8px 0;
}
</style>