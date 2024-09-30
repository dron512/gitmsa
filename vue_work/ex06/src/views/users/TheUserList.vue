<template>
  <div class="overlay"></div>
  <div class="pb-10">
    <h1 class="h1-blue">UserList</h1>
    <div style="" class="flex flex-wrap">
    <!-- <div style="display: flex;flex-wrap: wrap;" class=""> -->
      <div 
          @click="modalUser"
          class="
          cursor-pointer
        bg-slate-500 
          p-5 
          m-5
          w-80
          text-white
          rounded" 
          v-for="item in arr" :key="item.idx">
        <h1>idx = {{ item.idx }}</h1>
        <h1>name = {{ item.name }}</h1>
        <h1>email = {{ item.email }}</h1>
        <h1>가입날짜 = {{ item.wdate }}</h1>
        <h1>작성한글 = {{ item.list.length }}</h1>
      </div>
    </div>
  </div>
</template>
<script setup>
import { getUsers } from '@/api/userApi.js';
import { ref, watchEffect } from 'vue';

const arr = ref([]);
const modalUser = ()=>{
  console.log("test");
}

watchEffect( async() => {
  const retValue = await getUsers();
  // console.log("retValue = "+JSON.stringify(retValue.data));
  arr.value = retValue.data;
  console.log(arr.value);
});
</script>
<style scoped>
.h1-blue {
  font-size: 5rem;
  color: blue;
}
.overlay{
  position: fixed; top:0; left:0; width: 100%; height: 100%; z-index: 1000; background-color: rgb(0,0,0,0.1);
  /* display: none; */
}
</style>
