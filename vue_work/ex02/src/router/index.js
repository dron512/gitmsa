import { createRouter, createWebHistory } from 'vue-router'
import TheCounter from '@/views/TheCounter.vue'
import TheWelcome from '@/views/TheWelcome.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'counter',
      component: TheCounter
    },
    {
      path: '/welcome',
      name: 'welcome',
      component: TheWelcome
    },
  ]
})

export default router
