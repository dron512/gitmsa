<template>
  <div>
    <h1>안녕 VUE</h1>
    <MyAA :aa="aa" :myname="홍길동"></MyAA>
    <MyAA :myname="김길동"></MyAA>
    <MyAA :myname="이길동"></MyAA>
  </div>
</template>

<script>
import MyAA from '@/components/MyAA.vue'

export default {
  components:{ 
    MyAA
  },
  setup () {
    return {MyAA}
  }
}
</script>
<style lang="scss" scoped>

</style>