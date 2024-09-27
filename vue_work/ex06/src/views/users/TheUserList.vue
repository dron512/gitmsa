<template>
  <div class="pb-10">
    <h1 class="h1-blue">UserList</h1>
  </div>
</template>

<script setup>
import { getUsers } from '@/api/userApi.js';
import { watchEffect } from 'vue';

watchEffect(() => {
  const retValue = getUsers();
  console.log(retValue);
});
</script>
<style scoped>
.h1-blue {
  font-size: 5rem;
  color: blue;
}
</style>
