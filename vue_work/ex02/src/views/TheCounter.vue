<template>
  <div>
    <h1>count = {{ count }}</h1>
    <button @click="addCount">증가</button>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  setup() {
    const count = ref(0);
    const addCount = () => {
      count.value = count.value + 1;
    }
    return { count, addCount }
  }
}
</script>

<style lang="scss" scoped></style>