<script setup>
</script>

<template>
  <header>
    <div class="wrapper">
      <nav class="flex space-x-10 p-3">
        <RouterLink to="/" class="p-3 bg-slate-600 hover:bg-slate-500">Home</RouterLink>
        <RouterLink to="/about" class="p-3 bg-slate-600 hover:bg-slate-500">About</RouterLink>
      </nav>
    </div>
  </header>

  <RouterView />
</template>

<style scoped>
</style>
