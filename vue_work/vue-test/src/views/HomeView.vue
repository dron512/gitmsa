<script setup>
import dayjs from 'dayjs';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { ref } from 'vue';

const now = ref(dayjs());
const arrdate = ref([]);

const setting = () => {
  arrdate.value = [];
  let count = 1;

  const endDate = now.value.get('day');
  const startday = dayjs(now.value).startOf('month').get("day");// 요일 설정

  for (let num = 1; num < startday + 1; num++) {
    arrdate.value.unshift({ "item": dayjs(now.value).startOf('month').subtract(num, 'day').get('date'), "opacity": true })
    count++;
  }
  for (let i = 1; i < Number(now.value.endOf('month').format('DD')) + 1; i++) {
    arrdate.value.push({ "item": i, "opacity": false });
    count++;
  }

  for (let i = 1; count < 43; i++, count++) {
    arrdate.value.push({ "item": i, "opacity": true })
  }
}

const beforeMonth = () => {
  now.value = dayjs(now.value).subtract(1, 'month');
  setting();
}

const afterMonth = () => {
  now.value = dayjs(now.value).add(1, 'month');
  setting();
}

setting();
</script>

<template>
  <main>
    <h1>TEST</h1>
    <h1>now = {{ now }}</h1>
    <h1>{{ now.format('YYYY/MM/DD') }}</h1>
    <h1>{{ now.startOf('month').format('YYYY/MM/DD') }}</h1>
    <h1>{{ now.endOf('month').format('YYYY/MM/DD') }}</h1>
    <h1>{{ endDate }}</h1>
    <div class="flex flex-col items-center">
      <div class="mb-3">
        <span class="mr-3" @click="beforeMonth"><font-awesome-icon icon="fa-solid fa-arrow-left" size="lg" /></span>
        <span>달력</span>
        <span class="ml-3" @click="afterMonth"><font-awesome-icon icon="fa-solid fa-arrow-right" /></span>
      </div>
      <h1>{{now.get('year')}} 년 {{ now.get('month') }} 월 {{ now.get('day') }}일</h1>
      <table>
        <tr>
          <th class="px-5 py-2 border border-gray-300">일</th>
          <th class="px-5 py-2 border border-gray-300">월</th>
          <th class="px-5 py-2 border border-gray-300">화</th>
          <th class="px-5 py-2 border border-gray-300">수</th>
          <th class="px-5 py-2 border border-gray-300">목</th>
          <th class="px-5 py-2 border border-gray-300">금</th>
          <th class="px-5 py-2 border border-gray-300">토</th>
        </tr>
        <template v-for="(item, index) in arrdate" :key="index">
          <tr v-if="index % 7 === 0">
            <td v-for="(subItem, subIndex) in arrdate.slice(index, index + 7)" :key="subIndex"
              class="px-3 py-1 border border-gray-300 cursor-pointer hover:bg-slate-100 text-center"
              :class="{ op: subItem.opacity }">
              {{ subItem.item }}
            </td>
          </tr>
        </template>
      </table>
    </div>
  </main>
</template>

<style>
.op {
  opacity: 0.5;
}
</style>