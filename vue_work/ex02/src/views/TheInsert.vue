<template>
  <div>
    <h1>TheInsert</h1>
    <button @click="userSend">전송</button>
  </div>
</template>

<script>
export default {
  setup() {
    const mydata = {
      "name": "천재야",
      "age": 500,
      "email": "qwer@naver.com",
      "password": "password",
      "wdate": "2024-09-06T11:18:32.729596"
    }
    const userSend = () => {
      fetch('http://192.168.0.29:8080/user/insert', {
        method: "POST",
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(mydata)
      })
        .then(res => {
          // console.log(res);
        })
    }
    return { userSend }
  }
}
</script>

<style lang="scss" scoped></style>