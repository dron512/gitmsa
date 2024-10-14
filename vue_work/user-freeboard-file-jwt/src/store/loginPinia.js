import { defineStore } from "pinia";

export const useLoginStore = defineStore("login",{
    state:()=>({
        loginCheck : false,
        data: "data",
        name: "홍길동"
    }),
    actions:{
        login(name){
            console.log(name);
            this.loginCheck = true;
            this.name = name;
        },
        logout(){
            this.loginCheck = false;
        }
    }
});