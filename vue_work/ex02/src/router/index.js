import { createRouter, createWebHistory } from 'vue-router'
import TheCounter from '@/views/TheCounter.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'counter',
      component: TheCounter
    },
  ]
})

export default router
