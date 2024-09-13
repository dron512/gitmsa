<template>
  <div>
    <h1>FreeBoard</h1>
    <div class="p-5">
      <input type="text" placeholder="Enter your title here" class="aa w-11/12 p-3 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2
                  focus:ring-blue-500 focus:border-transparent text-gray-700 placeholder-gray-400 bg-white" />
      <textarea class="aa w-11/12 h-40 p-4 border border-gray-300 rounded-lg shadow-sm 
                focus:outline-none focus:ring-2 focus:ring-blue-400 focus:border-transparent 
                resize-none text-gray-700 placeholder-gray-400 bg-white" placeholder="Enter Content here"></textarea>
      <button class="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md
           hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300">
        저장
      </button>
    </div>

  </div>
</template>

<script setup>

</script>

<style scoped>
.aa {
  margin: 1rem;
}
</style>