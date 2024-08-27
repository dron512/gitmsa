<script setup>
import dayjs from 'dayjs';

const now = dayjs();
let count = 1;
const arrdate = [];
const endDate = now.get('day');
const startday = dayjs().startOf('month').get("day");// 요일 설정

for (let num = 1; num < startday + 1; num++) {
  arrdate.unshift({"item":dayjs().startOf('month').subtract(num, 'day').get('date'),"opacity":0.5})
  count++;
}
for (let i = 1; i < Number(now.endOf('month').format('DD')) + 1; i++) {
  arrdate.push({"item":i,"opacity":1});
  count++;
}

for (let i = 1; count < 43; i++, count++) {
  arrdate.push({"item":i,"opacity":0.5})
}

</script>

<template>
  <main>
    <h1>TEST</h1>
    <h1>now = {{ now }}</h1>
    <h1>{{ now.format('YYYY/MM/DD') }}</h1>
    <h1>{{ now.startOf('month').format('YYYY/MM/DD') }}</h1>
    <h1>{{ now.endOf('month').format('YYYY/MM/DD') }}</h1>
    <h1>{{ endDate }}</h1>
    <table>
      <tr>
        <th class="px-3 py-1 border border-gray-300">일</th>
        <th class="px-3 py-1 border border-gray-300">월</th>
        <th class="px-3 py-1 border border-gray-300">화</th>
        <th class="px-3 py-1 border border-gray-300">수</th>
        <th class="px-3 py-1 border border-gray-300">목</th>
        <th class="px-3 py-1 border border-gray-300">금</th>
        <th class="px-3 py-1 border border-gray-300">토</th>
      </tr>
      <template v-for="(item, index) in arrdate" :key="index">
        <tr v-if="index % 7 === 0">
          <td v-for="(subItem, subIndex) in arrdate.slice(index, index + 7)" :key="subIndex"
            class="px-3 py-1 border border-gray-300">
            {{ subItem.item }}
          </td>
        </tr>
      </template>
    </table>
  </main>
</template>
