<script setup>
import dayjs from 'dayjs';
import { useRoute, useRouter } from 'vue-router';

const doPrint = (day)=>{
  console.log(day.format('YYYY/MM/DD'));
}

const router = useRouter();
const route = useRoute();
let now = dayjs();
if(route.query.month<0){
  now = dayjs(now).subtract(Number(route.query.month),'month');
}


const date1 = dayjs('2023-06-30'); // 2023-06-30T00:00:00+09:00
const date2 = dayjs('2023.06.30', 'YYYY.MM.DD'); // 2023.06,30T00:00:00+09:00
const date3 = dayjs('2023/06/30', 'YYY/MM/DD').format('YYYY/MM/DD'); // 2023/06/30T00:00:00+09:00
const currentTime = dayjs().format('YYYY-MM-DD HH:mm:ss'); // 현재날짜 + 시각

const start = dayjs(now).startOf('month');
console.log(start.format('YYYY/MM/DD'));
const end = dayjs(now).endOf('month');
console.log(end.format('YYYY/MM/DD'));
const startDay = dayjs(start).get('day');
console.log(startDay);
const endDay = dayjs(end).get('day');
console.log(endDay);

const dayColumns = [];
// 현재 달력
for(let i=0;i<end.get('date');i++){
  const date = dayjs(start).add(i,"day");
  dayColumns.push(date);
}
// 저번 달력
for(let i=1 ; i<startDay+1;i++){
  const date = dayjs(start).subtract(i,"day");
  dayColumns.unshift(date);
}
// 다음 달력
for(let i=1 ; i<7-endDay;i++){
  const date = dayjs(end).add(i,"day");
  dayColumns.push(date);
}

const weeks = [];
for(let i=0; i<dayColumns.length; i+=7){
  weeks.push(dayColumns.slice(i,i+7));
}
console.log(weeks);

const beforeMonth = ()=>{
  router.push({query:{month:-1}})
}

</script>
<style>
td,
th,
table {
  border: 1px solid black;
}
td {
  text-align: center;
  width: 100px;
}
</style>
<template>
  <div>
    <div>
      <button @click="beforeMonth">&lt;&lt;</button>
      <h1 class="text-5xl">{{ now.format('YYYY/MM/DD') }}</h1>
      <button @click="afterMonth">&gt;&gt;</button>
      <table>
        <thead>
          <tr>
            <th>일</th>
            <th>월</th>
            <th>화</th>
            <th>수</th>
            <th>목</th>
            <th>금</th>
            <th>토</th>
          </tr>
        </thead>
        <tbody class="cursor-pointer">
          <tr v-for="week in weeks" :key="week">
            <td v-for="(day,dayIndex) in week" :key="day" @click="doPrint(day)" 
            :class="{'opacity-10': day.isBefore(start),'opacity-15':day.isAfter(end)}"
            :style="{ color: dayIndex === 0 ? '#e67639' :  dayIndex === 6 ? '#5872d1' : '#2b2b2b' }"
            >
              {{ day.format('DD') }}
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
  <div class="p-5">
    <h1>현재 날짜 = {{ now }}</h1>
    <h2>date1 = {{ date1 }}</h2>
    <h2>date2 = {{ date2 }}</h2>
    <h2>date3 = {{ date3 }}</h2>
    <h2>currentTime = {{ currentTime }}</h2>
    <hr class="m-3" />
    <h2>날짜 빼기 = {{ dayjs(now).subtract(1, 'day').format('YYYY/MM/DD') }}</h2>
    <h2>현재 날짜 = {{ dayjs(now).format('YYYY/MM/DD') }}</h2>
    <h2>날짜 더하기 = {{ dayjs(now).add(1, 'day').format('YYYY/MM/DD') }}</h2>
    <h2>월 빼기 = {{ dayjs(now).subtract(1, 'month').format('YYYY/MM/DD') }}</h2>
    <h2>현재 날짜 = {{ dayjs(now).format('YYYY/MM/DD') }}</h2>
    <h2>월 더하기 = {{ dayjs(now).add(1, 'month').format('YYYY/MM/DD') }}</h2>
    <hr class="m-3" />
    <h2>달의첫날 = {{ dayjs(now).startOf('month').format('YYYY/MM/DD') }}</h2>
    <h2>달의끝날 = {{ dayjs(now).endOf('month').format('YYYY/MM/DD') }}</h2>
    <hr class="m-3" />
    <h2>년도 = {{ dayjs(now).get('year') }}</h2>
    <h2>월 = {{ dayjs(now).get('month') }}</h2>
    <h2>일 = {{ dayjs(now).get('date') }}</h2>
    <h2>요일확인 = {{ dayjs(now).get('day') }}</h2>
    <h2>0: 일요일 1: 월요일 2: 화요일 3: 수요일 4: 목요일 5: 금요일 6: 토요일</h2>
    <h2>요일확인 = {{ dayjs(now).add(1, 'day').get('day') }}</h2>
    <h2>요일확인 = {{ dayjs(now).add(2, 'day').get('day') }}</h2>
  </div>
</template>
