import { defineStore } from 'pinia';

export const useUserStore = defineStore('user', {
	state: () => ({
		loginCheck: false,
		nickName: '',
		thumbnail: '',
		profileImage: '',
		email: '',
	}),
	actions: {
		login: (data) => {
			this.loginCheck = true;
			this.nickName = data.nickName;
			this.thumbnail = data.thumbnail;
			this.profileImage = data.profileImage;
			this.email = data.email;
		},
	},
});
