import './assets/main.css'

// import {aa} from './AA';
import { createApp } from 'vue'
import App from './App.vue'
// import TheHome from './views/TheHome.vue'
import router from './router/index.js'

window.Kakao.init("b91b014916c33c174c11ee8c6de62b0c");

const app = createApp(App)

app.use(router)

app.mount('#QWER')
