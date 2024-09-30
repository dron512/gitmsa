<template>
  <div>
    <h1>MyAA = {{name}}</h1>
    <button @click="doAction">바꾸기</button>
  </div>
</template>
<script>
import {ref} from 'vue';
export default {
  props: {
    aa:{
      type:String,
      default:''
    },
    myname:{
      type: String,
      default:''
    }
  },
  setup (props,context) {
    const name = ref(props.myname);
    // console.log(props);
    const doAction = ()=>{
      name.value="바뀐이름";
      context.emit('myClick');
    }
    return {name,doAction}
  }
}
</script>
<style lang="scss" scoped>

</style>