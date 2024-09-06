<template>
  <div>
    <TheCounter></TheCounter>
    <TheCounter></TheCounter>
    <TheCounter></TheCounter>
    <AA></AA>
    <RouterView></RouterView>
  </div>
</template>

<script>
import TheCounter from './views/TheCounter.vue';
import AA from './views/AA.vue';
import { RouterView } from 'vue-router';

export default {
  components: {
    TheCounter,
    AA,
    RouterView
  },
  setup() {

    return { TheCounter, AA, RouterView }
  }
}
</script>

<style lang="scss" scoped></style>