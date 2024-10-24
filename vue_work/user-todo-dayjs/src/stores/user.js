import { defineStore } from 'pinia';

export const useUserStore = defineStore('user', {
	state: () => ({
		loginCheck: false,
		user: null,
	}),
	actions: {
		login: () => {
			// login 성공..
			// backend 통신..
			this.loginCheck = true;
		},
		setUser(user) {
			this.user = user;
		},
	},
});
