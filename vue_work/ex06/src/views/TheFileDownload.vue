<template>
  <button @click="downloadImage">이미지 다운로드</button>
  <div v-if="imageUrl">
    <img :src="imageUrl" alt="Downloaded Image" class="w-1/2 mx-auto mt-4" />
  </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';

const imageUrl = ref(null);
const downloadImage = async () => {
  try {
    const response = await axios.get('http://localhost:10000/file/download/016.png', {
      responseType: 'blob' // 이미지를 blob으로 받아옴
    });

    console.log(response);

    // 이미지 blob을 base64로 변환하여 미리보기
    const reader = new FileReader();
    reader.onload = (e) => {
      imageUrl.value = e.target.result; // 이미지 데이터를 base64로 저장
    };
    reader.readAsDataURL(response.data);
  } catch (error) {
    console.error('이미지 다운로드 중 오류 발생:', error);
  }
};
</script>

<style lang="scss" scoped></style>
