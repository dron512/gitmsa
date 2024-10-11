<template>
  <header>
    <div class="p-5 bg-slate-500 text-white text-3xl">
      <nav class="flex justify-between">
        <div class="flex space-x-5">
          <div>
            <RouterLink to="/">HOME</RouterLink>
          </div>
          <div>
            <RouterLink to="/user">USER</RouterLink>
          </div>
          <div class="group relative">
            <RouterLink to="/freeboardlist">FREEBOARD</RouterLink>
            <div
              class="opacity-0 group-hover:opacity-100 transition absolute bg-slate-500 p-5 top-8 -left-5 rounded"
            >
              <div>
                <RouterLink to="/freeboardlist">FREEBOARDLIST</RouterLink>
              </div>
              <div>
                <RouterLink to="/freeboardinput">FREEBOARDINPUT</RouterLink>
              </div>
            </div>
          </div>
          <div class="group relative">
            <RouterLink to="/fileupload">FILE</RouterLink>
            <div
              class="opacity-0 group-hover:opacity-100 transition absolute bg-slate-500 p-5 top-8 -left-5 rounded"
            >
              <div>
                <RouterLink to="/fileupload">FILEUPLOAD</RouterLink>
              </div>
              <div>
                <RouterLink to="/fileuploads">FILEUPLOADS</RouterLink>
              </div>
              <div>
                <RouterLink to="/filedownload">FILEDOWNLOAD</RouterLink>
              </div>
            </div>
          </div>
        </div>
        <template v-if="loginCheck">
          <div>로그인하셨네요...</div>
        </template>
        <template v-else>
          <div class="flex space-x-5">
            <div>
              <RouterLink to="/join">JOIN</RouterLink>
            </div>
            <div>
              <RouterLink to="/login">LOGIN</RouterLink>
            </div>
          </div>
        </template>
      </nav>
    </div>
  </header>
</template>

<script setup>
import { doLoginCheck } from '@/api/loginApi';
import { ref, watchEffect } from 'vue';
import { RouterLink } from 'vue-router';

const loginCheck = ref(false);

watchEffect(() => {
    const result = doLoginCheck();
    if(result==false){
        loginCheck.value = false;
    }else{
        console.log(result);
        loginCheck.value = true;
    }
});
</script>

<style lang="scss" scoped></style>
