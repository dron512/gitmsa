<template>
  <div>
    <h1 class="h1-red">TheFreeBoardView</h1>
  </div>
</template>

<script setup>
import axios from 'axios';
import { useRoute } from 'vue-router';

const route = useRoute();
console.log();

const getFreeBoard = () => {
  axios.get(`http://localhost:8080/freeboard/view/${route.params.idx}`)
    .then(res => {
      console.log(res);
    })
    .catch(e => {
      console.log(e);
    })
}

getFreeBoard();

</script>

<style lang="scss" scoped></style>