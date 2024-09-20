<template>
  <div>
    <h1 class="h1-red">TheFreeBoardView</h1>
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router';

const route = useRoute();
console.log(route.params.idx);


</script>

<style lang="scss" scoped>

</style>