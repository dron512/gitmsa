<template>
	<nav class="bg-white shadow-md fixed w-full z-10">
		<div class="container mx-auto px-4 sm:px-6 lg:px-8">
			<div class="flex justify-between items-center py-4">
				<!-- Logo -->
				<div class="text-2xl font-bold text-gray-800 cursor-pointer">PMH할일</div>
				<!-- Hamburger Menu (for mobile) -->
				<div class="sm:hidden">
					<button @click="menuDisply" id="menu-btn" class="text-gray-800 focus:outline-none">
						<svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
							<path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16m-7 6h7"></path>
						</svg>
					</button>
				</div>
				<!-- Navigation Links (hidden on small screens) -->
				<div class="hidden sm:flex space-x-8 text-gray-800">
					<RouterLink to="/" class="hover:text-blue-500 pt-3">HOME</RouterLink>
					<RouterLink to="/about" class="hover:text-blue-500 pt-3">ABOUT</RouterLink>
					<RouterLink to="/month" class="hover:text-blue-500 pt-3">MONTH</RouterLink>
					<RouterLink to="/message" class="hover:text-blue-500 pt-3">MESSAGE</RouterLink>
					<template v-if="useStore.loginCheck">
						<div class="w-12" @click="showNotification">
							<router-link to="/myPage"><img :src="useStore.thumbnail" class="rounded-full cursor-pointer" /></router-link>
						</div>
					</template>
					<template v-else>
						<RouterLink to="/login" class="hover:text-blue-500 pt-3">LOGIN</RouterLink>
					</template>
				</div>
			</div>
			<!-- Mobile Menu (hidden by default) -->
			<template v-if="mobileMenu">
				<div id="mobile-menu" class="bg-white">
					<RouterLink to="/" class="block px-4 py-2 text-gray-800 hover:bg-gray-100">HOME</RouterLink>
					<RouterLink to="/about" class="block px-4 py-2 text-gray-800 hover:bg-gray-100">ABOUT</RouterLink>
					<RouterLink to="/month" class="block px-4 py-2 text-gray-800 hover:bg-gray-100">MONTH</RouterLink>
					<RouterLink to="/message" class="block px-4 py-2 text-gray-800 hover:bg-gray-100">MESSAGE</RouterLink>
					<template v-if="useStore.loginCheck">
						<div class="w-12" @click="showNotification">
							<router-link to="/myPage"><img :src="useStore.thumbnail" class="rounded-full cursor-pointer" /></router-link>
						</div>
					</template>
					<template v-else>
						<RouterLink to="/login" class="block px-4 py-2 text-gray-800 hover:bg-gray-100">LOGIN</RouterLink>
					</template>
				</div>
			</template>
		</div>
		<div v-if="mVisible" class="toast">
			<div v-for="(message, index) in messages" :key="index" class="message">
				{{ message }}
			</div>
		</div>
	</nav>
</template>

<script setup>
import { loginCheck } from '@/api/loginApi';
import { useUserStore } from '@/stores/user';
import { ref, watchEffect } from 'vue';
const mobileMenu = ref(false);
const menuDisply = () => {
	mobileMenu.value = !mobileMenu.value;
};

const useStore = useUserStore();
const messages = ref([]);
const mVisible = ref(false);

watchEffect(async () => {
	if (!localStorage.getItem('token')) return;
	const res = await loginCheck();
	if (res.status.toString().startsWith('2')) {
		// console.log(res.data);
		useStore.login(res.data);
	}
});

const eventSource = new EventSource('http://localhost:20000/sse');

eventSource.onmessage = function (event) {
	messages.value = [];
	messages.value.push(event.data);
	mVisible.value = true;
	console.log(messages.value);
};

eventSource.onerror = function (event) {
	console.error('EventSource failed:', event);
	eventSource.close();
};
</script>

<style lang="scss" scoped></style>
