<template>
  <div class="promo-tag" :style="{background: tagColor}">
    {{ tagText }}
  </div>
</template>

<script setup>
const props = defineProps({
  tagText: String,
  tagColor: String
})
</script>

<style scoped>
.promo-tag {
  display: inline-block;
  color: #fff;
  padding: 4px 12px;
  border-radius: 4px;
  margin-bottom: 10px;
}
</style>