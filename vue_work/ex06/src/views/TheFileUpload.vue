<template>
  <div>
    <h1 class="h1-red">TheFileUpload</h1>
    <div class="p-5">
      <input type="file" name="file" id="" @change="onFileChange" />
    </div>
    <div class="p-5">
      <button
        class="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
        type="button"
        @click="save"
      >
        전송
      </button>
    </div>
    myfile = {{ myfile }}
  </div>
</template>

<script setup>
// import axios from 'axios';
import { ref } from 'vue';
const myfile = ref(null);

console.log("user3");

const save = () => {
  if (!myfile.value) {
    alert('파일을 선택하세요');
    return;
  }

  // axios.post('http://localhost:10000/file/upload')
};
const onFileChange = (e) => {
  myfile.value = e.target.value;
};
</script>

<style lang="scss" scoped></style>
