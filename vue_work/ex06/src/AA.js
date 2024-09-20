import axios from "axios";

export const aa = ()=>{
  console.log("test")
}

<img v-if="imageSrc" :src="imageSrc" alt="Downloaded Image" />

export const data = {
  async downloadImage() {
    try {
      // Spring Boot에서 이미지를 다운로드
      const response = await axios.get('http://localhost:8080/image/sample.jpg', {
        responseType: 'blob',  // 이미지 데이터를 blob으로 받음
      });

      // Blob 데이터를 URL로 변환하여 이미지로 사용
      this.imageSrc = URL.createObjectURL(response.data);
    } catch (error) {
      console.error('이미지 다운로드 실패:', error);
    }
  }
}