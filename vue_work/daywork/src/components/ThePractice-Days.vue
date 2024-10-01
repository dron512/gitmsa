<script setup>
import dayjs from 'dayjs';

const getDayColor = (day) => {
  return day === 0 ? '#e67639' : day === 6 ? '#5872d1' : '#2b2b2b';
};

const now = dayjs();

const date1 = dayjs('2023-06-30'); // 2023-06-30T00:00:00+09:00
const date2 = dayjs('2023.06.30', 'YYYY.MM.DD'); // 2023.06,30T00:00:00+09:00
const date3 = dayjs('2023/06/30', 'YYY/MM/DD').format('YYYY/MM/DD'); // 2023/06/30T00:00:00+09:00
const currentTime = dayjs().format('YYYY-MM-DD HH:mm:ss'); // 현재날짜 + 시각

const start = dayjs(now).startOf('month');
console.log(start.format('YYYY/MM/DD'));
const startDay = dayjs(start).get('day');
console.log(startDay);
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
      <h1 class="text-5xl">{{ now.format('YYYY/MM/DD') }}</h1>
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
        <tbody>
          <tr>
            <td v-for="index in 7" :key="index">{{ index }}</td>
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
