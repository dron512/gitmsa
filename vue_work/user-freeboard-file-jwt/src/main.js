import './assets/main.css';

import { createApp } from 'vue';
import { createPinia } from 'pinia';

import App from './App.vue';
import router from './router/index.js';

const app = createApp(App);
const piniaStore = createPinia();

app.use(router);
app.use(piniaStore);

app.mount('#QWER');
