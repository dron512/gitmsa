<template>
  <div>
    <TheCounter></TheCounter>
    <TheCounter></TheCounter>
    <TheCounter></TheCounter>
  </div>
</template>

<script>
import TheCounter from './views/TheCounter.vue';
export default {
  components: {
    TheCounter
  },
  setup() {

    return { TheCounter }
  }
}
</script>

<style lang="scss" scoped></style>