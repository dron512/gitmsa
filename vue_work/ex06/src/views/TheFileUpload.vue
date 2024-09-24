<template>
  <div>
    <h1 class="h1-red">TheFileUpload</h1>
    <div class="p-5">
      <input type="file" name="file" id="" />
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
  </div>
</template>

<script setup>
const save = ()=>{
    console.log("save");
}
</script>

<style lang="scss" scoped></style>
