import { createRouter, createWebHistory } from 'vue-router'
import TheHome from '../views/TheHome.vue';
import TheSelect from '../views/TheSelect.vue';
import TheDelete from '../views/TheDelete.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: TheHome
    },
    {
      path: '/select',
      name: 'select',
      component: TheSelect
    },
    {
      path: '/delete',
      name: 'delete',
      component: TheDelete
    }
  ]
})

export default router
