<script setup>
import dayjs from 'dayjs';

const now = dayjs();

const now1 = now.add(1,'day');
</script>

<template>
  <main>
  <h1>TEST</h1>
    <h1>now = {{ now }}</h1>
    <h1>now1 = {{ now1 }}</h1>
    <h1>{{now.format('YYYY/MM/DD')}}</h1>
    <h1>{{ now.startOf('month').format('YYYY/MM/DD') }}</h1>
  </main>
</template>
