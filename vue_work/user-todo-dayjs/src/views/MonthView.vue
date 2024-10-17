<script setup>
import { ref, watch } from 'vue'
import dayjs from 'dayjs'
import utc from 'dayjs/plugin/utc'
import timezone from 'dayjs/plugin/timezone'

dayjs.extend(utc)
dayjs.extend(timezone)

const now = ref(dayjs())
const columns = ref([])

const subMonth = () => {
  now.value = dayjs(now.value).subtract(1, 'month')
}
const addMonth = () => {
  now.value = dayjs(now.value).add(1, 'month')
}
watch(now, (newValue, _) => {
  columns.value = [];
  // 제일 처음 로딩 할때는 now는 현재 달력...
  const startday = dayjs(now.value).startOf('month')
  const lastday = dayjs(now.value).endOf('month')

  for (let i = 0; i < lastday.get('date'); i++) {
    columns.value.push(dayjs(startday).add(i, 'day'))
  }
},{
  immediate: true,  // 현재페이지 처음 로딩 될때 도 실행
  deep: true, // 안에 값이 객체이면 객체 안에 변수도 변경 될때 watch안에 있는 함수 실행
})
</script>

<template>
  <main>
    <h1>MonthView</h1>
    <h1 class="text-center text-3xl">
      <button @click="subMonth()">&lt;&lt;</button>
      {{ now.format('YYYY년 MM월') }}
      <button @click="addMonth()">&gt;&gt;</button>
    </h1>
    <div v-for="column in columns" :key="column.format('YYYY-MM-DD')" class="">
      {{ column.get('date') }}
    </div>
  </main>
</template>
